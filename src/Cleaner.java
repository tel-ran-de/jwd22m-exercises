import storage.IServerStorage;

public class Cleaner implements Runnable {
    private final IServerStorage serverStorage;
    private final int periodMillis;


    public Cleaner(IServerStorage serverStorage, int periodMillis) {
        this.serverStorage = serverStorage;
        this.periodMillis = periodMillis;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(periodMillis);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            serverStorage.clear(periodMillis);
        }
    }
}
