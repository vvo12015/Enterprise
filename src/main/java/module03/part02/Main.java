package module03.part02;

import java.util.concurrent.ExecutionException;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int[] values = {50, 50, 50, 50, 50, 50, 50, 50, 50, 50};

        System.out.println(new SquareSumImpl().getSquareSum(values, 3));
    }
}
