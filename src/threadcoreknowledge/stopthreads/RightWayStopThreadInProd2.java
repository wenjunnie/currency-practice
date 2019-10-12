package threadcoreknowledge.stopthreads;

/**
 * 最佳实践2：在catch子语句中调用Thread.currentThread().interrupt();来恢复设置中断状态，以便于在后续的执行中，依然能够检查到刚才发生了中断。
 * 回到刚才RightWayStopThreadInProd补上中断，让它跳出。
 * @Author: wenjun
 * @Date: 2019/10/10 16:41
 */
public class RightWayStopThreadInProd2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            if(Thread.currentThread().isInterrupted()) {
                System.out.println("Interrupt,程序运行结束");
                break;
            }
            System.out.println("go");
            reInterrupt();
        }
    }

    public void reInterrupt(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadInProd2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }
}