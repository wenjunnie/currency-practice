package threadcoreknowledge.stopthreads;

/**
 * 如果在执行过程中，每次循环都调用sleep或wait等方法，那么不需要每次迭代都检查中断状态
 * @Author: wenjun
 * @Date: 2019/10/10 12:22
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            try {
                while (num <= 10000) {
                    if(num % 100 == 0) {
                        System.out.println(num+"是100的倍数");
                    }
                    num++;
                    Thread.sleep(10);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
