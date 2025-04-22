import java.util.ArrayList;
import java.util.List;

public abstract class GrafikElement implements Subjekt {
    protected List<Beobachter> beobachterListe = new ArrayList<>();
    protected String name;

    public GrafikElement(String name) {
        this.name = name;
    }

    @Override
    public void registriereBeobachter(Beobachter b) {
        beobachterListe.add(b);
    }

    @Override
    public void entferneBeobachter(Beobachter b) {
        beobachterListe.remove(b);
    }

    @Override
    public void benachrichtigeBeobachter(String aktion) {
        for (Beobachter b : beobachterListe) {
            b.aktualisieren(name, aktion);
        }
    }

    public abstract void zeichnen();

    public void aendereEigenschaft() {
        System.out.println(name + ": Eigenschaft wurde geändert.");
        benachrichtigeBeobachter("Eigenschaft geändert");
    }
}
