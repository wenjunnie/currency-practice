package threadcoreknowledge.createthreads.wrongways;

/**
 * Lambda表达式创建线程的方法
 * @Author: wenjun
 * @Date: 2019/10/8 21:25
 */
public class Lambda {

    public static void main(String[] args) {
        new Thread(()-> System.out.println(Thread.currentThread().getName())).start();
    }
}
