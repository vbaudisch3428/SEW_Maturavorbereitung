import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;

class Verwaltung {
    private final CountDownLatch startSignal;
    private final BlockingQueue<Runde> resultQueue;

    public Verwaltung(int numRunners) {
        this.startSignal = new CountDownLatch(1);
        this.resultQueue = new LinkedBlockingQueue<>();
    }

    public void awaitStart() throws InterruptedException {
        startSignal.await();
    }

    public void sendStartSignal() {
        startSignal.countDown();
    }

    public void sendRoundResult(Runde result) {
        resultQueue.add(result);
    }

    public Runde receiveRoundResult() throws InterruptedException {
        return resultQueue.take();
    }
}