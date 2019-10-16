package background;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 运行结果出错.
 * 演示计数不准确（减少），找出具体出错的位置。
 * @Author: wenjun
 * @Date: 2019/10/16 12:02
 */
public class MultiThreadsError implements Runnable{

    static MultiThreadsError instance = new MultiThreadsError();
    static int index = 0;
    //原子整型将index++三个步骤合为一个
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger wrongCount = new AtomicInteger();
    static volatile CyclicBarrier cyclicBarrier1 = new CyclicBarrier(2);
    static volatile CyclicBarrier cyclicBarrier2 = new CyclicBarrier(2);

    final boolean[] marked = new boolean[1000000];

    public static void main(String[] args) throws InterruptedException {
        MultiThreadsError instance = new MultiThreadsError();
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("表面上结果是：" + index);
        System.out.println("真正运行的次数：" + realIndex);
        System.out.println("错误次数：" + wrongCount);
    }

    @Override
    public void run() {
//        while (index < 10000) {
//            index++;
//        }
        marked[0] = true;
        for (int i = 0; i < 100000; i++) {
            try {
                cyclicBarrier2.reset();
                cyclicBarrier1.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            index++;
            try {
                cyclicBarrier1.reset();
                cyclicBarrier2.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            realIndex.incrementAndGet();
            synchronized (instance) {
                if (marked[index] && marked[index-1]) {
                    System.out.println("发生错误" + index);
                    wrongCount.incrementAndGet();
                }
                marked[index] = true;
            }
        }
    }
}
