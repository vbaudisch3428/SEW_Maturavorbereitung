import java.util.ArrayList;
import java.util.List;

public class GrafikGruppe implements GrafikElement {
    private List<GrafikElement> elemente = new ArrayList<>();

    public void hinzufuegen(GrafikElement element) {
        elemente.add(element);
    }

    public void entfernen(GrafikElement element) {
        elemente.remove(element);
    }

    @Override
    public void zeichnen() {
        for (GrafikElement element : elemente) {
            element.zeichnen();
        }
    }
}
