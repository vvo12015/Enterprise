package modul02;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl implements Executor<Number> {

    List<Task<Number>> validTasks;
    List<Task<Number>> invalidTasks;
    List<Number> validResults;
    List<Number> invalidResults;

    public ExecutorImpl() {
        this.validTasks = new ArrayList<>();
        this.invalidTasks = new ArrayList<>();
        this.validResults = new ArrayList<>();
        this.invalidResults = new ArrayList<>();
    }

    @Override
    public void addTask(Task<Number> task) {
        validTasks.add(task);
    }

    @Override
    public void addTask(Task<Number> task, Validator<Number> validator) {
        if (validator.isValid(task.getResult())){
            validTasks.add(task);
        }else {
            invalidTasks.add(task);
        }
    }

    @Override
    public void execute() {

    }

    public List<Task<Number>> getValidTasks() {
        return validTasks;
    }

    public void setValidTasks(List<Task<Number>> validTasks) {
        this.validTasks = validTasks;
    }

    public List<Task<Number>> getInvalidTasks() {
        return invalidTasks;
    }

    public void setInvalidTasks(List<Task<Number>> invalidTasks) {
        this.invalidTasks = invalidTasks;
    }

    @Override
    public List<Number> getValidResults() {
        return validResults;
    }

    public void setValidResults(List<Number> validResults) {
        this.validResults = validResults;
    }

    @Override
    public List<Number> getInvalidResults() {
        return invalidResults;
    }

    public void setInvalidResults(List<Number> invalidResults) {
        this.invalidResults = invalidResults;
    }
}
