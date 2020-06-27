package ru.geekbrains.second_step.lesson2;

import ru.geekbrains.second_step.lesson2Exception.MyArrayDataException;
import ru.geekbrains.second_step.lesson2Exception.MyArraySizeException;

public class MainClass {
    static  int ARRAYSIZE = 4;

    public static void main(String[] args) {
        String  array[][] = new String[ARRAYSIZE][ARRAYSIZE] ;
        for (int i=0; i<ARRAYSIZE; i++){
            for (int j=0; j<ARRAYSIZE; j++){
                array[i][j] = String.valueOf(i) + String.valueOf(j);
            }
        };


        try{
            System.out.println( "сумма чисел массиива = "+ arrayConversion( array ) );
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println();

        array[0][2] = "op";

        try{
            System.out.println( arrayConversion( array ) );
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

        System.out.println();

        String [][]arrayBad = new String [][]{
                {"1","2","3","4"},
                {"1","2","3","4"},
                {"1","2","3"},
                {"1","2","3","4"}
        };

        try{
            System.out.println( arrayConversion( arrayBad ) );
        }catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }

    static int arrayConversion(String[][] array) throws MyArraySizeException, MyArrayDataException {

        if ( array.length != ARRAYSIZE ) {
            throw new MyArraySizeException();
        }
        for (int i=0; i<array.length; i++){
            if (array[i].length != ARRAYSIZE){
                throw new MyArraySizeException();
            }
        }

        int sum = 0;

        for (int j = 0; j < ARRAYSIZE; j++){
            for (int i = 0; i < ARRAYSIZE; i++ ){
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
