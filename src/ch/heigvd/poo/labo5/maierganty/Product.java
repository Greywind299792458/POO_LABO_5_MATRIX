package ch.heigvd.poo.labo5.maierganty;

public class Product implements Operation {
    @Override
    public int execute(int value1, int value2) {
        return value1 * value2;
    }

    @Override
    public String toString(Operation operation) {
        return null;
    }
}
