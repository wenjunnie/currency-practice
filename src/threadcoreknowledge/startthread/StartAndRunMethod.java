package threadcoreknowledge.startthread;

/**
 * 对比start和run两种启动线程的方式
 * @Author: wenjun
 * @Date: 2019/10/9 20:35
 */
public class StartAndRunMethod {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        runnable.run();
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
    }
}
