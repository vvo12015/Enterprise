package module01;


import com.carrotsearch.junitbenchmarks.BenchmarkOptions;
import com.carrotsearch.junitbenchmarks.BenchmarkRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class MainTest {

        @Rule
        public BenchmarkRule benchmarkRun = new BenchmarkRule();

        public static final int _1M = 1000_000;

        private ForList forArrayList;
        private ForList forLinkedList;
        private ForTestCollections forHashSet;
        private ForTestCollections forTreeSet;

        @Before
        public void init() {
            forArrayList = new ForList(_1M, new ArrayList<>());
            forLinkedList = new ForList(_1M, new LinkedList<>());
            forHashSet = new ForTestCollections(_1M, new HashSet<>());
            forTreeSet = new ForTestCollections(_1M, new TreeSet<>());
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