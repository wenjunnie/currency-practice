package singleton;

/**
 * 静态内部类（可用）
 * @Author: wenjun
 * @Date: 2019/10/28 10:43
 */
public class Singleton7 {

    private Singleton7() {

    }

    private static class SingletonInstance {
        //只有需要Singleton7实例时才会加载（懒汉+安全）
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }
}
