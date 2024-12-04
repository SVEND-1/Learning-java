package org.example.JavaLite.AbstraktniClass;

public abstract class Animal {//АБСТРАКТНЫЙ КЛАСС НЕ СОЗДАЕТСЯ ,НО ЯВЛЯЕТСЯ ОСНОВОЙ ДЛЯ ДРУГИХ ЕГО НАСЛЕДНИКОВ
    public void eat(){//ТИПО ВСЕ ЖИВОТНЫЕ ЕДЯТ
        System.out.println("eat");
    }
    public abstract void mobeSound();//ТУТ abstract ПОТОМУ ЧТО РАЗНЫМИ СПОСОБАМИ ГОВОРЯТ(ЗВУКИ ПРОИЗНОСЯТ)
    //НЕ abstract методы не надо реализовывать каждому ,а abstract методы надо у каждого реаливывать

}
