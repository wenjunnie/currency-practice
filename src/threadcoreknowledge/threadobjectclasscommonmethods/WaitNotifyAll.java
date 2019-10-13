package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 3个线程，线程1和线程2首先被阻塞，线程3唤醒它们。
 * start先执行不代表线程先启动
 * @Author: wenjun
 * @Date: 2019/10/13 17:43
 */
public class WaitNotifyAll implements Runnable{

    private static final Object resourceA = new Object();

    public static void main(String[] args) throws InterruptedException {
        Runnable r = new WaitNotifyAll();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resourceA) {
                    resourceA.notifyAll();
                    System.out.println("thread3 notified.");
                }
            }
        });
        thread1.start();
        thread2.start();
        Thread.sleep(200);
        thread3.start();
    }

    @Override
    public void run() {
        synchronized (resourceA) {
            System.out.println(Thread.currentThread().getName()+"got resourceA lock.");
            try {
                System.out.println(Thread.currentThread().getName()+"wait to start.");
                resourceA.wait();
                System.out.println(Thread.currentThread().getName()+"is waiting to end.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
