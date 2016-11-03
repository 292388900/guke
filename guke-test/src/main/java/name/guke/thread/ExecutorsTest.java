package name.guke.thread;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by GUKE on 2016/10/16.
 */
public class ExecutorsTest {
    public static void main(String[] args){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        ArrayList<Future<String>> list=new ArrayList<Future<String>>();
        for (int i = 0; i < 5; i++){
            //executor.execute(new Task());
            //Future和每个线程关联
            Future<String> result=executor.submit(new TaskCallable());
            list.add(result);
        }
        executor.shutdown();
        while(!executor.isTerminated()){
            System.out.printf("Pool size:%d,Active count:%d,Completed Task:%d\n",executor.getPoolSize(),executor.getActiveCount(),executor.getCompletedTaskCount());
        }
    }

}
class Task implements Runnable{
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is called");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class TaskCallable implements Callable<String> {

    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName() + " is called");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Thread.currentThread().getName();
    }
}