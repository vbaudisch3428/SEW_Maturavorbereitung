import java.util.*;

public class Main {
    public static void main(String[] args) {
        // TreeMap erstellen
        Map<String, Integer> personen = new TreeMap<>();

        // Elemente hinzufügen
        personen.put("Manfred", 30);
        personen.put("Günther", 25);
        personen.put("Franz", 27);

        // Key null – wirft Ausnahme
        try {
            personen.put(null, 100); // funktioniert NICHT bei TreeMap
        } catch (NullPointerException e) {
            System.out.println("Fehler beim Hinzufügen von null: " + e);
        }

        // Ausgabe – automatisch nach Key sortiert
        System.out.println("TreeMap (alphabetisch sortiert):");
        for (Map.Entry<String, Integer> eintrag : personen.entrySet()) {
            System.out.println(eintrag.getKey() + " : " + eintrag.getValue());
        }

        // Zugriff auf einen bestimmten Key
        System.out.println("\nFranz ist " + personen.get("Franz") + " Jahre alt.");

        // Key und Value prüfen
        System.out.println("Enthält Günther? " + personen.containsKey("Günther"));
        System.out.println("Enthält Wert 30? " + personen.containsValue(30));

        // Einen Eintrag ersetzen
        personen.replace("Manfred", 31);

        // Entfernen
        personen.remove("Günther");

        // Map-Größe und leeren
        System.out.println("Größe: " + personen.size());
        personen.clear();
        System.out.println("Nach clear(): " + personen + " (leer? " + personen.isEmpty() + ")");
    }
}