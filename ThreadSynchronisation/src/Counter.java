public class Counter {
    private long number;

    public long getNumber() {
        return this.number;
    }

    // public void increment() { würde dafür sorgen dass sich die Threads im Weg stehen und das Ergenbis falsch ist
    public synchronized void increment() {
        this.number++;
    }
}
