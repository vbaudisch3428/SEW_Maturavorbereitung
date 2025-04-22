import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Erstellen einer ArrayList zum Speichern von Strings
        List<String> tiere = new ArrayList<>();

        // Hinzufügen von Werten
        tiere.add("Hund");
        tiere.add("Katze");
        tiere.add("Maus");

        // Einfügen an beliebiger Stelle
        tiere.add(1, "Fuchs"); // fügt an Index 1 ein

        // Entfernen eines Elements per Index
        tiere.remove(2); // entfernt "Katze"

        // Entfernen per Wert
        tiere.remove("Hund");

        // Zugriff auf bestimmte Stelle
        System.out.println("Index 1: " + tiere.get(1)); // "Maus"

        // Prüfen ob Element vorhanden ist
        if (tiere.contains("Fuchs")) {
            System.out.println("Fuchs gefunden an Index: " + tiere.indexOf("Fuchs"));
        }

        // Wichtige Methoden
        System.out.println("Größe der Liste: " + tiere.size());
        System.out.println("Ist leer? " + tiere.isEmpty());

        // Iteration
        for (String tier : tiere) {
            System.out.println(tier);
        }
    }
}