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

    public boolean isOn() {
        return on;
    }

    private void setOn(boolean on) {
        this.on = on;
    }

    public IntTask(IntUnaryOperator function, int argument) {
        this.function = function;
        this.argument = argument;
        this.on = false;
    }

    @Override
    public void execute() {
        this.result = function.applyAsInt(argument);
        this.on = true;
    }

    @Override
    public Integer getResult() throws IllegalStateException {
        if (this.isOn()) return result;
        else throw new IllegalStateException("Task is not running");
    }
}
