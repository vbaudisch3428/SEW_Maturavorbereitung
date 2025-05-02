public class Lager {
    private int bestand = 0;          // Anzahl verfügbarer Produkte
    private final int MAX = 1;        // Maximale Kapazität des Lagers (für Einfachheit: 1)

    // Methode, die vom Produzent aufgerufen wird
    public synchronized void produzieren() throws InterruptedException {
        // Wenn Lager voll ist, muss Produzent warten
        while (bestand >= MAX) {
            System.out.println("Produzent wartet...");
            wait();  // gibt das Lock frei und wartet
        }

        // Produkt "herstellen"
        bestand++;
        System.out.println("Produzent hat produziert. Bestand: " + bestand);

        // Konsumenten informieren, dass ein Produkt verfügbar ist
        notifyAll();
    }

    // Methode, die vom Konsument aufgerufen wird
    public synchronized void konsumieren() throws InterruptedException {
        // Wenn kein Produkt vorhanden ist, muss Konsument warten
        while (bestand == 0) {
            System.out.println("Konsument wartet...");
            wait();  // gibt das Lock frei und wartet
        }

        // Produkt "verbrauchen"
        bestand--;
        System.out.println("Konsument hat konsumiert. Bestand: " + bestand);

        // Produzenten informieren, dass wieder Platz ist
        notifyAll();
    }
}
