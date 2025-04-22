import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Erstellen einer LinkedList zum Speichern von Strings
        LinkedList<String> farFranz = new LinkedList<>();

        // Hinzufügen von Werten
        farFranz.add("Rot");
        farFranz.add("Blau");
        farFranz.add("Grün");

        // Einfügen an beliebiger Stelle
        farFranz.add(1, "Gelb"); // zwischen Rot und Blau

        // Entfernen per Index
        farFranz.remove(2); // entfernt "Blau"

        // Entfernen per Wert
        farFranz.remove("Rot");

        // Zugriff auf bestimmte Stelle
        System.out.println("Farbe an Index 1: " + farFranz.get(1)); // "Grün"

        // Prüfen ob Element vorhanden ist
        if (farFranz.contains("Gelb")) {
            System.out.println("Gelb ist drin, Index: " + farFranz.indexOf("Gelb"));
        }

        // LinkedList-spezifische Methoden
        farFranz.addFirst("Lila");  // fügt ganz vorne ein
        farFranz.addLast("Orange"); // fügt ganz hinten ein
        farFranz.removeFirst();     // entfernt erstes Element
        farFranz.removeLast();      // entfernt letztes Element

        // Iteration
        for (String farbe : farFranz) {
            System.out.println(farbe);
        }
    }
}