import java.util.concurrent.locks.Lock;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class Cabinet {
    private final BlockingQueue<Student> queue;
    private final Lock lock;
    private final Condition robotOccupied;

    Cabinet() {
        queue = new LinkedBlockingQueue<>(10);
        lock = new ReentrantLock();
        robotOccupied = lock.newCondition();
    }

    public BlockingQueue<Student> getQueue(){
        return queue;
    }

    public Lock getLock() {
        return lock;
    }

    public Condition getRobotOccupied() {
        return robotOccupied;
    }
}
