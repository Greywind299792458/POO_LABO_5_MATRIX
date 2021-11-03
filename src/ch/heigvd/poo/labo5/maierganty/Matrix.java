package ch.heigvd.poo.labo5.maierganty;

import java.util.Random;

public class Matrix {

    private final int[][] elements;
    private final int modulus;
    private final int rowCount;
    private final int colCount;
    static private final Random random = new Random();

    /**
     *
     * @param modulus
     * @param elements
     * @throws RuntimeException parce que
     */
    public Matrix(int modulus, int[][] elements) {
        if (modulus < 2)
            throw new RuntimeException("modulus is smaller than 2");
        if (elements == null)
            throw new RuntimeException("elements is null");
        if (elements.length == 0) {
            throw new RuntimeException("elements has 0 rows");
        }
        int firstRowLength = elements[0].length;
        if (firstRowLength == 0) {
            throw new RuntimeException("elements has 0 columns");
        }
        for (int[] row : elements) {
            if (row.length != firstRowLength) {
                throw new RuntimeException("rows have different sizes");
            }
            for (int element : row) {
                if (element < 0) {
                    throw new RuntimeException("element " + element + " is < 0");
                }
                if (element >= modulus) {
                    throw new RuntimeException("element " + element + " is >= modulus");
                }
            }
        }
        this.modulus = modulus;
        this.rowCount = elements.length;
        this.colCount = firstRowLength;
        this.elements = deepClone2dIntArray(elements);
    }

    /**
     *
     * @param modulus
     * @param colCount
     * @param rowCount
     */
    public Matrix(int modulus, int colCount, int rowCount) {
        this(modulus, generateRandomElements(modulus, colCount, rowCount));
    }

    /**
     *
     * @param modulus
     * @param colCount
     * @param rowCount
     * @return
     * @throws RuntimeException parce que
     */
    static private int[][] generateRandomElements(int modulus, int colCount, int rowCount) {
        if (colCount <= 0) {
            throw new RuntimeException("colCount is smaller or equal to 0");
        }
        if (rowCount <= 0) {
            throw new RuntimeException("lineCount is smaller or equal to 0");
        }
        int[][] elements = new int[rowCount][colCount];
        for (int[] row : elements) {
            for (int colIndex = 0; colIndex < row.length; colIndex++) {
                row[colIndex] = random.nextInt(modulus);
            }
        }
        return elements;
    }

    /**
     *
     * @param other
     * @param operation
     * @return Matrix
     * @throws RuntimeException parce que
     */
    public Matrix executeOperation(Matrix other, Operation operation) {
        if (other == null) {
            throw new RuntimeException("other is null");
        }
        if (operation == null) {
            throw new RuntimeException("operation is null");
        }
        if (modulus != other.modulus) {
            throw new RuntimeException("the matrices have different modulus");
        }
        int[][] resultElements = new int[Math.max(rowCount, other.rowCount)][Math.max(colCount, other.colCount)];
        for (int rowIndex = 0; rowIndex < resultElements.length; rowIndex++)
            for (int colIndex = 0; colIndex < resultElements[0].length; colIndex++) {
                int operationResult = operation.execute(
                        getElementOrZero(rowIndex, colIndex),
                        other.getElementOrZero(rowIndex, colIndex));
                resultElements[rowIndex][colIndex] = operationResult % modulus;
            }
        return new Matrix(modulus, resultElements);
    }

    /**
     *
     * @return
     */
    public int[][] getElements() {
        return deepClone2dIntArray(elements);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int currentLine = 0; currentLine < this.rowCount; ++currentLine) {
            for (int currentCol = 0; currentCol < this.colCount; ++currentCol) {
                result.append(this.elements[currentLine][currentCol]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }

    /**
     *
     * @param originalArray
     * @return
     */
    private static int[][] deepClone2dIntArray(int[][] originalArray) {
        if (originalArray == null) {
            throw new NullPointerException("originalArray is null");
        }
        int[][] copy_array = new int[originalArray.length][];
        for (int rowIndex = 0; rowIndex < originalArray.length; rowIndex++) {
            copy_array[rowIndex] = originalArray[rowIndex].clone();
        }
        return copy_array;
    }

    /**
     *
     * @param rowIndex
     * @param colIndex
     * @return
     */
    private int getElementOrZero(int rowIndex, int colIndex) {
        if (rowIndex < 0) {
            throw new RuntimeException("rowIndex < 0");
        }
        if (colIndex < 0) {
            throw new RuntimeException("colIndex < 0");
        }
        return rowIndex < rowCount && colIndex < colCount ? elements[rowIndex][colIndex] : 0;
    }
}
