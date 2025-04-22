import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        synchronisedCounterExample();
    }

    private static void synchronisedCounterExample() {
        final long incrementNumber = 1000000;
        final long threadNumber = 100;

        final Counter counter = new Counter();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i <= incrementNumber; i++) {
                    counter.increment();
                }
            }
        };

        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 1; i <= threadNumber; i++) {
            Thread thread = new Thread(runnable);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        long total = incrementNumber * threadNumber;
        System.out.println("Counter should be: " + total);
        System.out.println("Counter is: "+counter.getNumber());
    }
}