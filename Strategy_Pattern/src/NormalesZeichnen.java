public class NormalesZeichnen implements ZeichenStrategie {
    @Override
    public void zeichnen(String name) {
        System.out.println("Normales Zeichnen von " + name);
    }
}
