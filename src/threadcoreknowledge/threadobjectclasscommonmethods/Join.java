package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 演示join，注意语句输出顺序，会变化。
 * @Author: wenjun
 * @Date: 2019/10/14 16:59
 */
public class Join {

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });

        thread1.start();
        thread2.start();
        System.out.println("开始等待子线程运行完毕");
        thread1.join();
        thread2.join();
        System.out.println("所有线程执行完毕");
    }
}
