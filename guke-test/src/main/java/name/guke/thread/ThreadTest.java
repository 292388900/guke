package name.guke.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/**
 * Created by GUKE on 2016/4/22.
 */
public class ThreadTest {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        ExecutorService cachedThreadPool1 = Executors.newCachedThreadPool(Executors.defaultThreadFactory());

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);

        ExecutorService fixedThreadPool1 = Executors.newFixedThreadPool(1, Executors.defaultThreadFactory());

        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(1);

        ScheduledExecutorService scheduledThreadPool1 = Executors.newScheduledThreadPool(1, Executors.defaultThreadFactory());

        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
    }
}
