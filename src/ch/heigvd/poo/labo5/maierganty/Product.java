/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo5: Matrix Reloaded
 * Fichier : Product.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 03.11.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier.
 * Compilateur : OpenJDK 11
 * ---------------------------
 */
package ch.heigvd.poo.labo5.maierganty;

/**
 * Class that represents the product operation between two integers.
 */
public class Product implements Operation {

    /**
     * @param value1 first integer
     * @param value2 second integer
     * @return result of the operation
     * @author Elliot Ganty et Damien Maier
     */
    @Override
    public int execute(int value1, int value2) {
        return value1 * value2;
    }
}
