
public class Main {
    public static void main(String[] args) {
        ProducerConsumerQueue queue = new ProducerConsumerBlocking();
        Thread producerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.produce();  // Aufruf der produce-Methode
            }
        });

        Thread consumerThread = new Thread(new Runnable() {
            @Override
            public void run() {
                queue.consume();  // Aufruf der consume-Methode
            }
        });


        producerThread.start();
        consumerThread.start();

    }
}