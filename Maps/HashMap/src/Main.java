import java.util.*;

public class Main {
    public static void main(String[] args) {
        // HashMap erstellen
        Map<String, Integer> personen = new HashMap<>();

        // Elemente hinzufügen
        personen.put("Manfred", 30);
        personen.put("Günther", 25);
        personen.put("Franz", 27);

        // Duplikat-Key – überschreibt alten Wert!
        personen.put("Manfred", 31); // vorher 30

        // null als Key ist erlaubt
        personen.put(null, 100);

        // null als Value ist auch erlaubt
        personen.put("Tom", null);

        // Ausgabe aller Einträge
        System.out.println("HashMap-Inhalt:");
        for (Map.Entry<String, Integer> eintrag : personen.entrySet()) {
            System.out.println(eintrag.getKey() + " : " + eintrag.getValue());
        }

        // Zugriff auf einen Key
        System.out.println("\nManfred ist " + personen.get("Manfred") + " Jahre alt.");

        // Key vorhanden?
        System.out.println("Enthält Franz? " + personen.containsKey("Franz"));

        // Value vorhanden?
        System.out.println("Enthält Wert 25? " + personen.containsValue(25));

        // Entfernen
        personen.remove("Günther");

        // Größe & Leerprüfung
        System.out.println("Größe: " + personen.size());
        System.out.println("Leer? " + personen.isEmpty());

        // Alles löschen
        personen.clear();
        System.out.println("Nach clear(): " + personen);
    }
}