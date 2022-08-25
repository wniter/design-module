package TheadDsignPatterns.GuardedSuspecsion;

public class Request {
    //发出请求
    private final String name;

    public Request(String name) {
        this.name = name;
    }
    public  String getName() {
        return name;
    }

}
