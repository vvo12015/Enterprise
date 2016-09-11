package module01;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Test;
//test remove
public class TestCollectionRemove extends TestCollectionMethodsAbstract{


    public TestCollectionRemove(int number) {
        super(number);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void arrayListRemove(){
        forArrayList.remove();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void linkedListRemove(){
        forLinkedList.remove();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void hashSetRemove(){
        forHashSet.remove();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void treeSetRemove(){
        forTreeSet.remove();
    }
}
