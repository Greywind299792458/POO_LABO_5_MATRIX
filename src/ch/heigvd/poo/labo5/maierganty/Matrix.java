/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo5: Matrix Reloaded
 * Fichier : Matrix.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 03.11.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier.
 * Compilateur : OpenJDK 11
 * ---------------------------
 */
package ch.heigvd.poo.labo5.maierganty;

import java.util.Random;

/**
 * Class that represents Matrix's of NxM size (N,M > 0) filled with either random values or given values.
 * In both cases a Matrix has a modulus and all elements are between 0 and the modulus(not included).
 * Matrices are immutables.
 */
public class Matrix {

    private final int[][] elements;
    private final int modulus;
    private final int rowCount;
    private final int colCount;
    /**
     * random values generator that is used by the generateRandomElements method
     */
    private static final Random random = new Random();

    /**
     * Constructs a matrix with specified values.
     *
     * @param modulus  ( > 0)
     * @param elements matrix component's values
     *                 (nbr of columns and rows must be > 0, all lines must have the same size,
     *                 values must be positive and smaller than the modulus)
     * @throws RuntimeException if the parameters are invalid according to the specifications above
     * @author Elliot Ganty et Damien Maier
     */
    public Matrix(int modulus, int[][] elements) {
        if (modulus < 1)
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
     * Constructs a matrix with random values.
     *
     * @param modulus  ( > 0)
     * @param colCount number of columns ( > 0)
     * @param rowCount number of lines ( > 0)
     * @throws RuntimeException if the parameters are invalid according to the specifications above
     * @author Elliot Ganty et Damien Maier
     */
    public Matrix(int modulus, int colCount, int rowCount) {
        // arguments validity is checked by generateRandomElements and by the other constructor
        this(modulus, generateRandomElements(modulus, colCount, rowCount));
    }

    /**
     * Returns a new Matrix which is the result of a given operation between the current and a given matrix
     * (operation is done component by component).
     *
     * @param other     second Matrix ( cannot be null)
     * @param operation selected operation to apply ( cannot be null)
     * @return result of operation
     * @throws RuntimeException if the other matrix or the operation is null or if moduli are different
     * @author Elliot Ganty et Damien Maier
     */
    public Matrix executeOperation(Matrix other, Operation operation) {
        if (other == null) {
            throw new RuntimeException("other is null");
        }
        if (operation == null) {
            throw new RuntimeException("operation is null");
        }
        if (modulus != other.modulus) {
            throw new RuntimeException("the matrices have different moduli");
        }
        int[][] resultElements = new int[Math.max(rowCount, other.rowCount)][Math.max(colCount, other.colCount)];
        for (int rowIndex = 0; rowIndex < resultElements.length; rowIndex++)
            for (int colIndex = 0; colIndex < resultElements[0].length; colIndex++) {
                int operationResult = operation.execute(
                        getElementOrZero(rowIndex, colIndex),
                        other.getElementOrZero(rowIndex, colIndex));
                resultElements[rowIndex][colIndex] = Math.floorMod(operationResult, modulus);
            }
        return new Matrix(modulus, resultElements);
    }

    /**
     * Returns a copy of the elements of the matrix.
     *
     * @return the deep copy
     * @author Elliot Ganty et Damien Maier
     */
    public int[][] getElements() {
        return deepClone2dIntArray(elements);
    }

    /**
     * Prints the content of the matrix.
     *
     * @return the String representation of the matrix
     * @author Elliot Ganty et Damien Maier
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
     * Generates a 2D array of int filled with random values based on the given modulus.
     *
     * @param modulus  ( > 0)
     * @param colCount number of columns ( > 0)
     * @param rowCount number of rows ( > 0)
     * @return the 2D array of int with random elements
     * @throws RuntimeException if the given parameters are invalid according to the specifications above
     * @author Elliot Ganty et Damien Maier
     */
    private static int[][] generateRandomElements(int modulus, int colCount, int rowCount) {
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
     * Returns a deep copy of a 2D array of int.
     *
     * @param originalArray array to copy ( cannot be null)
     * @return the deep copy
     * @throws NullPointerException if the originalArray is null
     * @author Elliot Ganty et Damien Maier
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
     * Returns the required matrix element. If the requested position is out of matrix bounds, returns 0.
     *
     * @param rowIndex row index
     * @param colIndex column index
     * @return value that will be fetched from the Matrix or 0
     * @throws RuntimeException if any index is negative
     * @author Elliot Ganty et Damien Maier
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
