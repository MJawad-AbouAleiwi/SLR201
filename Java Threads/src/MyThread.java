public class MyThread extends Thread{

    private String name;
    
    public MyThread(String name){
        this.name = name;
    } 

    @Override
    public void run()
    {
        for (int i = 1; i <= 100; i++) 
        {
            System.out.println(name + ": " + i);
            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(name + " END");
    }

}
