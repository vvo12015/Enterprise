package test.multithreading.station;

public class Brigade extends Thread /*implements Comparable*/{
    public MySemaphoreImp getMySemaphore() {
        return mySemaphore;
    }

    public void setMySemaphore(MySemaphoreImp mySemaphore) {
        this.mySemaphore = mySemaphore;
    }

    public Car getCarForUnload() {
        return carForUnload;
    }

    public void setCarForUnload(Car carForUnload) {
        this.carForUnload = carForUnload;
    }

    public int getCountUnloads() {
        return countUnloads;
    }

    public void setCountUnloads(int countUnloads) {
        this.countUnloads = countUnloads;
    }

    private MySemaphoreImp mySemaphore;
    private String name;
    private Car carForUnload;
    private int countUnloads = 0;

    public Brigade(MySemaphoreImp mySemaphore, String name, Car carForUnload) {
        this.mySemaphore = mySemaphore;
        this.name = name;
        this.carForUnload = carForUnload;
        this.countUnloads = 0;
    }

    private void unload(){
        carForUnload.unload();
    }

    @Override
    public void run() {
        System.out.println(name + " started working... (" + Thread.currentThread().getName() + ")");
        try {
            mySemaphore.acquire();
            System.out.println(name + " call thread (" + Thread.currentThread().getName() + ")");
            while (carForUnload.getWeight() > 0) {
                carForUnload.unload();
                Thread.sleep(100L);
                countUnloads++;
                System.out.println(name + " changed weight to:" + carForUnload.getWeight());

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            try {
                mySemaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /*@Override
    public int compareTo(Object o) {
        Brigade tmp = (Brigade) o;
        return this.countUnloads - tmp.countUnloads;
    }*/
}
