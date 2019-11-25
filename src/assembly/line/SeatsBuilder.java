package assembly.line;

public class SeatsBuilder extends Thread {

    @Override
    public void run() {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " starts building a seat.");
                Thread.sleep(3000);
                System.out.println("A seat was build by thread " + Thread.currentThread().getName() + "!");
            } catch (InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() +
                        " was interrupted while building a seat!");
            }
    }
}
