import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private ReentrantLock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        ReentrantLock left = forks[philosopher];
        ReentrantLock right = forks[(philosopher + 1) % 5];

        ReentrantLock first = philosopher % 2 == 0 ? left : right;
        ReentrantLock second = philosopher % 2 == 0 ? right : left;

        first.lock();
        second.lock();

        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            putLeftFork.run();
        } finally {
            second.unlock();
            first.unlock();
        }
    }
}
