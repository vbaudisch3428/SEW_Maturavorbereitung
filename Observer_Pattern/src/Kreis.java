public class Kreis extends GrafikElement {
    public Kreis() {
        super("Kreis");
    }

    @Override
    public void zeichnen() {
        System.out.println("Kreis zeichnen");
        benachrichtigeBeobachter("gezeichnet");
    }
}
