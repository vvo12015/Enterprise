package module01;

import java.util.List;
import java.util.ListIterator;

public class ForList extends ForTestCollections{

    List<Integer> list;
    private ListIterator<Integer> iterator;

    public ForList(int number, List list){
        super(number, list);
        this.list = list;
    }

    public void get() {
        list.get( random.nextInt(number)-1);
    }

    public boolean iteratorAdd(){
        iterator = list.listIterator();

        for (int i = 0; i < random.nextInt(number); i++) {
            iterator.next();
        }
        iterator.add(random.nextInt(number));
        return true;
    }

    public boolean iteratorRemove(){
        iterator = list.listIterator();

        for (int i = 0; i < random.nextInt(number); i++) {
            iterator.next();
        }
        iterator.remove();
        return true;
    }
}
