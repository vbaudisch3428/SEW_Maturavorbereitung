import java.util.*;

public class Main {
    public static void main(String[] args) {
        // HashSet erstellen
        HashSet<String> tiere = new HashSet<>();

        // Hinzufügen von Werten
        tiere.add("Hund");
        tiere.add("Katze");
        tiere.add("Vogel");

        // Duplikat hinzufügen (wird ignoriert)
        boolean hinzugefügt = tiere.add("Hund");
        System.out.println("Duplikat hinzugefügt? " + hinzugefügt); // false

        // null hinzufügen (erlaubt)
        tiere.add(null);

        // Entfernen per Wert
        tiere.remove("Katze");

        // Prüfen ob Element vorhanden ist
        if (tiere.contains("Hund")) {
            System.out.println("Hund ist vorhanden.");
        }

        // Größe
        System.out.println("Größe des Sets: " + tiere.size());

        // Iteration (Reihenfolge ist nicht garantiert!)
        for (String tier : tiere) {
            System.out.println(tier);
        }

        // Alles löschen
        tiere.clear();
        System.out.println("Nach clear(): " + tiere);
    }
}