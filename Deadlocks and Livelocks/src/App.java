public class App {
    public static void main(String[] args) throws Exception {
        // DeadlockExample
        Thread T1 = new Thread(DeadlockExample::operation1);
        Thread T2 = new Thread(DeadlockExample::operation2);

        T1.start();
        T2.start();

        try {
            T1.join();
            T2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // LivelockExample
        /*Thread T1 = new Thread(LivelockExample::operation1, "T1");
        Thread T2 = new Thread(LivelockExample::operation2, "T2");

        T1.start();
        T2.start();

        try {
            T1.join();
            T2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
