package org.example.Threads;

import java.util.concurrent.Phaser;

public class PhaserThread {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(2);//Разбить работу на фазы
        //Пример автомойка несколько мойщиков один салон другой внешнее моет пока оба не домоют все машина другая на это место не может заехать
        new Washer(phaser);
        new Washer(phaser);
    }

    static class Washer extends Thread {
        Phaser phaser;

        public Washer(Phaser phaser) {
            //phaser.register(); так тоже можно если конструкторе Phaser не указывать количество
            this.phaser = phaser;
            start();
        }

        @Override
        public void run() {
            for (int i = 0; i < 3;i++) {
                System.out.println(getName() + "Моют машину");
                phaser.arriveAndAwaitAdvance();//Ждет пока все потоки дойдут до это и после поток только продолжит
                //В этом примере поток продолжит выполнять цикл
            }
            //phaser.arriveAndDeregister();это если phaser.register();
        }
    }
}
