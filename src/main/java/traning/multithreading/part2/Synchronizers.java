package traning.multithreading.part2;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.stream.IntStream;

/**
 * Created by vvo12 on 18.06.2016.
 */
public class Synchronizers {

    public static void main(String[] args) throws InterruptedException {
        Synchronizers synchronizers = new Synchronizers();
//        synchronizers.testCyclicBarrier();
        synchronizers.testExchanger();
    }


    public void testCyclicBarrier() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(5, () -> System.out.println("Barrier exceeded"));

        while (true){
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + "starts waiting on barrier");
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " finish waiting");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
            Thread.sleep(1000);
        }
    }

    public void testExchanger(){
        Exchanger<String> exchanger = new Exchanger<>();

        IntStream.range(0, 2).forEach((i) ->new Thread(() -> {
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                        String name = Thread.currentThread().getName();
                        System.out.println(name + "ready to exchange");
                        System.out.println(name + " < - >" + exchanger.exchange(name));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).start());
    }
}
