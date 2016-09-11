package module01;


import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import org.junit.Test;
//test get
public class TestCollectionGet extends TestCollectionMethodsAbstract implements Size{

    public TestCollectionGet(int number) {
        super(number);
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 0)
    public void arrayListGet(){
        forArrayList.get();
    }

    @Test
    @BenchmarkOptions(benchmarkRounds = 100, warmupRounds = 0)
    public void linkedListGet(){
        forLinkedList.get();
    }

}