public class Together {
    private int number;
    private boolean writable = true;

    public synchronized void setNumber(int number) {
        while (!writable) {
            try{
                wait(); // Wenn writable false ist, darf Producer noch nicht schreiben
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.number = number;
        this.writable = false; // Schreiben abgeschlossen, jetzt darf der Consumer lesen
        notify(); // Wecke den wartenden Consumer
    }

    public synchronized int getNumber() {
        while (this.writable) {
            try{
                wait(); // Wenn writable true ist, gibt es nichts Neues zum Lesen
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        int numCopy = this.number;
        this.writable = true; // Gelesen! Jetzt darf wieder produziert werden
        notify(); // Wecke den Producer
        return numCopy;
    }
}
