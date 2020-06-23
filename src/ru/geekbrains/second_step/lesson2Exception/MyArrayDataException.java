package ru.geekbrains.second_step.lesson2Exception;

public class MyArrayDataException extends Exception {

    public MyArrayDataException (int x, int y) {
        super("в позиции [" + x + "], [" + y +"] не число");
    }
}
