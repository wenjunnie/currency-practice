package threadcoreknowledge.uncaughtexception;

/**
 * 使用刚才自己写的MyUncaughtExceptionHandler
 * 抛出RuntimeException只会停止当前线程
 * @Author: wenjun
 * @Date: 2019/10/15 21:06
 */
public class UseOwnUncaughtExceptionHandler implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandler("捕获器1"));

        new Thread(new UseOwnUncaughtExceptionHandler(), "线程1").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "线程2").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "线程3").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandler(), "线程4").start();
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
