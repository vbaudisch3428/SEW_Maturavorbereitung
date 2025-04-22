public class Producer implements Runnable {
    private final Together together;

    public Producer(Together together) {
        this.together = together;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            synchronized (this.together) {
                together.setNumber(i);
                System.out.println("Produced: "+i);
            }

        }
    }
}
