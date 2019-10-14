package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 演示sleep不释放lock（lock需要手动释放）
 * @Author: wenjun
 * @Date: 2019/10/14 16:34
 */
public class SleepDontReleaseLock implements Runnable{

    private static final Lock LOCK = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(new SleepDontReleaseLock()).start();
        new Thread(new SleepDontReleaseLock()).start();
    }

    @Override
    public void run() {
        LOCK.lock();
        System.out.println("线程" + Thread.currentThread().getName() + "获取到了锁");
        try {
            Thread.sleep(5000);
            System.out.println("线程" + Thread.currentThread().getName() + "已苏醒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            LOCK.unlock();
        }
    }
}
