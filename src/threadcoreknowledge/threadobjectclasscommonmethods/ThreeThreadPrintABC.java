package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * @Author: wenjun
 * @Date: 2020/4/8 23:44
 */
public class ThreeThreadPrintABC implements Runnable{
    private static int count;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        new Thread(new ThreeThreadPrintABC(),"A").start();
        new Thread(new ThreeThreadPrintABC(),"B").start();
        new Thread(new ThreeThreadPrintABC(),"C").start();
    }

    @Override
    public void run() {
        while (count <= 100) {
            synchronized (lock) {
                if (count % 3 == Thread.currentThread().getName().charAt(0) - 'A') {
                    System.out.println(Thread.currentThread().getName());
                    count++;
                }
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
