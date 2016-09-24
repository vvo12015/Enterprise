package traning.forLambda;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiConsumer;

public class ForLambda {

    public static void main(String[] args) {

        List<Integer> arrayList = new ArrayList<>();

        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 10; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        BiConsumer<List<Integer>, Integer> functionList = (list, value) -> list.add(value);


//        Integer converted = converter.convert("123");
//        System.out.println(converted);    // 123
    }



}
