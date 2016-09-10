package module01;

import java.util.List;
import java.util.ListIterator;

public class ForList extends ForTestCollections{

    List<Integer> list;
    private ListIterator<Integer> iterator;

    public ForList(int number, List list){
        super(number, list);
        iterator = list.listIterator();
        populate();
    }

    public Integer get() {
        return list.get(random.nextInt(number));
    }

    public boolean iteratorAdd(){
        for (int i = 0; i < random.nextInt(number); i++) {
            iterator.next();
        }
        iterator.add(random.nextInt(number));
        return true;
    }

    public boolean iteratorRemove(){
        for (int i = 0; i < random.nextInt(number); i++) {
            iterator.next();
        }
        iterator.remove();
        return true;
    }
}
