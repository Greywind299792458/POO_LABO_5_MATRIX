package ch.heigvd.poo.labo5.maierganty;

public class Matrix {

    private int[][] elements;
    private final int modulus;
    private final int colCount;
    private final int lineCount;

    public Matrix(int modulus, int colCount, int lineCount) {
        this.modulus = modulus;
        this.colCount = colCount;
        this.lineCount = lineCount;
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

    }

    // Elliot
    public void substraction(Matrix other) {

    }

    // Damien
    public void multiplication(Matrix other) {

    }
}
