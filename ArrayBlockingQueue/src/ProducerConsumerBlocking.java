import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerBlocking implements ProducerConsumerQueue{
    private final int capacity = 10;
    private final BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(capacity);

    @Override
    public void produce() {
        try{
            while(true){
                int producedItem = produceItem();
                queue.put(producedItem);
                System.out.println("Produced Item: "+producedItem);
            }
        }
        catch(InterruptedException e){
            System.err.println("Producer was interrupted:  "+e);
        }
    }

    @Override
    public void consume() {
        try{
            while(true){
                int consumedItem = queue.take();
                System.out.println("Consumed Item: "+consumedItem);
            }
        }
        catch (InterruptedException e){
            System.err.println("Consumer was interrupted:  "+e);
        }
    }

    private int produceItem() {
        return (int) (Math.random()*100);
    }
}
