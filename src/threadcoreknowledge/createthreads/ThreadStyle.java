package threadcoreknowledge.createthreads;

/**
 * 用Thread方式实现线程
 * @Author: wenjun
 * @Date: 2019/10/8 20:26
 */
public class ThreadStyle extends Thread{

    public static void main(String[] args) {
        new ThreadStyle().start();
    }

    @Override
    public void run() {
        System.out.println("用Thread方式实现线程");
    }
}
