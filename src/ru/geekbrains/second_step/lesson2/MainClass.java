package ru.geekbrains.second_step.lesson2;

import ru.geekbrains.second_step.lesson2Exception.MyArrayDataException;
import ru.geekbrains.second_step.lesson2Exception.MyArraySizeException;

public class MainClass {
    public static void main(String[] args) {
        String  arrayFirst[][] = new String[][]{
                {"11", "21", "31", "41"},
                {"12", "22", "32", "42"},
                {"13", "23", "33", "43"},
                {"14", "24", "34", "44"}
        };

        String  arraySecond[][] = new String[][]{
                {"11", "21", "op", "41"},
                {"12", "22", "32", "42"},
                {"13", "23", "23", "43"},
                {"14", "24", "34", "44"}
        };

        String  arrayThird[][] = new String[][]{
                {"11", "21", "22"},
                {"12", "22", "32"},
                {"13", "23", "23"},
                {"14", "24", "34"}
        };

        try{
            System.out.println( "сумма чисел массиива = "arrayConversion( arrayFirst ) );
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println();

        try{
            System.out.println( arrayConversion( arraySecond ) );
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println();

        try{
            System.out.println( arrayConversion( arrayThird ) );
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    static int arrayConversion(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if ( ( array.length != 4 ) || ( array[0].length != 4 ) ){
            throw new MyArraySizeException();
        }

        int sum = 0;

        for (int j = 0; j < 4; j++){
            for (int i = 0; i<4; i++ ){
                try {
                    sum += Integer.parseInt(array[j][i]);

                } catch (NumberFormatException e){
                    throw new MyArrayDataException(i,j);
                }
            }
        }
        return sum;
    }
}
