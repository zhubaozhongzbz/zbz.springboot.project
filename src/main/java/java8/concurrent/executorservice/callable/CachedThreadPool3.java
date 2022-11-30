package java8.concurrent.executorservice.callable;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
//call() 完全独立于所有其他 CountingTasks 生成其结果，这意味着没有可变的共享状态;
//只有在所有任务完成后，invokeAll() 才会返回一个 Future 列表，每个任务一个 Future 。
// Future 是 Java 5 中引入的机制，允许你提交任务而无需等待它完成。
public class CachedThreadPool3 {
    public static Integer extractResult(Future<Integer> f) {
        try {
            return f.get();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args)throws InterruptedException {
        ExecutorService exec =
                Executors.newCachedThreadPool();
        List<CountingTask> tasks =
                IntStream.range(0, 10)
                        .mapToObj(CountingTask::new)
                        .collect(Collectors.toList());
        List<Future<Integer>> futures =
                exec.invokeAll(tasks);
        Integer sum = futures.stream()
                .map(CachedThreadPool3::extractResult)
                .reduce(0, Integer::sum);
        System.out.println("sum = " + sum);
        exec.shutdown();
    }
}