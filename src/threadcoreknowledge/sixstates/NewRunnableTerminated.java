package threadcoreknowledge.sixstates;

/**
 * 展示NEW、RUNNABLE、TERMINATED状态。即使正在运行，也是Runnable状态，而不是Running。
 * @Author: wenjun
 * @Date: 2019/10/12 17:16
 */
public class NewRunnableTerminated implements Runnable {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new NewRunnableTerminated());
        //打印出NEW状态
        System.out.println(thread.getState());
        thread.start();
        //打印出Runnable状态
        System.out.println(thread.getState());
        Thread.sleep(20);
        //运行中打印出Runnable状态
        System.out.println(thread.getState());
        Thread.sleep(100);
        //运行中打印出TERMINATED状态
        System.out.println(thread.getState());
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}
