import java.util.concurrent.locks.ReentrantLock;

public class Fork{
    ReentrantLock reLock;

    public Fork(){
        reLock = new ReentrantLock();
    }

    public boolean tryTake() {
        boolean state = false;
        try {
            state = reLock.tryLock();
        } 
        catch (Exception e) {
        }
        return state;
    }

    public void take() {
        reLock.lock();
    }

    public void release() {
        reLock.unlock();
    }
}
