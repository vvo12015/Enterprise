package test.multithreading.station;

public class Main {

    public static void main(String[] args) {
        Train train = new Train(10, 20);
        new Thread(new Brigadier(train, 3, 1)).start();
    }
}
