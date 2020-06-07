package src.multithreaded;

public class ThreadedWorkerWithSync extends Thread {
    private final ResourcesExploiter rExp;

    public ThreadedWorkerWithSync(ResourcesExploiter rExp) {
        this.rExp = rExp;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            this.rExp.exploit();
        }
    }
}
