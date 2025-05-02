import java.util.ArrayList;
import java.util.List;

public class EmploymentAgency implements Observable{
    private List<Observer> observers = new ArrayList<>();

    @Override
    public boolean addObserver(Observer o) {
        try{
            observers.add(o);
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void removeObserver(Observer o) {
        System.out.println(observers.remove(o));
    }

    @Override
    public void notifyObservers(JobPost jobPost) {
        for (Observer o : observers) {
            o.onJobPosted(jobPost);
        }
    }

    public void addJob(JobPost jobPost) {
        notifyObservers(jobPost);
    }
}
