public class Logger implements Beobachter {
    @Override
    public void aktualisieren(String elementName, String aktion) {
        System.out.println("Logger: " + elementName + " wurde " + aktion + ".");
    }
}
