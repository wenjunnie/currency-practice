package threadcoreknowledge.uncaughtexception;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 自己的MyUncaughtExceptionHandler
 * @Author: wenjun
 * @Date: 2019/10/15 21:00
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

    private String name;

    public MyUncaughtExceptionHandler(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING,"线程异常，终止啦！线程名：" + t.getName(),e);
        System.out.println(name + "捕获了异常" + t.getName() + "异常" + e);
    }
}
