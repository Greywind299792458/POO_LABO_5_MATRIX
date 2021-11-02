/*
 * --------------------HEADER--------------
 * C'est un super header :o
 * -----------------------------------------------
 */

package ch.heigvd.poo.labo5.maierganty;

public class Old_Matrix {

    private int[][] elements;
    private final int modulus;
    private int colCount;
    private int lineCount;

    public Old_Matrix(int modulus, int colCount, int lineCount) {
        this.modulus = modulus;
        this.colCount = colCount;
        this.lineCount = lineCount;     // il faut qu'on implémente le "populage" de la matrice aussi ici (point 1)
    }

    public Old_Matrix(int modulus, int colCount, int lineCount, int[][] elements) {
        this(modulus, colCount, lineCount);
        this.elements = elements;
    }

    // Damien
    private boolean checkMatrix(Old_Matrix other) {
        return false;
    }

    // Elliot
    public void addition(Old_Matrix other) {
        this.addSub(other, true);
    }

    // Elliot
    public void substraction(Old_Matrix other) {

        this.addSub(other, false);
    }

    private void addSub(Old_Matrix other, boolean addition) {

        this.checkSize(other);
        for(int currentLine = 0; currentLine < this.lineCount; ++currentLine) {
            for(int currentCol = 0; currentCol < this.colCount; ++currentCol) {
                this.elements[currentLine][currentCol] +=  addition ?
                        (other.elements[currentLine][currentCol]) :
                        (-other.elements[currentLine][currentCol]);
                this.elements[currentLine][currentCol] = this.elements[currentLine][currentCol] % this.modulus;
            }
        }
    }

    private void checkSize(Old_Matrix other) {
        if(this.lineCount != other.lineCount || (this.colCount != other.colCount)) {

            int newLineCount = Math.max(this.lineCount, other.lineCount);
            int newColCount  = Math.max(this.colCount, other.colCount);

            int[][] newElements = new int[newLineCount][newColCount];

            for(int currentLine = 0; currentLine < newLineCount; ++currentLine) {
                for(int currentCol = 0; currentCol < newColCount; ++currentCol) {
                    if(currentLine < this.lineCount && currentCol < this.colCount) {
                        newElements[currentLine][currentCol] = this.elements[currentLine][currentCol];
                    } else {
                        newElements[currentLine][currentCol] = 0;
                    }
                }
            }
            this.colCount = newColCount;
            this.lineCount = newLineCount;
            this.elements = newElements;
        }
    }

    // Damien
    public void multiplication(Old_Matrix other) {

    }

    @Override
    public String toString() {      // implémentée pour tester mes fonctions on pourra la revoir ensemble
        StringBuilder result = new StringBuilder();
        for(int currentLine = 0; currentLine < this.lineCount; ++currentLine) {
            for(int currentCol = 0; currentCol < this.colCount; ++currentCol) {
                result.append(this.elements[currentLine][currentCol]).append(" ");
            }
            result.append("\n");
        }
        return result.toString();
    }
}
