package org.example.Threads;

import java.util.concurrent.*;

public class ExecutorsThread {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);//Количество потоков которые будет использоваться
        executorService.submit(new MyExecutorRunnable());

        Future<String> future = executorService.submit(new MyExecutorCallable());
        System.out.println(future.get());

        executorService.shutdown();
    }

    static class MyExecutorRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println(1);
        }
    }

    static class MyExecutorCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "2";
        }
    }
}
