package modul02;

public interface Validator<T> {

    // Валидирует переданое значение
    boolean isValid(T result);

}
