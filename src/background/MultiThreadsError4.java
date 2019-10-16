package background;

/**
 * 初始化未完毕，就this赋值。
 * @Author: wenjun
 * @Date: 2019/10/16 21:35
 */
public class MultiThreadsError4 {

    static Point point;

    public static void main(String[] args) throws InterruptedException {
        new PointMaker().start();
        //Thread.sleep(80); 输出1,0，因为y还没有被初始化。
        Thread.sleep(200); //输出1,1，因为此时y已经被初始化了。
        if(point != null) {
            System.out.println(point);
        }
    }
}

class Point{

    private final int x,y;

    public Point(int x, int y) throws InterruptedException {
        this.x = x;
        MultiThreadsError4.point = this;//给point赋值this
        Thread.sleep(100);
        this.y = y;
    }

    @Override
    public String toString() {
        return x + "," + y;
    }
}

class PointMaker extends Thread {

    @Override
    public void run() {
        try {
            new Point(1,1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}