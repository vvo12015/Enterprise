package module03;

import traning.multithreading.station.MySemaphoreImp;

public class SemaphoreExample {
    public static void main(String[] args) {
        MySemaphoreImp mySemaphore = new MySemaphoreImp(1);

        new Thread(new Worker(mySemaphore, "Adder", true)).start();
        new Thread(new Worker(mySemaphore, "Reducer", false)).start();
    }
}

