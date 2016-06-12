package module01;


import org.junit.Test;

public class MainTest {

    @Test
    public void arithmeticMean() throws Exception {
        Number[] intNumbers = new Integer[]{10, 20, 30};
        intNumbers[2] = 10.48;
        for (Number intNumber : intNumbers) {
        System.out.println(intNumber);
        }
    }

}