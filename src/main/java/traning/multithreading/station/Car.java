package traning.multithreading.station;

public class Car {

    private int weight = 0;

    public void unload(){
        if (weight > 0) weight--;
    }

    public Car(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
