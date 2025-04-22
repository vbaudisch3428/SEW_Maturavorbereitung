public class Rechteck extends GrafikElement {
    public Rechteck() {
        super("Rechteck");
    }

    @Override
    public void zeichnen() {
        System.out.println("Rechteck zeichnen");
        benachrichtigeBeobachter("gezeichnet");
    }
}
