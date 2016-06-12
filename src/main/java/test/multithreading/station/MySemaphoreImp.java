package test.multithreading.station;

public class MySemaphoreImp implements MySemaphore {

    private int availablePermits = 0;
    private Object lock = new Object();

    public MySemaphoreImp(int availablePermits) {
        this.availablePermits = availablePermits;
    }

    @Override
    public void acquire() throws InterruptedException {
        acquire(1);
    }

    @Override
    public void acquire(int permits) throws InterruptedException {
        synchronized (lock) {
            if (availablePermits >= permits) {
                for (int i = 0; i < permits; i++) {
                    lock.notify();
                }
                availablePermits -= permits;
            } else {
                System.out.println("Thread - " + Thread.currentThread().getName() + " has stood in the queue");
                lock.wait();
            }
        }
    }

    @Override
    public void release() throws InterruptedException {
        release(1);
    }

    @Override
    public void release(int permits) throws InterruptedException {
        synchronized (lock) {
            availablePermits += permits;
            lock.notify();
        }
    }

    @Override
    public int getAvailablePermits() {
        return this.availablePermits;
    }
}
