package singleton;

/**
 * 饿汉式（静态常量）（可用）
 * @Author: wenjun
 * @Date: 2019/10/28 10:36
 */
public class Singleton1 {

    private final static Singleton1 INSTANCE = new Singleton1();

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        return INSTANCE;
    }
}
