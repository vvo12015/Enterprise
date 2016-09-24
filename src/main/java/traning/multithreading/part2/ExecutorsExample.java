package traning.multithreading.part2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ExecutorsExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ExecutorsExample().testScheduledAtgFixedRate();
    }

    public void testExecutor(){
        Executor executor = Executors.newCachedThreadPool();

        System.out.println(Thread.currentThread().getName() + " submit task");
        executor.execute(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("Hello!");
            }
        });

    }

    public void testSubmit() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> f = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(1000);
                return "Task executed";
            }
        });

        System.out.println("Waiting for result");
        System.out.println("result: " + f.get());

        executorService.shutdown();
    }

     public void testExeption() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> f = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                throw new RuntimeException("Exception happened");
            }
        });

         System.out.println("Waiting for result 01");
         Thread.sleep(1000);
         System.out.println("Waiting for result 02");
         System.out.println("result: " + f.get());

         executorService.shutdown();
    }


    public void testInvokeAll() throws ExecutionException, InterruptedException {
        List<Callable<String>> callables = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, 3).forEach(i -> callables.add(() -> {
            Thread.sleep(random.nextInt(1000));
            return String.valueOf(i);
        }));

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        List<Future<String>> result = executorService.invokeAll(callables);

        for (Future f: result) {
            System.out.println(f.get());
        }

        executorService.shutdown();
    }

    public void testInvokeAny() throws ExecutionException, InterruptedException {
        List<Callable<String>> callables = new ArrayList<>();
        Random random = new Random();
        IntStream.range(0, 3).forEach(i -> callables.add(() -> {
            Thread.sleep(random.nextInt(1000));
            return String.valueOf(i);
        }));

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        String result = executorService.invokeAny(callables);

        System.out.println(result);

        executorService.shutdown();
    }

    public void testScheduled(){
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Task scheduled " + new Date());
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task executed" + new Date());
            }
        }, 1, TimeUnit.SECONDS);
    }

    public void testScheduledAtgFixedRate() throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        System.out.println("Task scheduled " + new Date());
        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("Task executed" + new Date());
            }
        }, 1, 1, TimeUnit.SECONDS);

        Thread.sleep(10_000);
        executorService.shutdown();
    }
}
