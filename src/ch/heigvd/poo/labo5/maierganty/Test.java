/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo5: Matrix Reloaded
 * Fichier : MatrixTest.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 03.11.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier.
 * Compilateur : OpenJDK 11
 * ---------------------------
 */
package ch.heigvd.poo.labo5.maierganty;

public class Test {

    public static void main(String[] args) {

        int[][] first2dArray  = {{1, 3, 1, 1}, {3, 2, 4, 2}, {1, 0, 1, 0}};
        int[][] second2dArray = {{1, 4, 2, 3, 2}, {0, 1, 0, 4, 2}, {0, 0, 2, 0, 2}};
        int modulus = 5;

        Matrix firstMatrix  = new Matrix(modulus, first2dArray);
        Matrix secondMatrix = new Matrix(modulus, second2dArray);
        String firstMatrixName  = "one";
        String secondMatrixName = "two";

        System.out.println("The modulus is " + modulus);

        printMatrix(firstMatrixName, firstMatrix);
        printMatrix(secondMatrixName,secondMatrix);

        Matrix result = firstMatrix.executeOperation(secondMatrix, new Addition());
        printMatrix(firstMatrixName + " + " + secondMatrix, result);

        result = firstMatrix.executeOperation(secondMatrix, new Substraction());
        printMatrix(firstMatrixName + " - " + secondMatrix, result);

        result = firstMatrix.executeOperation(secondMatrix, new Product());
        printMatrix(firstMatrixName + " x " + secondMatrix, result);
    }

    private static void printMatrix(String name, Matrix matrix) {
        System.out.println(name);
        System.out.println(matrix);
    }
}
