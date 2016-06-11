package test.multithreading;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SynchronizedExample {

    private int counter;
    private final Object lock = new Object();


    public static void main(String[] args) throws InterruptedException {
        new SynchronizedExample().test();
    }

    public synchronized int increment(){
            return counter++;
    }

    public void test() throws InterruptedException {

        List<Aggregator> aggregates = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Aggregator aggregator = new Aggregator();
            aggregates.add(aggregator);
            new Thread(aggregator).start();
        }

        Thread.sleep(100);
        boolean isValid = true;
        Set<Integer> set = new HashSet<>();

        for (Aggregator aggregator :
                aggregates) {
            for (Integer anInt :
                    aggregator.ints) {
                if (!set.add(anInt)){
                    System.out.println("Error, duplicate found: " + anInt);
                    isValid = false;
            }
        }

        }
        if (isValid){
            System.out.println("No duplicates");
        }

    }

    public class Aggregator implements Runnable{

        private List<Integer> ints = new ArrayList<>();

        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                ints.add(increment());
            }
        }
    }
}
