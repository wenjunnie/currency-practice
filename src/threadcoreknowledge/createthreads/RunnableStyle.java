package threadcoreknowledge.createthreads;

/**
 * 用Runnable方式创建线程
 * @Author: wenjun
 * @Date: 2019/10/8 20:23
 */
public class RunnableStyle implements Runnable{

    public static void main(String[] args) {
        Thread thread = new Thread(new RunnableStyle());
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("用Runnable方式创建线程");
    }
}
