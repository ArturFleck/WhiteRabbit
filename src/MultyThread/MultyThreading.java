package MultyThread;

import java.util.HashMap;
import java.util.Map;

public class MultyThreading {
    public static void main(String[] args) throws InterruptedException {
        /*for (int i = 1; i < 6; i++) {
            MyThread myThing = new MyThread(i);
            Thread myThread = new Thread(myThing);
            myThread.start();

            myThread.join();
        }*/

        Map<String, Integer> empIds = new HashMap<>();
        empIds.put("Sam", 1);
        empIds.put("Ron", 2);
        empIds.put("Paul", 1);
        empIds.put("Adam", 1);

        System.out.println(empIds);
        System.out.println(empIds.size());
    }
}
