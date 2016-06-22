package module02;

import java.util.function.Predicate;

public class ValidatorImpl implements Validator<Number> {

    private Predicate<Number> function;

    public ValidatorImpl(Predicate<Number> function) {
        this.function = function;
    }

    @Override
    public boolean isValid(Number result) {
        return function.test(result);
    }
}
