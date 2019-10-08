package threadcoreknowledge.createthreads;

/**
 * 同时使用Runnable和Thread
 * 打印出“我来自Thread”,因为run()已经被重写了
 * @Author: wenjun
 * @Date: 2019/10/8 20:49
 */
public class BothRunnableThread {

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("我来自Runnable");
            }
        }){
            @Override
            public void run() {
                System.out.println("我来自Thread");
            }
        }.start();
    }
}
