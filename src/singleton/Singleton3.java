package singleton;

/**
 * 懒汉式（线程不安全）（不可用）
 * @Author: wenjun
 * @Date: 2019/10/28 10:43
 */
public class Singleton3 {

    private static Singleton3 instance;

    private Singleton3() {

    }

    public static Singleton3 getInstance() {
        if (instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}
