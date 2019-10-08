package threadcoreknowledge.createthreads.wrongways;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器创建线程的方法
 * @Author: wenjun
 * @Date: 2019/10/8 21:14
 */
public class DemoTimerTask  {

    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000, 1000);
    }
}
