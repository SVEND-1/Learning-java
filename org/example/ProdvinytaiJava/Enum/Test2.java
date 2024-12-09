package org.example.ProdvinytaiJava.Enum;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        Today today = new Today(WeekDays.MONDAY);
        today.daysInfo();

        WeekDays w15 = WeekDays.valueOf("MONDAY");
        System.out.println(w15);
        WeekDays [] array = WeekDays.values();//ВЫВОД ВСЕХ ЗНАЧЕНИЙ
        System.out.println(Arrays.toString(array));
    }
}

enum WeekDays{
    MONDAY("bad"),
    TUESDAY("bad"),
    WEDNESDAY("so-so"),
    THURSDAY("so-so"),
    FRIDAY("good"),
    SATURDAY("great"),
    SUNDAY("good");

    private String mood;
    private WeekDays(String mood){
        this.mood = mood;
    }
    public String getMood(){
        return  mood;
    }
}

class Today{
    WeekDays weekDays;
    public Today(WeekDays weekDays){
        this.weekDays = weekDays;
    }

    void daysInfo(){
        switch (weekDays){
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
                System.out.println("Иди на работу");
                break;
            case SATURDAY:
            case SUNDAY:
                System.out.println("Можно отдохнуть");
                break;
        }
        System.out.println("Настроение " + weekDays.getMood());
    }
}