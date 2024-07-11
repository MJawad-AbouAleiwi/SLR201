import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class LivelockExample {

    private static ReentrantLock lock1 = new ReentrantLock();
    private static ReentrantLock lock2 = new ReentrantLock();

    public static void operation1() {
        while (true) {
            try {
                if (lock1.tryLock(50, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock1");
                    try {
                        Thread.sleep(50);
                        if (lock2.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + " acquired lock2");
                                System.out.println(Thread.currentThread().getName() + " performing operation1");
                                break;
                            } finally {
                                lock2.unlock();
                            }
                        } else {
                            continue;
                        }
                    } finally {
                        lock1.unlock();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void operation2() {
        while (true) {
            try {
                if (lock2.tryLock(50, TimeUnit.MILLISECONDS)) {
                    System.out.println(Thread.currentThread().getName() + " acquired lock2");
                    try {
                        Thread.sleep(50);
                        if (lock1.tryLock()) {
                            try {
                                System.out.println(Thread.currentThread().getName() + " acquired lock1");
                                System.out.println(Thread.currentThread().getName() + " performing operation2");
                                break;
                            } finally {
                                lock1.unlock();
                            }
                        } else {
                            continue;
                        }
                    } finally {
                        lock2.unlock();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
