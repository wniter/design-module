package TheadDsignPatterns.Guarded_Suspecsion;

/**
 * 在 Guarded Suspension模式中,线程是否等待取决于守护条件,可是说Guarded Suspension是类似于附加条件的synchronized模式
 *
 * 如果执行现在的处理会造成问题,就让执行的线程进行等待
 */
public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "zhangsan", 3141592L).start();
        new ServerThead(requestQueue, "lisi", 6535897L).start();
    }
}
