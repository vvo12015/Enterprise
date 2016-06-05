package modul01;

import java.util.Collection;

public class Main {

    static long fillingCollection(Collection<Integer> collection, int size){
        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            collection.add(i);
        }

        return System.currentTimeMillis() - start;
    }

    static long arithmeticMean(long[] times){

        long sum = 0;

        for (int i = 0; i < times.length; i++) {
            sum = times[i];
        }

        if (sum == 0) {return 0;}

        return sum / times.length;
    }
}
