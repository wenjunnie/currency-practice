package jmm;

import java.util.concurrent.CountDownLatch;

/**
 * 演示重排序的现象（代码的实际执行顺序和代码在Java文件中的顺序不一致）
 * “直到达到某个条件才停止”，测试小概率事件
 * @Author: wenjun
 * @Date: 2019/10/23 15:45
 */
public class OutOfOrderExecution {

    private static int x = 0, y = 0;//加上volatile可禁止重排序
    private static int a = 0, b = 0;//加上volatile可禁止重排序

    public static void main(String[] args) throws InterruptedException {
        int i = 0;

        for (; ; ) {
            i++;
            x = 0;
            y = 0;
            a = 0;
            b = 0;

            CountDownLatch latch = new CountDownLatch(1);

            Thread one = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    a = 1;
                    x = b;
                }
            });
            Thread two = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    b = 1;
                    y = a;
                }
            });
            one.start();
            two.start();
            latch.countDown();
            one.join();
            two.join();

            String result = "第" + i + "次(" + "x = " + x + ", y = " + y + ")";
            if(x == 0 && y == 0) {
                System.out.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }
}
