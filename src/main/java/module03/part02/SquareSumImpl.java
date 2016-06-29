package module03.part02;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class SquareSumImpl implements SquareSum {

    @Override
    public long getSquareSum(int[] values, int numberOfThreads) throws ExecutionException, InterruptedException {

        if (values.length <= numberOfThreads){
            numberOfThreads = values.length;
        }

        int countCellsOnThread = values.length / numberOfThreads;
        int countOfThreadHarder = values.length % numberOfThreads;

        Phaser phaser = new Phaser(1);

        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        List<Future<Integer>> sums = new ArrayList<>();

        int position = 0;
        int offset = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            int amendmentOnHarderForThread = 0;
            if (i < countOfThreadHarder){
                amendmentOnHarderForThread = 1;
            }
            int countCellsForCopy = countCellsOnThread + amendmentOnHarderForThread;
            int[] ints = new int[countCellsForCopy];
            position += offset;
            System.arraycopy(values, position, ints, 0, ints.length);
            offset = countCellsForCopy;
            sums.add(executorService.submit(new CounterThread(phaser, ints)));
        }

        phaser.arriveAndDeregister();

        int sum = 0;

        for (Future<Integer> f :
                sums) {
            sum += f.get();
        }

        executorService.shutdown();
        return sum;
    }
}
