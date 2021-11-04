/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo5: Matrix Reloaded
 * Fichier : Test.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 03.11.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier.
 * Compilateur : OpenJDK 11
 * ---------------------------
 */
package ch.heigvd.poo.labo5.maierganty;

/**
 * This class tests the behavior of the Matrix class
 */
public class Test {

    private static int colCount1;
    private static int rowCount1;
    private static int colCount2;
    private static int rowCount2;
    private static int modulus;

    /**
     * This main method prints the content of two matrices and the result of some operations between them.
     *
     * @param args 5 integers : first matrix columns count, first matrix row count, second matrix columns count,
     *             second matrix row count, modulus
     * @author Elliot Ganty et Damien Maier
     */
    public static void main(String[] args) {
        if (readProgramArguments(args)) {
            Matrix firstMatrix = new Matrix(modulus, colCount1, rowCount1);
            Matrix secondMatrix = new Matrix(modulus, colCount2, rowCount2);
            String firstMatrixName = "one";
            String secondMatrixName = "two";

            System.out.println("The modulus is " + modulus);

            printMatrix(firstMatrixName, firstMatrix);
            printMatrix(secondMatrixName, secondMatrix);

            Matrix result = firstMatrix.executeOperation(secondMatrix, new Addition());
            printMatrix(firstMatrixName + " + " + secondMatrixName, result);

            result = firstMatrix.executeOperation(secondMatrix, new Subtraction());
            printMatrix(firstMatrixName + " - " + secondMatrixName, result);

            result = firstMatrix.executeOperation(secondMatrix, new Product());
            printMatrix(firstMatrixName + " x " + secondMatrixName, result);
        }
    }

    /**
     * Checks program argument validity and initializes static attributes according to program arguments.
     *
     * @param args program arguments as explained for the main method
     * @return false if arguments are invalid, true otherwise
     */
    private static boolean readProgramArguments(String[] args) {
        if (args.length != 5) {
            System.out.println("Error : you must provide 5 values");
            return false;
        }
        try {
            colCount1 = Integer.parseInt(args[0]);
            rowCount1 = Integer.parseInt(args[1]);
            colCount2 = Integer.parseInt(args[2]);
            rowCount2 = Integer.parseInt(args[3]);
            modulus = Integer.parseInt(args[4]);
        } catch (NumberFormatException e) {
            System.out.println("Error : all arguments must be integers");
            return false;
        }
        return true;
    }

    /**
     * Prints the content of a matrix and a name for the matrix
     *
     * @param name   name to print
     * @param matrix matrix to print
     * @author Elliot Ganty et Damien Maier
     */
    private static void printMatrix(String name, Matrix matrix) {
        System.out.println(name);
        System.out.println(matrix);
    }
}
