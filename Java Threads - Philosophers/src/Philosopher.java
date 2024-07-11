public class Philosopher extends Thread {
    
    public int counter_eating = 0; 

    private int id;
    private Fork left;
    private Fork right;

    public Philosopher(int id, Fork left, Fork right) {
        this.id = id;
        this.left = left;
        this.right = right;
        start();
    }

    void think() {
        try {
            System.out.println("philospher" + id + " thinks.");
            Thread.sleep((long) (Math.random() * 256));
        } catch (Exception e) {

        }
    }

    void eat(){

        boolean eat = false;

        System.out.println("Philosopher " + id + " is hungry.");

        while (!eat) {
            left.take();
            if (right.tryTake()) {
                counter_eating ++;
                System.out.println("Philosopher " + id + " is eating.");
                try{
                Thread.sleep((long) (Math.random() * 256));
                }
                catch(Exception e)
                {

                }
                eat = true;
                System.out.println("Philosopher " + id + " is thinks.");
                right.release();
            }
            left.release();
        }

    }
    public void run() {
        {
            long start = System.currentTimeMillis();
            long end = start + 1000;

            while (System.currentTimeMillis() < end) {
                think();
                eat();
            }
            System.out.println("Philosopher " + id + " ate " + counter_eating + " times.");
        }
    }
}
