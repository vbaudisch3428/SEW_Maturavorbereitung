import java.util.ArrayList;
import java.util.List;

class GraphicGroup implements Graphic {
    private List<Graphic> elements = new ArrayList<>();
    public void add(Graphic g) { elements.add(g); }
    public void draw() {
        for (Graphic g : elements) g.draw();
    }
}