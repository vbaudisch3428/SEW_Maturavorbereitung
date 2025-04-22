public class Kreis extends GrafikElement {
    @Override
    public void zeichnen() {
        if (strategie != null) {
            strategie.zeichnen("Kreis");
        } else {
            System.out.println("Keine Zeichenstrategie gesetzt für Kreis");
        }
    }
}
