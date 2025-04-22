public class Vorschau implements Beobachter {
    @Override
    public void aktualisieren(String elementName, String aktion) {
        System.out.println("Vorschau aktualisiert für " + elementName + ": Aktion = " + aktion);
    }
}
