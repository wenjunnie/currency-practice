package threadcoreknowledge.startthread;

/**
 * 演示不能两次调用start()
 * @Author: wenjun
 * @Date: 2019/10/9 20:47
 */
public class CantStartTwice {

    public static void main(String[] args) {
        Thread thread = new Thread();
        thread.start();
        thread.start();
    }
}
