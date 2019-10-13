package threadcoreknowledge.threadobjectclasscommonmethods;

import java.util.*;

/**
 * 用wait/notify来实现生产者消费者模式
 * @Author: wenjun
 * @Date: 2019/10/13 19:49
 */
public class ProducerConsumerModel {

    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Thread producer = new Thread(new Producer(storage));
        Thread consumer = new Thread(new Consumer(storage));
        producer.start();
        consumer.start();
    }
}

class Producer implements Runnable {
    private EventStorage storage;

    public Producer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                storage.put();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Consumer implements Runnable {
    private EventStorage storage;

    public Consumer(EventStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                storage.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class EventStorage{
    private int maxSize;
    private LinkedList<Date> storage;

    public EventStorage() {
        this.maxSize = 10;
        this.storage = new LinkedList<>();
    }

    public synchronized void put() throws InterruptedException {
        while (storage.size() == maxSize) {
            wait();
        }
        storage.add(new Date());
        System.out.println("仓库里有了" + storage.size() + "个产品");
        notify();
    }

    public synchronized void take() throws InterruptedException {
        while (storage.size() == 0) {
            wait();
        }
        System.out.println("拿到了" + storage.poll() + "仓库还剩下" + storage.size());
        notify();
    }
}
