import java.util.concurrent.locks.ReentrantLock;

public class DeadlockExample {
   
    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    public static void operation1() {
        try {
            lock1.lock();
            System.out.println(Thread.currentThread().getName() + " acquired lock1");
            Thread.sleep(50);
            lock2.lock();
            System.out.println(Thread.currentThread().getName() + " acquired lock2");
            System.out.println(Thread.currentThread().getName() + " performing operation1");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock2.unlock();
            lock1.unlock();
        }
    }

    public static void operation2() {
        try {
            lock2.lock();
            System.out.println(Thread.currentThread().getName() + " acquired lock2");
            Thread.sleep(50);
            lock1.lock();
            System.out.println(Thread.currentThread().getName() + " acquired lock1");
            System.out.println(Thread.currentThread().getName() + " performing operation2");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock1.unlock();
            lock2.unlock();
        }
    }
}
