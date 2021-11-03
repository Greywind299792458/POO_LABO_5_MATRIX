package ch.heigvd.poo.labo5.maierganty;

public class Addition implements Operation {
    @Override
    public int execute(int a, int b) {
        return a + b;
    }

    @Override
    public String toString(Operation operation) {
        return null;
    }
}
