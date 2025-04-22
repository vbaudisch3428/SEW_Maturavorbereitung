import java.util.concurrent.*; // Für CountDownLatch und ArrayBlockingQueue
import java.util.*;

// Hauptklasse
public class Main {

    // Gemeinsame Warteschlange mit fester Größe von 5
    private static final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

    // CountDownLatch für Producer und Consumer
    private static final CountDownLatch latch = new CountDownLatch(4); // 2 Producer + 2 Consumer

    // Gemeinsames Objekt zur Synchronisation für wait/notify
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        // Erstelle 2 Producer-Threads
        Thread producer1 = new Thread(new Producer(), "Producer-1");
        Thread producer2 = new Thread(new Producer(), "Producer-2");

        // Erstelle 2 Consumer-Threads
        Thread consumer1 = new Thread(new Consumer(), "Consumer-1");
        Thread consumer2 = new Thread(new Consumer(), "Consumer-2");

        // Startet alle Threads
        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();

        // Warte auf die Beendigung aller Threads
        latch.await(); // Hauptthread blockiert hier, bis latch == 0

        System.out.println("Alle Producer und Consumer haben ihre Arbeit beendet.");

        // Beispiel für join()
        producer1.join(); // Wartet, bis producer1 wirklich beendet ist
        System.out.println("Producer-1 wurde komplett beendet.");
    }

    // Producer-Klasse
    static class Producer implements Runnable {
        public void run() {
            try {
                for (int i = 0; i < 5; i++) { // Erzeuge 5 Elemente
                    int value = new Random().nextInt(100); // Zufälliger Wert

                    queue.put(value); // In die BlockingQueue einfügen (blockiert bei voller Queue)
                    System.out.println(Thread.currentThread().getName() + " produziert: " + value);

                    Thread.yield(); // Gebe anderen Threads die Möglichkeit zur Ausführung

                    synchronized (lock) { // Synchronisierter Block, damit notify() sicher ist
                        lock.notify(); // Weckt evtl. wartenden Consumer auf
                    }

                    Thread.sleep(100); // Simuliere Arbeitszeit
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown(); // Zähle runter, signalisiere Fertigstellung
            }
        }
    }

    // Consumer-Klasse
    static class Consumer implements Runnable {
        public void run() {
            try {
                for (int i = 0; i < 5; i++) { // Konsumiere 5 Elemente

                    synchronized (lock) { // Synchronisierung für wait()
                        while (queue.isEmpty()) { // Warte, wenn Queue leer ist
                            System.out.println(Thread.currentThread().getName() + " wartet...");
                            lock.wait(); // Warte, bis ein Producer notify() aufruft
                        }
                    }

                    Integer value = queue.take(); // Hole Element aus Queue (blockiert bei leerer Queue)
                    System.out.println(Thread.currentThread().getName() + " konsumiert: " + value);

                    Thread.sleep(150); // Simuliere Verarbeitungszeit
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown(); // Zähle runter, signalisiere Fertigstellung
            }
        }
    }
}
