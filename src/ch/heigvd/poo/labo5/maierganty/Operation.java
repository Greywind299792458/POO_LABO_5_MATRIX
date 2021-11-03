/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo5: Matrix Reloaded
 * Fichier : Operation.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 03.11.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier.
 * Compilateur : OpenJDK 11
 * ---------------------------
 */
package ch.heigvd.poo.labo5.maierganty;

/**
 * Interface declaring a method that executes operations between 2 integers
 */
public interface Operation {

    /**
     * @param value1 first integer
     * @param value2 second integer
     * @return result of the operation
     * @author Elliot Ganty et Damien Maier
     */
    int execute(int value1, int value2);
}
