package jmm;

/**
 * 演示可见性带来的问题
 * 如果不加上volatile关键字，可能会出现b = 3 a = 1的结果。
 * @Author: wenjun
 * @Date: 2019/10/24 18:44
 */
public class FieldVisibility {

    volatile int a = 1;
    volatile int b = 2;//实际上只对b加上volatile关键字就可以了，因为读取b时，b前的所有操作都看得到。

    private void change() {
        a = 3;
        b = a;
    }

    private void print() {
        System.out.println("b = " + b + " a = " + a);
    }

    public static void main(String[] args) {
        while (true) {
            FieldVisibility test = new FieldVisibility();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();
        }
    }
}
