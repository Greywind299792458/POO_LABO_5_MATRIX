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

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class that implements unit tests for the Matrix class using and testing the Operation class as well
 */
class MatrixTest {
    private final int[][] elements = {{8, 9, 4}, {0, 3, 2}};
    private final Matrix matrix1 = new Matrix(10, elements);
    private final int[][] elements2 = {{3}, {4}};
    private final Matrix matrix2 = new Matrix(10, elements2);

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    void constructorWithElementsShouldThrowRuntimeExceptionIfAnArgumentIsInvalid() {
        assertThrows(RuntimeException.class, () -> {
                    new Matrix(0, new int[][]{{0}});
                },
                "must throw exception if modulus < 1");

        assertThrows(RuntimeException.class, () -> {
                    new Matrix(10, null);
                },
                "must throw exception if elements is null");

        assertThrows(RuntimeException.class, () -> {
                    new Matrix(10, new int[][]{new int[2], new int[1]});
                },
                "must throw exception if subarrays have different sizes");

        assertThrows(RuntimeException.class, () -> {
                    new Matrix(10, new int[0][]);
                },
                "must throw exception if elements has 0 row");

        assertThrows(RuntimeException.class, () -> {
                    new Matrix(10, new int[][]{new int[0]});
                },
                "must throw exception if elements has 0 columns");

        assertThrows(RuntimeException.class, () -> {
                    new Matrix(9, elements);
                },
                "must throw exception if any element >= modulus");

        assertThrows(RuntimeException.class, () -> {
                    new Matrix(10, new int[][]{{1, 2}, {-1, 1}});
                },
                "must throw exception if any element < 0");
    }

    @org.junit.jupiter.api.Test
    void constructorWithElementsShouldWork() {
        Matrix matrix = new Matrix(10, elements);
        assertTrue(Arrays.deepEquals(matrix.getElements(), elements));
    }

    @org.junit.jupiter.api.Test
    void constructorWithElementsShouldCopyElements() {
        int[][] array = {{1}};
        Matrix testMatrix = new Matrix(10, array);
        array[0][0] = 2;
        assertEquals(1, testMatrix.getElements()[0][0]);
    }

    @org.junit.jupiter.api.Test
    void randomConstructorShouldThrowRuntimeExceptionIfAnArgumentIsInvalid() {
        assertThrows(RuntimeException.class, () -> {
                    new Matrix(0, 10, 20);
                },
                "must throw exception if modulus < 1");

        assertThrows(RuntimeException.class, () -> {
                    new Matrix(10, 0, 20);
                },
                "must throw exception if colCount < 1");

        assertThrows(RuntimeException.class, () -> {
                    new Matrix(10, 10, 0);
                },
                "mest throw exception if rowCount < 1");

    }

    @org.junit.jupiter.api.Test
    void randomConstructorShouldGenerateCorrectDimensions() {
        int colCount = 20;
        int lineCount = 30;
        int[][] matrixElements = new Matrix(10, colCount, lineCount).getElements();
        assertEquals(lineCount, matrixElements.length);
        for (int[] row : matrixElements) {
            assertEquals(colCount, row.length);
        }
    }

    @org.junit.jupiter.api.Test
    void randomConstructorShouldGenerateCorrectElements() {
        int modulus = 10;
        int[][] matrixElements = new Matrix(modulus, 20, 30).getElements();
        for (int[] row : matrixElements) {
            for (int element : row) {
                assertTrue(0 <= element);
                assertTrue(element < modulus);
            }
        }
    }

    @org.junit.jupiter.api.Test
    void getElementsShouldReturnACopy() {
        Matrix testMatrix = new Matrix(10, new int[][]{{1}});
        int[][] array = testMatrix.getElements();
        array[0][0] = 2;
        assertEquals(1, testMatrix.getElements()[0][0]);
    }


    @org.junit.jupiter.api.Test
    void executeOperatoinShouldThrowRuntimeExceptionIfAnArgumentIsInvalid(){
        assertThrows(RuntimeException.class, () -> {
                    matrix1.executeOperation(null, new Addition());
                },
                "must throw exception if other matrix is null");

        assertThrows(RuntimeException.class, () -> {
                    matrix1.executeOperation(matrix2, null);
                },
                "must throw exception if operation is null");
    }

    @org.junit.jupiter.api.Test
    void executeOperationShouldThrowRuntimeExceptionIfModulusDontMatch() {
        Matrix matrix3 = new Matrix(9, 10, 10);
        assertThrows(RuntimeException.class, () -> {
            matrix1.executeOperation(matrix3, new Addition());
        });
    }

    @org.junit.jupiter.api.Test
    void additionOperationShouldWork() {
        assertTrue(Arrays.deepEquals(
                new int[][]{{1, 9, 4}, {4, 3, 2}},
                (matrix1.executeOperation(matrix2, new Addition()).getElements())));
    }

    @org.junit.jupiter.api.Test
    void subtractionOperationShouldWork() {
        assertTrue(Arrays.deepEquals(
                new int[][]{{5, 9, 4}, {6, 3, 2}},
                (matrix1.executeOperation(matrix2, new Subtraction()).getElements())));
    }

    @org.junit.jupiter.api.Test
    void productOperationShouldWork() {
        assertTrue(Arrays.deepEquals(
                new int[][]{{4, 0, 0}, {0, 0, 0}},
                (matrix1.executeOperation(matrix2, new Product()).getElements())));
    }
}