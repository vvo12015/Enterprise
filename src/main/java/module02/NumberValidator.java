package module02;

public class NumberValidator implements Validator<Number> {

    @Override
    public boolean isValid(Number result) {
        return result.equals(10L);
    }
}
