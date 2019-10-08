package threadcoreknowledge.createthreads.wrongways;

/**匿名内部类创建线程的方法
 * @Author: wenjun
 * @Date: 2019/10/8 21:20
 */
public class AnonymousInner {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }).start();
    }
}
