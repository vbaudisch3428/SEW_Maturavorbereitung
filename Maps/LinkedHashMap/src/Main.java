import java.util.*;

public class Main {
    public static void main(String[] args) {
        // LinkedHashMap erstellen
        Map<String, Integer> personen = new LinkedHashMap<>();

        // Elemente hinzufügen
        personen.put("Manfred", 30);
        personen.put("Günther", 25);
        personen.put("Franz", 27);

        // Eintrag mit null-Key
        personen.put(null, 100);

        // Eintrag mit null-Value
        personen.put("Tom", null);

        // Ausgabe – Reihenfolge entspricht der Einfügereihenfolge
        System.out.println("LinkedHashMap (Einfüge-Reihenfolge):");
        for (Map.Entry<String, Integer> eintrag : personen.entrySet()) {
            System.out.println(eintrag.getKey() + " : " + eintrag.getValue());
        }

        // Zugriff und Methoden
        System.out.println("\nWert für 'Manfred': " + personen.get("Manfred"));
        System.out.println("Enthält null-Key? " + personen.containsKey(null));
        System.out.println("Enthält Wert null? " + personen.containsValue(null));

        // Ersetzen eines Wertes
        personen.replace("Franz", 28);

        // Entfernen eines Elements
        personen.remove("Günther");

        // Größe, Leeren und Prüfung
        System.out.println("Größe: " + personen.size());
        personen.clear();
        System.out.println("Nach clear(): " + personen + " (leer? " + personen.isEmpty() + ")");
    }
}
