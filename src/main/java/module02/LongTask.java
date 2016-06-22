package module02;

public class LongTask implements Task<Long> {

    private boolean on;

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    private Long value;

    public LongTask(Long value) {
        this.value = value;
    }

    private Long result;


    @Override
    public void execute() {

        this.result = value * 2L;

        this.on = true;
    }

    @Override
    public Long getResult() throws IllegalStateException {
        if (this.isOn()){return result;}
        else throw new IllegalStateException("Task is not running");
    }
}
