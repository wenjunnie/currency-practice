package threadcoreknowledge.threadobjectclasscommonmethods;

/**
 * ID从1开始，JVM运行起来后，我们自己创建的ID早已不是2
 * @Author: wenjun
 * @Date: 2019/10/15 19:45
 */
public class Id {

    public static void main(String[] args) {
        Thread thread = new Thread();
        System.out.println("主线程ID"+Thread.currentThread().getId());
        System.out.println("子线程ID"+thread.getId());
    }
}
