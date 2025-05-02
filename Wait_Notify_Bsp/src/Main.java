public class Main {
    public static void main(String[] args) {
        Lager lager = new Lager(); // Erzeuge das gemeinsame Lager

        Produzent p = new Produzent(lager); // Erzeuge einen Produzent-Thread
        Konsument k = new Konsument(lager); // Erzeuge einen Konsument-Thread

        p.start(); // Starte Produzent
        k.start(); // Starte Konsument
    }
}
