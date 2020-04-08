package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: wenjun
 * @Date: 2020/4/8 23:27
 */
public class WaitNotifyPrintOddEvenSimplify implements Runnable{
    private static int count;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new WaitNotifyPrintOddEvenSimplify(),"even").start();
        new Thread(new WaitNotifyPrintOddEvenSimplify(),"odd").start();
    }

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
