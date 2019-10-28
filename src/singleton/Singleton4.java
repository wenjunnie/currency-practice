package singleton;

/**
 * 懒汉式（线程安全）（不推荐）
 * @Author: wenjun
 * @Date: 2019/10/28 10:43
 */
public class Singleton4 {

    private static Singleton4 instance;

    private Singleton4() {

    }

    public synchronized static Singleton4 getInstance() {
        if (instance == null) {
            instance = new Singleton4();
        }
        return instance;
    }
}
