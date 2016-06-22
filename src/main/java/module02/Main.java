package module02;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        List<Task<Integer>> intTasks = new ArrayList<>();

        test(intTasks);
    }

    public static void test(List<Task<Integer>> intTasks) {

        Executor<Number> numberExecutor = new ExecutorImpl();

        intTasks.forEach(numberExecutor::addTask);

        numberExecutor.addTask(new IntTask(new IntUnaryOperator() {
            @Override
            public int applyAsInt(int operand) {
                return operand*2;
            }
        }, 20), new ValidatorImpl(new Predicate<Number>() {
            @Override
            public boolean test(Number number) {
                return number.equals(40);
            }
        }));

        numberExecutor.addTask(new LongTask(10L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        numberExecutor.getValidResults().forEach(System.out::println);
        System.out.println("Invalid results:");
        numberExecutor.getInvalidResults().forEach(System.out::println);
    }

}
