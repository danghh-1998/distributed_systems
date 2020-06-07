package src.multithreaded;

public class ThreadedWorkerWithLock extends Thread {
    private final ResourceExploiterWithLock rExp;

    public ThreadedWorkerWithLock(ResourceExploiterWithLock rExp) {
        this.rExp = rExp;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            this.rExp.exploit();
        }
    }
}
