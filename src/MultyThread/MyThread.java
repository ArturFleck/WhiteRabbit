package MultyThread;

public class MyThread implements Runnable{

    private int threadNumber;
    public MyThread (int threadNumber){
        this.threadNumber = threadNumber;
    }

    @Override
    public void run(){
        for (int i=1; i<6;i++){
            System.out.println("Thread:" + threadNumber + " -> " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}
