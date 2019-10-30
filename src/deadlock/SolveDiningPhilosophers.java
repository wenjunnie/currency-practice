package deadlock;

/**
 * 解决哲学家就餐问题导致的死锁
 * @Author: wenjun
 * @Date: 2019/10/30 10:58
 */
public class SolveDiningPhilosophers {

    public static class Philosopher implements Runnable {

        private Object leftChopstick;
        private Object rightChopstick;

        public Philosopher(Object leftChopstick, Object rightChopstick) {
            this.leftChopstick = leftChopstick;
            this.rightChopstick = rightChopstick;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    doAction("Thinking.");
                    synchronized (leftChopstick) {
                        doAction("Pick up left chopstick.");
                        synchronized (rightChopstick) {
                            doAction("Pick up right chopstick.");
                            doAction("Put down right chopstick.");
                        }
                        doAction("Put down left chopstick.");
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void doAction(String action) throws InterruptedException {
            System.out.println(Thread.currentThread().getName() + " " + action);
            Thread.sleep((long) (Math.random() * 10));
        }
    }

    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] chopsticks = new Object[philosophers.length];
        for (int i = 0; i < chopsticks.length; i++) {
            chopsticks[i] = new Object();
        }
        for (int i = 0; i < philosophers.length; i++) {
            Object leftChopstick = chopsticks[i];
            Object rightChopstick = chopsticks[(i+1) % chopsticks.length];
            //解决方案（改变一位哲学家拿筷子的顺序）
            if (i == philosophers.length-1) {
                philosophers[i] = new Philosopher(rightChopstick,leftChopstick);
                new Thread(philosophers[i],"哲学家" + (i+1) + "号").start();
            } else {
                philosophers[i] = new Philosopher(leftChopstick, rightChopstick);
                new Thread(philosophers[i], "哲学家" + (i + 1) + "号").start();
            }
        }
    }
}
