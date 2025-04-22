public class Consumer implements Runnable {
    private final Together together;

    public Consumer(Together together) {
        this.together = together;
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 10) {
            synchronized (this.together) {
                i = together.getNumber();
                System.out.println("Consumed: "+i);
            }
        }
    }
}
