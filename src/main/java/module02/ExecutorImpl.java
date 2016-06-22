package module02;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExecutorImpl implements Executor<Number> {


    private class TasksForValid{
        private Task<? extends Number> task;
        private Validator<? super Number> validator;

        public TasksForValid(Task<? extends Number> task, Validator<? super Number> validator) {
            this.task = task;
            this.validator = validator;
        }

        public TasksForValid(Task<? extends Number> task) {
            this.task = task;
            this.validator = new Validator<Number>() {
                @Override
                public boolean isValid(Number result) {
                    return true;
                }
            };
        }

        public Task<? extends Number> getTask() {
            return task;
        }

        private void setTask(Task<? extends Number> task) {
            this.task = task;
        }

        public Validator<? super Number> getValidator() {
            return validator;
        }

        public void setValidator(Validator<? super Number> validator) {
            this.validator = validator;
        }
    }

    private List<TasksForValid> tasks;
    private List<? extends Number> validResults;
    private List<? extends Number> invalidResults;
    private boolean on;

    private List<TasksForValid> getTasks() {
        return tasks;
    }

    private boolean isOn() {
        return on;
    }

    private void setOn(boolean on) {
        this.on = on;
    }

    public ExecutorImpl() {
        this.tasks = new ArrayList<>();
        this.validResults = new ArrayList<>();
        this.invalidResults = new ArrayList<>();
    }

    @Override
    public void addTask(Task<? extends Number> task) throws IllegalStateException {
        if (!isOn()) {
            tasks.add(new TasksForValid(task));
        }else throw new IllegalStateException("Execute was launched");
    }

    @Override
    public void addTask(Task<? extends Number> task, Validator<? super Number> validator) throws IllegalStateException {
        if (!isOn()) {
            tasks.add(new TasksForValid(task, validator));
        }else throw new IllegalStateException("Execute was launched");
    }

    public void execute() throws IllegalStateException {

        tasks.stream().forEach((t) ->t.getTask().execute());

        validResults = tasks.stream()
                .filter((t) -> t.getValidator().isValid(t.getTask().getResult()))
                .map((t) -> t.getTask().getResult())
                .collect(Collectors.toList());
        invalidResults = tasks.stream()
                .filter((t) -> !t.getValidator().isValid(t.getTask().getResult()))
                .map((t) -> t.getTask().getResult())
                .collect(Collectors.toList());
    }

    @Override
    public List<? extends Number> getValidResults() {
        return validResults;
    }

    @Override
    public List<? extends Number> getInvalidResults() {
        return invalidResults;
    }

}
