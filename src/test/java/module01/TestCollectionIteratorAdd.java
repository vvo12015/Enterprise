package module01;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Test;
//test add iterator
public class TestCollectionIteratorAdd extends TestCollectionMethodsAbstract {

    public TestCollectionIteratorAdd(int number) {
        super(number);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void arrayListIteratorAdd(){
        forArrayList.iteratorAdd();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void linkedListIteratorAdd(){
        forLinkedList.iteratorAdd();
    }
}
