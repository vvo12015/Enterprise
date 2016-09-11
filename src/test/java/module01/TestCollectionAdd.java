package module01;


import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Test;

public class TestCollectionAdd extends TestCollectionMethodsAbstract implements Size{

    public TestCollectionAdd(int number) {
        super(number);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void arrayListAdd(){
        forArrayList.add();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void linkedListAdd(){
        forLinkedList.add();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void hashSetAdd(){
        forHashSet.add();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void treeSetAdd(){
        forTreeSet.add();
    }
}