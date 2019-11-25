package assembly.line;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CarBuilder {

    public static void main(String[] args) {

        Thread engineBuilder = new Thread(() -> {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " starts building an engine.");
                Thread.sleep(7000);
                System.out.println("The engine was build by thread " + Thread.currentThread().getName() + "!");
            } catch (InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted while building the engine!");
            }
        });

        Runnable frame = () -> {
          try {
              System.out.println("Thread " + Thread.currentThread().getName() + " starts building a frame:");
              Thread.sleep(5000);
              System.out.println("The frame was build by thread " + Thread.currentThread().getName() + "!");
          } catch (InterruptedException e) {
              System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted while building the frame!");
          }
        };

        Thread frameBuilder = new Thread(frame);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(engineBuilder);
        executor.execute(new TiresBuilder());
        executor.execute(new SeatsBuilder());
        executor.execute(new TiresBuilder());
        executor.execute(new SeatsBuilder());
        executor.execute(new TiresBuilder());
        executor.execute(new SeatsBuilder());
        executor.execute(new SeatsBuilder());
        executor.execute(frameBuilder);
        executor.execute(new TiresBuilder());
        executor.execute(new SeatsBuilder());
        executor.shutdown();

        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println("Thread " + Thread.currentThread().getName() + " was interrupted while waiting the " +
                    "executor service to finish its work!");
        }

        System.out.println("The car is BUILD!");
    }
}
