package module01;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Test;
//tests populate
public class TestCollectionPopulate extends TestCollectionMethodsAbstract {
    
    public TestCollectionPopulate(int number) {
        super(number);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void arrayListPopulate(){
        forArrayList.populate();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void linkedListPopulate(){
        forLinkedList.populate();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void hashSetPopulate(){
        forHashSet.populate();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void treeSetPopulate(){
        forTreeSet.populate();
    }
}
