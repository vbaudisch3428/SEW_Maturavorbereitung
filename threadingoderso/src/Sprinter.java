import java.util.concurrent.CountDownLatch;

public class Sprinter implements Runnable {
    private String name;
    private CountDownLatch latch;

    public Sprinter(String name, CountDownLatch latch) {
        this.name = name;
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Sprinter " + this.name + " started");

        int time;
        for (int i = 1; i <= 10; i++) {
            System.out.println(this.name + " runs " + (i * 10) + " meters");

            if (i == 10) {
                System.out.println(this.name + " finished the race");
            }

            time = 500 + (int) (Math.random() * 500);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        // Signalisiert, dass dieser Sprinter fertig ist
        latch.countDown();
    }
}
