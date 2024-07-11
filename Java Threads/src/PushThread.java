class PushThread extends Thread {
    
    private CommandsBuffer buffer;

    public PushThread(CommandsBuffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            buffer.pushCommand("Command " + i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}