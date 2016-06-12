package test.multithreading.station;

import java.util.Arrays;
import java.util.Comparator;

public class Brigadier implements Runnable{

    public static final int AVAILABLE_INPUTS = 2;
    private int countBrigades;
    public int availablePosition = 0;
    private Brigade[] brigades;
    private Train train;
    private MySemaphoreImp mySemaphoreImps;

    public Brigadier(Train train, int countBrigades, int availablePosition) {
        this.train = train;
        this.countBrigades = countBrigades;

        mySemaphoreImps = new MySemaphoreImp(AVAILABLE_INPUTS);

        this.brigades = new Brigade[countBrigades];

        for (int i = 0; i < countBrigades; i++) {
            this.brigades[i] = new Brigade(mySemaphoreImps, "Brigade" + i, null);
        }
    }

    @Override
    public void run() {

        for (int i = 0; i < train.getCountCars(); i++) {
            Arrays.sort(brigades, new Comparator<Brigade>() {
                @Override
                public int compare(Brigade o1, Brigade o2) {
                    return o1.getCountUnloads() - o2.getCountUnloads();
                }
            });

            for (int j = 0; j < AVAILABLE_INPUTS; j++) {
                brigades[j].setCarForUnload(train.getCars()[i]);
                brigades[j].start();
            }

            while (train.getCars()[i].getWeight() > 0){
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            };
        }
    }
}
