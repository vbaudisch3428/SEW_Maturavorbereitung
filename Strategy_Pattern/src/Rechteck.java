public class Rechteck extends GrafikElement {
    @Override
    public void zeichnen() {
        if (strategie != null) {
            strategie.zeichnen("Rechteck");
        } else {
            System.out.println("Keine Zeichenstrategie gesetzt für Rechteck");
        }
    }
}
