package module01;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Test;

public class TestCollectionIteratorRemove extends TestCollectionMethodsAbstract {
    
    public TestCollectionIteratorRemove(int number) {
        super(number);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void arrayListIteratorRemove(){
        forArrayList.iteratorRemove();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void linkedListIteratorRemove(){
        forLinkedList.iteratorRemove();
    }    
}
