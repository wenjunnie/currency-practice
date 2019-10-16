package background;

import java.util.HashMap;
import java.util.Map;

/**
 * 发布逸出
 * @Author: wenjun
 * @Date: 2019/10/16 20:50
 */
public class MultiThreadsError3 {

    private Map<String,String> states;

    public MultiThreadsError3() {
        states = new HashMap<>();
        states.put("1","周一");
        states.put("2","周二");
        states.put("3","周三");
        states.put("4","周四");
    }

    public Map<String,String> getStates() {
        return states;
    }

    public static void main(String[] args) {
        MultiThreadsError3 multiThreadsError3 = new MultiThreadsError3();
        Map<String,String> state = multiThreadsError3.getStates();
        System.out.println(state.get("1"));
        state.remove("1");
        System.out.println(state.get("1"));
    }
}
