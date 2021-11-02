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
        Old_Matrix oldMatrix = new Old_Matrix(2, 2,2, values1);
        System.out.println(oldMatrix);

        int[][] values2 = {{1,2,3},{1,2,5}};
        Old_Matrix oldMatrix2 = new Old_Matrix(2, 3,2, values2);
        System.out.println(oldMatrix2);

        oldMatrix.addition(oldMatrix2);
        System.out.println(oldMatrix);
    }
}
