package TreadDemo.threadlocal;

/**
 * 封装每一个线程中拥有的上下文数据
 */
public class ActionContext {
    //我们的线程上下文数据
    private static ThreadLocal<Configuration> configuration = new ThreadLocal<Configuration>() {
        @Override
        protected Configuration initialValue() {
            return null;
        }
    };
    private static ThreadLocal<Resource> resource = new ThreadLocal<Resource>() {
        @Override
        protected Resource initialValue() {
            return null;
        }
    };

    //设置线程上下文数据
    public static void setConfiguration(Configuration config) {
        configuration.set(config);
    }
    public static void setResource(Resource res) {
        resource.set(res);
    }

    //获取上下文数据

    public static Configuration getConfiguration() {
        return configuration.get();
    }


    public static Resource getResource() {
        return resource.get();
    }
}
