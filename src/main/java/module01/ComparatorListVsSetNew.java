package module01;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class ComparatorListVsSetNew {

    public static final int COUNT_SIZES_OF_COLLECTIONS = 3;
    public static final int[] SIZES_COLLECTION = {10_000, 100_000, 1_000_000};
    public static final int COUNT_METERING = 200;

    public ComparatorListVsSetNew(Collection collection) {

        list = null;
        set = null;

        if (collection instanceof List) {
            this.list = (List) collection;
        }else if (collection instanceof Set){
            this.set = (Set) collection;
        }else {
            System.err.println("Wrong enter collection");
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

    public Long[] comparatorMethods(Methods method) {

        Long[] timesForCollections = new Long[COUNT_SIZES_OF_COLLECTIONS];
        Long[] timesForMetering = new Long[COUNT_METERING];


        Long start;

        ListIterator<String> listIterator = null;

        if ((list != null) && (method == Methods.ITERATOR_ADD || method == Methods.ITERATOR_REMOVE)) {
            listIterator = list.listIterator();
        }

        for (int i = 0; i < COUNT_SIZES_OF_COLLECTIONS; i++) {

            start = 0L;

            if (list != null) System.out.println("Collection.getName - " + list.getClass().getName());
            if (set != null) System.out.println("Collection.getName - " + set.getClass().getName());

            System.out.println("Method - " + method.toString());

            if (list != null) start = Main.fillingCollection(list, SIZES_COLLECTION[i]);
            if (set != null) start = Main.fillingCollection(set, SIZES_COLLECTION[i]);

            if (method == Methods.POPULATE && start > 0) timesForCollections[i] = start;
            else if (start > 0){
                for (int j = COUNT_METERING-1; j >= 0; j--) {

                    start = System.currentTimeMillis();
                    System.out.println(start);
                    float forIndex = Float.valueOf(j) / Float.valueOf(COUNT_METERING);
                    int index = Math.round(forIndex * Float.valueOf(SIZES_COLLECTION[i]));
                    String content = Main.CONTENT + index;

                    switch (method) {
                        case ADD:
                            if (list != null)list.add(index, content);
                            if (set != null) set.add(content);
                            break;
                        case GET:
                            if (list != null)list.get(index);
                            break;
                        case CONTAINS:
                            if (list != null)list.contains(content);
                            if (set != null) set.contains(content);
                            break;
                        case REMOVE:
                            if (list != null)list.remove(content);
                            if (set != null){
                                set.remove(content);
                            }
                            break;
                        case ITERATOR_ADD:
                            if (list != null) {
                                int k = 0;
                                while (listIterator.hasNext()) {
                                    if (listIterator.next().equals(content)) {
                                        listIterator.add("modify in comparator");
                                        break;
                                    }
                                    k++;
                                }
                            }
                            break;
                        case ITERATOR_REMOVE:
                            if (list != null) {
                                int k = 0;
                                while (listIterator.hasNext()) {
                                    if (listIterator.next().equals(content)) {
                                        listIterator.remove();
                                        break;
                                    }
                                    k++;
                                }
                            }
                            break;
                    }
                    long end = System.currentTimeMillis();
                    timesForMetering[j] = end - start;
                    System.out.println(end - start);
                }
                timesForCollections[i] = Main.arithmeticMean(timesForMetering);
            }

        }

        return timesForCollections;
    }

}
