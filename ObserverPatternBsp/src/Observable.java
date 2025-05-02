public interface Observable {
    boolean addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(JobPost jobPost);
}
