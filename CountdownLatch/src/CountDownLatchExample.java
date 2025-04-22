import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample implements Runnable {

    private final static int THREAD_COUNT = 3;

    @Override
    public void run() {
        final CountDownLatch firstStartersSignal = new CountDownLatch(1);
        final CountDownLatch yellowFinishLine = new CountDownLatch(THREAD_COUNT);
        final CountDownLatch secondStartersSignal = new CountDownLatch(1);
        final CountDownLatch redFinishLine = new CountDownLatch(THREAD_COUNT);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                try {
                    // Wait for first starters signal
                    printMessage("Waiting for first starters signal");
                    firstStartersSignal.await();

                    // Run to yellow finish line
                    printMessage("Run to yellow finish line");
                    Thread.sleep((int) (Math.random() * 1000));
                    printMessage("Reached yellow finish line");
                    yellowFinishLine.countDown();

                    // Wait for second starters signal
                    printMessage("Waiting for second starters signal");
                    secondStartersSignal.await();

                    // Run to red finish line
                    printMessage("Run to red finish line");
                    Thread.sleep((int) (Math.random() * 1000));
                    printMessage("Reached red finish line");
                    redFinishLine.countDown();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        try {
            // Create and start all threads
            Thread[] threads = new Thread[THREAD_COUNT];
            for (int i = 0; i < THREAD_COUNT; i++) {
                threads[i] = new Thread(runnable, "Runner-" + (i + 1));
                threads[i].start();
            }

            // Start first part of race
            printMessage("Let the race to yellow finish line begin!");
            firstStartersSignal.countDown();

            // Wait for all threads to reach yellow finish line
            yellowFinishLine.await();
            printMessage("All runners reached yellow finish line!");

            // Start second part of race
            printMessage("Let the race to red finish line begin!");
            secondStartersSignal.countDown();

            // Wait for all threads to reach red finish line
            redFinishLine.await();
            printMessage("All runners reached red finish line!");

            printMessage("Race is over!");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void printMessage(String message) {
        System.out.println(LocalDateTime.now() + ": " + Thread.currentThread().getName() + ": " + message);
    }

    public static void main(String[] args) {
        new CountDownLatchExample().run();
    }
}
