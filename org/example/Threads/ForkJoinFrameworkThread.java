package org.example.Threads;

import java.util.Date;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinFrameworkThread {
    private static long numOfOperation = 10_000_000_000L;
    private static  int numOfThreads = Runtime.getRuntime().availableProcessors();//Количество ядер на компе 1 поток = 1 ядро
    public static void main(String[] args) {
        System.out.println(new Date());

        //Так делать это долгое выполнение
//        long j = 0;
//        for (long i = 0;i < numOfOperation;i++){
//            j += i;
//        }
//        System.out.println(j);

        //В 4 раза быстрее
        ForkJoinPool pool = new ForkJoinPool(numOfThreads);//пул потоков который делит операции на несколько частей
        System.out.println(pool.invoke(new MyFork(0,numOfOperation)));

        System.out.println(new Date());
    }

    static class MyFork extends RecursiveTask<Long>{

        long from,to;

        public MyFork(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if(to - from <= numOfOperation / numOfThreads){//если операция разбита на достаточное количество частей тогда выполняем операцию
                //тут сама программа
                long j = 0;
                for (long i = from;i < to;i++){
                    j += i;
                }
                return j;
            }
            else{//разбиваем на части по меньше
                //тут разбиение
                long middle = (to + from) / 2;//Тут всего будет 8 частей разделено
                MyFork firstHalf = new MyFork(from,middle);
                firstHalf.fork();//Разделить
                MyFork secondHalf = new MyFork(middle+1 ,to);
                long secondValue = secondHalf.compute();
                return firstHalf.join() + secondValue;//тут рекурсия используется
            }
        }
    }
}
