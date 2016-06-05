package modul01;

import com.sun.javafx.geom.AreaOp;
import com.sun.org.apache.regexp.internal.RE;

import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ComparatorList {

    public static final int COUNT_SIZES_OF_COLLECTIONS = 3;
    public static final int[] SIZES_COLLECTION = {10000, 100000, 1000000};
    public static final int COUNT_METERING = 200;

    private static long[] timesForMetering = new long[COUNT_METERING];
    private List list;

    public long[] comparatorMethods(Methods method) {

        long[] timesForCollections = new long[COUNT_SIZES_OF_COLLECTIONS];

        long start;
        ListIterator<Integer> listIterator = null;

        if (method == Methods.ITERATOR_ADD || method == Methods.ITERATOR_REMOVE) {
            listIterator = list.listIterator();
        }

        for (int i = 0; i < COUNT_SIZES_OF_COLLECTIONS; i++) {

            start = Main.fillingCollection(list, SIZES_COLLECTION[i]);

            if (method == Methods.POPULATE) timesForCollections[i] = start;
            else {
                for (int j = COUNT_METERING; j >= 0; j--) {

                    start = System.currentTimeMillis();

                    switch (method) {
                        case ADD:
                            list.add(j / COUNT_METERING * SIZES_COLLECTION[i]);
                            break;
                        case GET:
                            list.get(j / COUNT_METERING * SIZES_COLLECTION[i]);
                            break;
                        case CONTAINS:
                            list.contains(j / COUNT_METERING * SIZES_COLLECTION[i]);
                            break;
                        case REMOVE:
                            list.remove(j / COUNT_METERING * SIZES_COLLECTION[i]);
                            break;
                        case ITERATOR_ADD:
                            while (listIterator.hasNext()){
                                if (listIterator.next() == (j / COUNT_METERING * SIZES_COLLECTION[i])){
                                    listIterator.add(j / COUNT_METERING * SIZES_COLLECTION[i]);
                                    break;
                                }
                            }
                            break;
                        case ITERATOR_REMOVE:
                            while (listIterator.hasNext()){
                                if (listIterator.next() == (j / COUNT_METERING * SIZES_COLLECTION[i])){
                                    listIterator.remove();
                                    break;
                                }
                            }
                            break;
                    }
                    timesForMetering[j] = System.currentTimeMillis() - start;
                }

                timesForCollections[i] = Main.arithmeticMean(timesForMetering);
            }
        }

        return timesForCollections;
    }

}
