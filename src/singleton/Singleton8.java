package singleton;

/**
 * 枚举单例
 * 最好的方法（1.写法简单2.线程安全有保障3.避免反序列化破坏单例）
 * @Author: wenjun
 * @Date: 2019/10/28 10:43
 */
public enum Singleton8 {

    INSTANCE;

    public void whatever() {

    }
}
