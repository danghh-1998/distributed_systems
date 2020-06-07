package src.multithreaded;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void startThreadsWithoutSync() {
        ResourcesExploiter resource = new ResourcesExploiter(0);
        ArrayList<ThreadedWorkerWithoutSync> asyncWorkers = new ArrayList<>(Arrays.asList(
                new ThreadedWorkerWithoutSync(resource),
                new ThreadedWorkerWithoutSync(resource),
                new ThreadedWorkerWithoutSync(resource)
        ));
        asyncWorkers.forEach(Thread::start);
        asyncWorkers.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Start asynchronize " + resource.getRsc());
    }

    public static void startThreadsWithSync() {
        ResourcesExploiter resource = new ResourcesExploiter(0);
        ArrayList<ThreadedWorkerWithSync> syncWorkers = new ArrayList<>(Arrays.asList(
                new ThreadedWorkerWithSync(resource),
                new ThreadedWorkerWithSync(resource),
                new ThreadedWorkerWithSync(resource)
        ));
        syncWorkers.forEach(Thread::start);
        syncWorkers.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Start synchronize " + resource.getRsc());
    }

    public static void startWorkerWithLock() {
        ResourceExploiterWithLock resource = new ResourceExploiterWithLock(0);
        ArrayList<ThreadedWorkerWithLock> lockWorkers = new ArrayList<>(Arrays.asList(
                new ThreadedWorkerWithLock(resource),
                new ThreadedWorkerWithLock(resource),
                new ThreadedWorkerWithLock(resource)
        ));
        lockWorkers.forEach(Thread::start);
        lockWorkers.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Start lock " + resource.getRsc());
    }

    public static void main(String[] args) {
        startThreadsWithSync();
        startThreadsWithoutSync();
        startWorkerWithLock();
    }
}
