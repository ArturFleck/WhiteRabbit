package sort;

public class Timmer {
    long startTime = 0;
    long stopTime = 0;

    public void on() {
        startTime = System.currentTimeMillis();
    }

    public void off() {
        stopTime = System.currentTimeMillis();
        long time = (stopTime - startTime);
        System.out.println("\nTIME is: " + time + " ms.");
        System.out.println("TIME is: " + (time/1000f) + " sec.\n");
    }
}

