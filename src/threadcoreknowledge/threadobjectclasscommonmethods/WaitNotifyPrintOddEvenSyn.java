package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 使用synchronized关键字实现两个线程交替打印0~100奇偶数
 * 存在资源浪费的情况，因为线程释放锁后，两个线程再次同时竞争锁
 * @Author: wenjun
 * @Date: 2019/10/13 20:26
 */
public class WaitNotifyPrintOddEvenSyn {
    private static int count;
    private static final Object lock = new Object();

    //新建2个线程
    //1个只处理偶数，另一个只处理奇数
    //用synchronized来通信
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        },"even").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);
                        }
                    }
                }
            }
        },"odd").start();
    }
}
