package module02;

import java.util.function.IntUnaryOperator;

public class IntTask implements Task<Integer>{

    private IntUnaryOperator function;
    private int argument;
    private int result;
    private boolean on;

    private IntUnaryOperator getFunction() {
        return function;
    }

    private void setFunction(IntUnaryOperator function) {
        this.function = function;
    }

    private int getArgument() {
        return argument;
    }

    private void setArgument(int argument) {
        this.argument = argument;
    }

    private void setResult(int result) {
        this.result = result;
    }

    private boolean isOn() {
        return on;
    }

    private void setOn(boolean on) {
        this.on = on;
    }

    public IntTask(IntUnaryOperator function, int argument) {
        this.function = function;
        this.argument = argument;
        on = false;
    }

    @Override
    public void execute() {
        result = function.applyAsInt(argument);
        on = true;
    }

    @Override
    public Integer getResult() throws IllegalStateException {
        if (on) return result;
        else throw new IllegalStateException("Task is not running");
    }
}
