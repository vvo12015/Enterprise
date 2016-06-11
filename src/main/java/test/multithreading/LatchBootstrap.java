package test.multithreading;

public class LatchBootstrap {

    public static final int COUNTER_THREADS = 10;

    public static void main(String[] args) {
        new LatchBootstrap().test();
    }

    private CountDownLatch countDownLatch;

    public void test(){
        countDownLatch = new CountDownLatch(COUNTER_THREADS);

        for (int i = 0; i < COUNTER_THREADS; i++) {
            new Thread(new Worker()).start();
        }

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (countDownLatch.getCounter() > 0){
                    countDownLatch.countDown();
                }
            }
        }).start();
    }

    private class Worker implements Runnable{

        @Override
        public void run() {
            try {
                System.out.println("Thread - " + Thread.currentThread().getName() + " start waiting");
                countDownLatch.await();
                System.out.println("Thread" + Thread.currentThread().getName() + " stop waiting");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}