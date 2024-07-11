class PullThread extends Thread {
    private CommandsBuffer buffer;

    public PullThread(CommandsBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            String cmd = buffer.popCommand();
            System.out.println("Executed: " + cmd);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}