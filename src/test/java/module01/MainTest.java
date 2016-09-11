package module01;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@Suite.SuiteClasses({TestCollectionAdd.class, TestCollectionGet.class, TestCollectionContains.class,
                        TestCollectionPopulate.class, TestCollectionRemove.class,
                        TestCollectionIteratorAdd.class, TestCollectionIteratorRemove.class})
@RunWith(Suite.class)
public class MainTest {

    public static void main(String[] args) {

    }
}
