package org.example.Threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableAndFutures {//Это чтобы возвращать значение из потока работает на основе run
    public static void main(String[] args) {
        Callable<Integer> callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();

        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {//Это чтобы возвращать результат
            int j = 0;
            for (int i = 0; i < 10; i++,j++) {
                Thread.sleep(300);
            }
            return j;
        }
    }
}
