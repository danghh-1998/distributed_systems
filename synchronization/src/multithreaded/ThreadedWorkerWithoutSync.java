package src.multithreaded;

public class ThreadedWorkerWithoutSync extends Thread {
    private final ResourcesExploiter rExp;

    public ThreadedWorkerWithoutSync(ResourcesExploiter rExp) {
        this.rExp = rExp;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.rExp.exploit();
        }
    }
}
