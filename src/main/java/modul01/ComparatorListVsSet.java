package modul01;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ComparatorListVsSet {

    public static final int COUNT_SIZES_OF_COLLECTIONS = 3;
    public static final int[] SIZES_COLLECTION = {10000, 100000, 1000000};
    public static final int COUNT_METERING = 200;

    private static long[] timesForMetering = new long[COUNT_METERING];

    public ComparatorListVsSet(Collection collection) {
        if (collection instanceof List) {
            this.list = (List) collection;
            this.set = null;
        }else if (collection instanceof Set){
            this.set = (Set) collection;
        }else {
            System.err.println("Wrong enter collection");
            list = null;
            set = null;
        }
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    private List list;
    private Set set;

    public long[] comparatorMethods(Methods method) {

        long[] timesForCollections = new long[COUNT_SIZES_OF_COLLECTIONS];

        long start;

        ListIterator<Integer> listIterator = null;

        if (method == Methods.ITERATOR_ADD || method == Methods.ITERATOR_REMOVE ||
                list != null) {
            listIterator = list.listIterator();
        }

        for (int i = 0; i < COUNT_SIZES_OF_COLLECTIONS; i++) {

            start = 0;
            if (list.isEmpty()) start = Main.fillingCollection(list, SIZES_COLLECTION[i]);
            if (set.isEmpty()) start = Main.fillingCollection(set, SIZES_COLLECTION[i]);

            if (method == Methods.POPULATE && start > 0) timesForCollections[i] = start;
            else if (start > 0){
                for (int j = COUNT_METERING; j >= 0; j--) {

                    start = System.currentTimeMillis();

                    switch (method) {
                        case ADD:
                            if (list.isEmpty())list.add(j / COUNT_METERING * SIZES_COLLECTION[i]);
                            if (set.isEmpty()) set.add(j / COUNT_METERING * SIZES_COLLECTION[i]);
                            break;
                        case GET:
                            if (list.isEmpty())list.get(j / COUNT_METERING * SIZES_COLLECTION[i]);
                            break;
                        case CONTAINS:
                            if (list.isEmpty())list.contains(j / COUNT_METERING * SIZES_COLLECTION[i]);
                            if (set.isEmpty()) set.contains(j / COUNT_METERING * SIZES_COLLECTION[i]);
                            break;
                        case REMOVE:
                            if (list.isEmpty())list.remove(j / COUNT_METERING * SIZES_COLLECTION[i]);
                            if (set.isEmpty()) set.remove(j / COUNT_METERING * SIZES_COLLECTION[i]);
                            break;
                        case ITERATOR_ADD:
                            if (list.isEmpty()) {
                                while (listIterator.hasNext()) {
                                    if (listIterator.next() == (j / COUNT_METERING * SIZES_COLLECTION[i])) {
                                        listIterator.add(j / COUNT_METERING * SIZES_COLLECTION[i]);
                                        break;
                                    }
                                }
                            }
                            break;
                        case ITERATOR_REMOVE:
                            if (list.isEmpty()) {
                                while (listIterator.hasNext()) {
                                    if (listIterator.next() == (j / COUNT_METERING * SIZES_COLLECTION[i])) {
                                        listIterator.remove();
                                        break;
                                    }
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
