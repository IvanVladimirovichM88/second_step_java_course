package ru.geekbrains.second_step.lesson2Exception;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {
        super("Задан массив некорректных размеров");
    }
}
