public class Main {
    public static void main(String[] args) {
        GrafikElement kreis = new Kreis();
        kreis.setStrategie(new NormalesZeichnen());
        kreis.zeichnen();

        GrafikElement rechteck = new Rechteck();
        rechteck.setStrategie(new SchattenZeichnen());
        rechteck.zeichnen();

        kreis.setStrategie(new FarbZeichnen());
        kreis.zeichnen();
    }
}
