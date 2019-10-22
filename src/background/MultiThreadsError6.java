package background;

import java.util.HashMap;
import java.util.Map;

/**
 * 构造函数中新建线程
 * @Author: wenjun
 * @Date: 2019/10/16 20:50
 */
public class MultiThreadsError6 {

    private Map<String,String> states;

    public MultiThreadsError6() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                states = new HashMap<>();
                states.put("1","周一");
                states.put("2","周二");
                states.put("3","周三");
                states.put("4","周四");
            }
        }).start();
    }

    public Map<String,String> getStates() {
        return states;
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadsError6 multiThreadsError3 = new MultiThreadsError6();
        //Thread.sleep(100);
        Map<String,String> state = multiThreadsError3.getStates();
        System.out.println(state.get("1"));
    }
}
