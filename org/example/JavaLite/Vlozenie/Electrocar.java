package org.example.JavaLite.Vlozenie;

public class Electrocar {
    private int id;
    private class Motor{//ТУТ ИМЕТ ДОСТУП К ПОЛЯМ ТАКИМ КАК ID
        public void startMotor(){//КЛАСС В КЛАССе
            System.out.println("Мотор стартует");
        }
    }
    public static class Battery{//ТУТ НЕ ИМЕТ ДОСТУП К ПОЛЯМ ТАКИМ КАК ID ТОЛЬКО К СТАТИК ПОЛЯМ
        public void charge(){
            System.out.println("Батарея заряжается");
        }
    }

    public Electrocar(int id){
        this.id = id;
    }
    public void start(){
        Motor motor = new Motor();
        motor.startMotor();
        int x = 1;
        final int a = 1;

        class SomeClass{
            public void someMetod(){//ТУТ МЫ ИМЕЕМ ДОСТУП КО ВСЕМУ ,НО ПОЛЯ ДОЛЖНЫ БЫТЬ FINAL
                System.out.println(id);//
                System.out.println(x);
                System.out.println(a);//ЛУЧШЕ ИСПОЛЬЗОВАТЬ FINAL
            }
        }

        System.out.println("Машина" + id + "стартует");
    }
}
