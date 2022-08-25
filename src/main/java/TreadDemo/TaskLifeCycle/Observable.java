package TreadDemo.TaskLifeCycle;

/**
 *
 */
public interface Observable {
     enum  Cycle {
         ready,
        start,
        run,
        end,
        error;
    }

    //获取生命周期
    public Cycle getCycle();

}
