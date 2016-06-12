package module03;

public class SemaphoreImp implements Semaphore{

    private int availablePermits = 0;

    public SemaphoreImp(int availablePermits) {
        this.availablePermits = availablePermits;
    }

    @Override
    public void acquire() {
        if (availablePermits > 0){

        }
    }

    @Override
    public void acquire(int permits) {

    }

    @Override
    public void release() {

    }

    @Override
    public void release(int permits) {

    }

    @Override
    public int getAvailablePermits() {
        return this.availablePermits;
    }
}
