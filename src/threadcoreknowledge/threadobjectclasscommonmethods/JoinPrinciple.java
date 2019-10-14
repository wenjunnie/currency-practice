package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * 通过讲解join原理，分析join的代替写法
 * @Author: wenjun
 * @Date: 2019/10/14 17:48
 */
public class JoinPrinciple {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
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

        thread.start();
        System.out.println("开始等待子线程运行完毕");
        //thread.join();
        synchronized (thread) {
            thread.wait();
        }
        System.out.println("所有线程执行完毕");
    }
}
