package module01;

import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

@RunWith(Parameterized.class)
public abstract class TestCollectionMethodsAbstract implements Size{
    static ForList forArrayList;
    static ForList forLinkedList;
    static ForTestCollections forHashSet;
    static ForTestCollections forTreeSet;
    private int number;
    @Rule
    public BenchmarkRule benchmarkRun = new BenchmarkRule();

    @Parameterized.Parameters
    public static List<Object> isEmptyData() {
        return Arrays.asList(new Object[] {_10K, _100K, _1M});
    }

    public TestCollectionMethodsAbstract(int number) {
        this.number = number;
    }

    @Before
    public void setUp() {
        forArrayList = new ForList(number, new ArrayList<>());
        forLinkedList = new ForList(number, new LinkedList<>());
        forHashSet = new ForTestCollections(number, new HashSet<>());
        forTreeSet = new ForTestCollections(number, new TreeSet<>());
    }

    @After
    public void setDown(){
        forArrayList.clear();
        forLinkedList.clear();
        forHashSet.clear();
        forTreeSet.clear();
    }
}