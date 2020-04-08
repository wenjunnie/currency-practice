package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 使用阻塞队列实现生产者消费者模式
 * @Author: wenjun
 * @Date: 2019/12/7 19:31
 */
public class ProducerConsumerModel2 {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> storage = new LinkedBlockingQueue<>(10);
        Thread producer = new Thread(new Producer2(storage));
        Thread consumer = new Thread(new Consumer2(storage));
        producer.start();
        //producer.sleep(10);
        consumer.start();
    }
}

class Consumer2 implements Runnable {

    BlockingQueue<Integer> storage;

    public Consumer2(BlockingQueue<Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("取走了" + storage.take());//只能用take
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer2 implements Runnable {

    BlockingQueue<Integer> storage;

    public Producer2(BlockingQueue<Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                storage.put(i);//只能用put
                System.out.println("生产了" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}