package modul02;

import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl implements Executor<Number> {

    List<Task<? extends Number>> validTasks;
    List<Task<? extends Number>> invalidTasks;
    List<? extends Number> validResults;
    List<? extends Number> invalidResults;

    public ExecutorImpl() {
        this.validTasks = new ArrayList<>();
        this.invalidTasks = new ArrayList<>();
        this.validResults = new ArrayList<>();
        this.invalidResults = new ArrayList<>();
    }

    @Override
    public void addTask(Task<? extends Number> task) throws IllegalStateException {
        validTasks.add(task);
    }

    @Override
    public void addTask(Task<? extends Number> task, Validator<? super Number> validator) throws IllegalStateException {
        if (validator.isValid(task.getResult())) {
            validTasks.add(task);
        } else {
            invalidTasks.add(task);
        }
    }

    public void execute() throws IllegalStateException {
        for (Task<? extends Number> task :
                validTasks) {
            task.execute();
        }
        for (Task<? extends Number> task :
                invalidTasks) {
            task.execute();
        }
    }

    public List<Task<? extends Number>> getValidTasks() {
        return validTasks;
    }

    public void setValidTasks(List<Task<? extends Number>> validTasks) {
        this.validTasks = validTasks;
    }

    public List<Task<? extends Number>> getInvalidTasks() {
        return invalidTasks;
    }

    public void setInvalidTasks(List<Task<? extends Number>> invalidTasks) {
        this.invalidTasks = invalidTasks;
    }

    public List<? extends Number> getValidResults() {
        return validResults;
    }

    public void setValidResults(List<? extends Number> validResults) {
        this.validResults = validResults;
    }

    public List<? extends Number> getInvalidResults() {
        return invalidResults;
    }

    public void setInvalidResults(List<? extends Number> invalidResults) {
        this.invalidResults = invalidResults;
    }
}
