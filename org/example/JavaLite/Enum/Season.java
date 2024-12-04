package org.example.JavaLite.Enum;

public enum Season {
    SUMMER(30),// index 0
    WINTER(-30),// index 1
    AUTUMN(15), // index 2
    SPRING(10); // index 3

    private  int tempetarute;
    Season(int tempetarute){
        this.tempetarute = tempetarute;
    }

    public int getTempetarute(){
        return tempetarute;
    }
}
