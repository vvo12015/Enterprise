package module01;

import java.util.Collection;
import java.util.Random;

public class ForTestCollections {

    protected int number;
    protected Random random = new Random();
    Collection<Integer> collection;

    public ForTestCollections(int number, Collection<Integer> collection) {
        this.number = number;
        this.collection = collection;
    }

    public  void populate(){
        for (int i = 0; i < number; i++) {
            collection.add(random.nextInt(number));
        }
    }

    public void add(){
        collection.add(random.nextInt(number));
    }

    public void remove(){
        collection.remove(random.nextInt(number));
    }

    public boolean contains(){
        return collection.contains(random.nextInt(number));
    }
}
