package singleton;

/**
 * 双重检查（推荐面试使用）
 * @Author: wenjun
 * @Date: 2019/10/28 10:43
 */
public class Singleton6 {

    private volatile static Singleton6 instance;//防止重排序和保证可见性

    private Singleton6() {

    }

    public static Singleton6 getInstance() {
        if (instance == null) {
            synchronized (Singleton6.class) {
                if (instance == null) {
                    //新建对象实际有3个步骤（非原子操作）:1.创建空的对象2.调用构造方法3.赋值到对象上
                    //重排序:1.创建空的对象2.赋值到对象上3.调用构造方法，导致对象内的属性为空
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
