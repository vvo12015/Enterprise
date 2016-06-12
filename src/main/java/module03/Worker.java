package module03;

import test.multithreading.station.MySemaphoreImp;

public class Worker implements Runnable {

    private MySemaphoreImp mySemaphore;
    private String workerName;
    private boolean isAdder;

    public Worker(MySemaphoreImp mySemaphore, String workerName, boolean isAdder) {
        this.mySemaphore = mySemaphore;
        this.workerName = workerName;
        this.isAdder = isAdder;
    }

    @Override
    public void run() {
        System.out.println(workerName + " started working...  (" + Thread.currentThread().getName() + ")");
        try {
            System.out.println(workerName + " waiting for cart...(" + Thread.currentThread().getName() + ")");
            mySemaphore.acquire();
            System.out.println(workerName + " got access to cart...(" + Thread.currentThread().getName() + ")");
            for (int i = 0 ; i < 10 ; i++) {
                if (isAdder)
                    Cart.reduceWeight();
                else
                    Cart.addWeight();

                System.out.println(workerName + " changed weight to: " + Cart.getWeight());
                Thread.sleep(10L);
            }
            System.out.println(workerName + " finished working with cart...");
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            try {
                mySemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}