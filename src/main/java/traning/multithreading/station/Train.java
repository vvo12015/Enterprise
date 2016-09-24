package traning.multithreading.station;

public class Train {

    private int countCars;
    private int weightCars;

    public int getCountCars() {
        return countCars;
    }

    public void setCountCars(int countCars) {
        this.countCars = countCars;
    }

    public int getWeightCars() {
        return weightCars;
    }

    public void setWeightCars(int weightCars) {
        this.weightCars = weightCars;
    }

    private Car[] cars;

    public Car[] getCars() {
        return cars;
    }

    public Train(int countCars, int weightCars) {

        this.countCars = countCars;
        this.weightCars = weightCars;

        this.cars = new Car[countCars];

        for (int i = 0; i < countCars; i++) {
            this.cars[i] = new Car(weightCars);
        }
    }

    public void setCars(Car[] cars) {
        this.cars = cars;
    }
}
