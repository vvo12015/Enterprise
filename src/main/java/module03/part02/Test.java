package module03.part02;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        int[] values = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

        int numberOfThreads = 3;

        if (values.length <= numberOfThreads){
            numberOfThreads = values.length;
        }

        int countCellsOnThread = values.length / numberOfThreads;
        int countOfThreadHarder = values.length % numberOfThreads;

        int position = 0;
        int offset = 0;

        for (int i = 0; i < numberOfThreads; i++) {
            int amendmentOnHarderForThread = 0;
            if (i < countOfThreadHarder){
                        amendmentOnHarderForThread = 1;
            }
            int countCellsForCopy = countCellsOnThread + amendmentOnHarderForThread;
            int[] ints = new int[countCellsForCopy];
            position += offset;
            System.arraycopy(values, position, ints, 0, ints.length);

            offset = countCellsForCopy;
        }
    }
}
