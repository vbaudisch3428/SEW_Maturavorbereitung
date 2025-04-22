import java.util.*;

public class Main {
    public static void main(String[] args) {
        // TreeSet erstellen
        TreeSet<String> namen = new TreeSet<>();

        // Hinzufügen
        namen.add("Manfred");
        namen.add("Günther");
        namen.add("Franz");

        // Sortierung prüfen
        System.out.println("Sortierte Reihenfolge:");
        for (String name : namen) {
            System.out.println(name);
        }

        // Duplikat (wird ignoriert)
        namen.add("Günther");

        // null hinzufügen – FEHLER!
        try {
            namen.add(null); // wirft NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Fehler beim Hinzufügen von null: " + e);
        }

        // Erste & letzte Elemente
        System.out.println("Erstes Element: " + namen.first());
        System.out.println("Letztes Element: " + namen.last());

        // Entfernen
        namen.remove("Franz");

        // Enthält?
        System.out.println("Enthält Manfred? " + namen.contains("Manfred"));

        // Größe und löschen
        System.out.println("Größe: " + namen.size());
        namen.clear();
        System.out.println("Nach clear(): " + namen);
    }
}