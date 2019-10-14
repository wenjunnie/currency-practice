package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 两个线程交替打印0~100的奇偶数，用wait和notify实现
 * @Author: wenjun
 * @Date: 2019/10/14 14:45
 */
public class WaitNotifyPrintOddEvenWait {
    private static int count;
    private static final Object lock = new Object();

    //1.拿到锁，我们就打印
    //2.打印完，唤醒其他线程，自己就休眠
    public static void main(String[] args) {
        new Thread(new TurningRunner(),"even").start();
        new Thread(new TurningRunner(),"odd").start();
    }

    static class TurningRunner implements Runnable{

        @Override
        public void run() {
            while (count <= 100) {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + ":" + count++);
                    lock.notify();
                    if(count <= 100) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
