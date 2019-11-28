package thread;

/**
 * Describe:
 *
 * @Author fuderong
 * @Date 2019/11/26
 * @Version 1.0
 */
public class Machine extends Thread {
    @Override
    public void run() {
        for(int a = 0;a < 50;a++){
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        Machine machine = new Machine();
        // 启动machine线程
        machine.start();
    }
}
