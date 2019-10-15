package threadcoreknowledge.uncaughtexception;

/**
 * 1.不加try catch抛出4个异常，都带有线程名字
 * 2.加了try catch，期望捕获到第一个线程的异常，线程234不应该运行，希望看到打印出Caught Exception
 * 3.执行时发现，根本没有Caught Exception，线程234依然运行并且抛出异常
 * 说明线程的异常不能用传统方法捕获
 * @Author: wenjun
 * @Date: 2019/10/15 20:40
 */
public class CantCatchDirectly implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        try {
            new Thread(new CantCatchDirectly(), "线程1").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "线程2").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "线程3").start();
            Thread.sleep(300);
            new Thread(new CantCatchDirectly(), "线程4").start();
        } catch (RuntimeException e) {
            System.out.println("Caught Exception");
        }
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
