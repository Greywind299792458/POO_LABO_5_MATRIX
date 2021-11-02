/*
 * --------------------HEADER--------------
 * C'est un super header :o
 * -----------------------------------------------
 */

package ch.heigvd.poo.labo5.maierganty;

public class Matrix {

    private final int[][] elements;
    private final int modulus;
    private final int colCount;
    private final int lineCount;

    public Matrix(int modulus, int colCount, int lineCount) {

        // this() doit etre en premiere instruction... donc voir comment factoriser autrement entre les 2 constructeurs

        this.elements = new int[lineCount][colCount];// il faut qu'on implémente le "populage" de la matrice aussi ici (point 1)
        this.modulus = modulus;
        this.colCount = colCount;
        this.lineCount = lineCount;
    }

    public Matrix(int modulus, int[][] elements) {
        int[][] tmp = elements.clone(); // a voir comment copier je suis pas sure si ça copie "le dedans" aussi
        this.modulus = modulus;
        this.colCount = elements[0].length;
        this.lineCount = elements.length;
        this.elements = tmp;
    }

    public Matrix executeOperation(Matrix other, Operation operation) {
        // a faire
        return null;
    }

    // Damien
    private boolean checkMatrix(Old_Matrix other) {
        // a reflechir dessus
        return false;
    }


    private void checkSize(Old_Matrix other) {
       // a reflechir dessus
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
