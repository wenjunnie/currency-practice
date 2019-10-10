package threadcoreknowledge.stopthreads;

/**
 * catch了InterruptedException之后的优先选择：在方法签名中抛出异常
 * 那么run()就会强制try/catch（因为我们是重写run()，run()本身并没有抛出异常）
 * @Author: wenjun
 * @Date: 2019/10/10 16:41
 */
public class RightWayStopThreadInProd implements Runnable {

    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println("go");
            try {
                throwInMethod();
            } catch (InterruptedException e) {
                System.out.println("此处可做保存日志等操作");
                e.printStackTrace();
            }
        }
    }

    public void throwInMethod() throws InterruptedException {
        Thread.sleep(2000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}
