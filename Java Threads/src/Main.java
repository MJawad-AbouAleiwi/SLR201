public class Main {
    public static void main(String[] args) {
        // Ex 1
        /*MyThread thread1 = new MyThread("Thread-1");
        MyThread thread2 = new MyThread("Thread-2");

        thread1.start();
        thread2.start();*/

        // Ex 2
        CommandsBuffer buffer = new CommandsBuffer();
        PushThread pushThread = new PushThread(buffer);
        PullThread pullThread = new PullThread(buffer);

        pushThread.start();
        pullThread.start();

        try {
            pushThread.join();
            pullThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
