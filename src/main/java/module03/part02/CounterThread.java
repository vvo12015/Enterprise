package module03.part02;

import java.util.Arrays;
import java.util.concurrent.Callable;
import java.util.concurrent.Phaser;

class CounterThread implements Callable<Integer>{

    Phaser phaser;
    int[] values;

    CounterThread(Phaser p, int[] values){

        this.phaser=p;
        this.values = values;
        phaser.register();
    }
    public Integer call(){

        int sum = Arrays.stream(values).map((i) ->((i) *= i)).sum();
        phaser.arriveAndAwaitAdvance(); // сообщаем, что первая фаза достигнута
        return sum;
    }
}
