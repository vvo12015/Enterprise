package modul01;

import java.io.*;
import java.util.Collection;

public class Main {

    public static final String CONTENT = "fromMain";

    static Long fillingCollection(Collection<String> collection, int size){

        collection.clear();

        long start = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            collection.add(CONTENT + i);
        }

        return System.currentTimeMillis() - start;
    }

    static Long arithmeticMean(Long[] times){

        Long sum = 0L;

        for (int i = 0; i < times.length; i++) {
            sum += times[i];
        }

        if (sum == 0L) {return 0L;}

        return sum / times.length;
    }

    public static void main(String[] args) {

        CreateResult createResult = new CreateResult();

        OutResult outResult = new OutResult(createResult.getResultCollections());

        try {
            FileOutputStream fileOut = new FileOutputStream("table.txt");

            PrintStream printFile = new PrintStream(fileOut);

            outResult.resultOut(System.out);
            outResult.resultOut(printFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
