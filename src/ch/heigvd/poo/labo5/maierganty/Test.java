/*
 * --------------------HEADER--------------
 * C'est un super header :o
 * -----------------------------------------------
 */

package ch.heigvd.poo.labo5.maierganty;

public class Test {
    public static void main(String[] args) {

        // petit test temporaire juste pour m'assurer que j'avais fait juste on pourra le virer
        int[][] values1 = {{1,2},{1,2}};
        Matrix matrix = new Matrix(2, 2,2, values1);
        System.out.println(matrix);

        int[][] values2 = {{1,2,3},{1,2,5}};
        Matrix matrix2 = new Matrix(2, 3,2, values2);
        System.out.println(matrix2);

        matrix.addition(matrix2);
        System.out.println(matrix);
    }
}
