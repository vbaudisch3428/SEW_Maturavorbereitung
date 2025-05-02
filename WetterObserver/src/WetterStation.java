import java.util.ArrayList;
import java.util.List;

public class WetterStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperatur;

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperatur);
        }
    }

    public void setTemperatur(int temperatur) {
        this.temperatur = temperatur;
        notifyObservers();
    }
}
