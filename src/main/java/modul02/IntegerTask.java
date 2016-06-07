package modul02;

public class IntegerTask implements Task<Integer> {

    Integer result;
    @Override
    public void execute() {
        result++;
    }

    public IntegerTask() {
        this.result = 0;
    }

    @Override
    public Integer getResult() {
        return result;
    }
}
