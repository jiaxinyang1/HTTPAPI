package pool;

import java.util.concurrent.*;

/**
 * ThreadPool
 *
 * @author hakurei
 * @date 2019/5/4
 */

public class ThreadPool {

    private static ThreadPool threadPool;
    private ExecutorService singleThreadPool;
    private int corePoolSize = 5;
    private int maximumPoolSize = 10;
    private int keepAliveTime = 10000;

    private ThreadPool() {

        ThreadFactory nameThreadFactory = new ThreadFactoryBuilder();
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        singleThreadPool = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, TimeUnit.MILLISECONDS,
                linkedBlockingQueue, nameThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }


    public static ThreadPool getPool() {

        if (threadPool == null) {
            return new ThreadPool();
        } else {
            return threadPool;
        }
    }

    public ExecutorService getSingleThreadPool() {
        return  singleThreadPool;


    }
}