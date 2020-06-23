package ru.geekbrains.second_step.lesson2;

public enum DayOfWeek {
    MONDAY("Понедельник", 8),
    TUESDAY("Вторник", 8),
    WEDNESDAY("Среда", 8),
    THURSDAY("Четверг", 8),
    FRIDAY("Пятница", 8),
    SATURDAY("Суббота", 0),
    SUNDAY("Воскресенье", 0);

    String name ;
    int workHours;

    DayOfWeek(String name, int workHours) {
        this.name = name;
        this.workHours = workHours;
    }


}


class DayOfWeekMain {
    public static void main(String[] args) {
        System.out.println( getWorkingHours(DayOfWeek.SUNDAY) );
    }

    public static String getWorkingHours(DayOfWeek day){
        int workingHours = 0;

        for (int i = day.ordinal() ; i < DayOfWeek.SATURDAY.ordinal(); i++){
            workingHours += DayOfWeek.values()[i].workHours;
        }

        return workingHours>0 ? "Осталось рабочих часов - " + workingHours : "Указан выходной";
    }
}

