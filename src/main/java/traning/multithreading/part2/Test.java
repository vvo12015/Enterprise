package traning.multithreading.part2;

import java.util.Random;
import java.util.concurrent.Exchanger;
import java.util.stream.IntStream;

public class Test {

    public void test() {
        Exchanger<String> exchanger = new Exchanger<>();
        Random random = new Random();

        IntStream.range(0, 2).forEach((i) -> new Thread(() -> {
            try {
                Thread.sleep(random.nextInt(1000));
                String name = Thread.currentThread().getName();
                System.out.println(name + " ready to exchange");
                System.out.println(name + " < - > " + exchanger.exchange(name));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
    }
}
