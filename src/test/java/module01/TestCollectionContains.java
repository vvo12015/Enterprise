package module01;

import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Test;
//test contains
public class TestCollectionContains extends TestCollectionMethodsAbstract{

    public TestCollectionContains(int number) {
        super(number);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void arrayListContains() {
        forArrayList.contains();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void linkedListContains() {
        forLinkedList.contains();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void hashSetContains() {
        forHashSet.contains();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 1)
    public void treeSetContains() {
        forTreeSet.contains();
    }
}