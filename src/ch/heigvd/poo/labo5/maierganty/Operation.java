package ch.heigvd.poo.labo5.maierganty;

public interface Operation {    // BOOM une interface :D
    int execute(int value1, int value2);   // créer des classes qui héritent et implémenter la fonction

    String toString(Operation operation); // à discuter de l'utilité de cell-là

    // ça a mis que les "public" étaient redondants  et ça voulait pas commit avec ????
    // stack overflow : All methods in an interface are implicitly public and abstract (but not final).
}
