public class Main {
    public static void main(String[] args) {
        GrafikElement kreis = new Kreis();
        GrafikElement rechteck = new Rechteck();

        Beobachter logger = new Logger();
        Beobachter vorschau = new Vorschau();

        kreis.registriereBeobachter(logger);
        kreis.registriereBeobachter(vorschau);

        rechteck.registriereBeobachter(logger);

        kreis.zeichnen();
        kreis.aendereEigenschaft();

        rechteck.zeichnen();
        rechteck.aendereEigenschaft();
    }
}
