package assembly.line;

public class TiresBuilder extends Thread {

    @Override
    public void run() {
            try {
                System.out.println("Thread " + Thread.currentThread().getName() + " starts building a tire.");
                Thread.sleep(2000);
                System.out.println("A tire was build by thread " + Thread.currentThread().getName() + "!");
            } catch (InterruptedException e) {
                System.out.println("Thread " + Thread.currentThread().getName() +
                        " was interrupted while building a tire!");
            }
    }
}
