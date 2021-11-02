/*
 * --------------------HEADER--------------
 * C'est un super header :o
 * -----------------------------------------------
 */

package ch.heigvd.poo.labo5.maierganty;

public class Matrix {

    private int[][] elements;
    private final int modulus;
    private int colCount;
    private int lineCount;

    public Matrix(int modulus, int colCount, int lineCount) {
        this.modulus = modulus;
        this.colCount = colCount;
        this.lineCount = lineCount;     // il faut qu'on implémente le "populage" de la matrice aussi ici (point 1)
    }

    public Matrix(int modulus, int colCount, int lineCount, int[][] elements) {
        this(modulus, colCount, lineCount);
        this.elements = elements;
    }

    // Damien
    private boolean checkMatrix(Matrix other) {
        return false;
    }

    // Elliot
    public void addition(Matrix other) {
        this.addSub(other, true);
    }

    // Elliot
    public void substraction(Matrix other) {

        this.addSub(other, false);
    }

    private void addSub(Matrix other, boolean addition) {

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

    private void checkSize(Matrix other) {
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
    public void multiplication(Matrix other) {

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
