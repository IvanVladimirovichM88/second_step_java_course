package ru.geekbrains.lesson5;

import sun.nio.cs.StreamDecoder;

public class MainClass {

    static final int SIZE = 10000000;

    public static void main(String[] args) {
        float[] arr = new float [SIZE];
        for (int i = 0; i< SIZE; i++){
            arr[i]=1.0f;
        }

        testFirst(arr);

        float[] arr1 = new float [SIZE];
        for (int i = 0; i< SIZE; i++){
            arr1[i]=1.0f;
        }
        testSecond(arr1);


        float[] arr2 = new float [SIZE];
        for (int i = 0; i< SIZE; i++){
            arr2[i]=1.0f;
        }
        testThird(arr2, 5);

// прверка правильности

        boolean flag = true;
        for (int i = 0; i< SIZE; i++){
            if( !(arr[i] == arr1[i]) || !(arr1[i] == arr2[i])){
                System.out.println(i);
                System.out.println(arr[i] +"\t"+ arr1[i] + "\t" + arr2[i] );
                flag = false;
                break;
            }
        }
        System.out.println(flag ? "все элементы совпадают" : "ошибка");



    }

    public static void testFirst(float[] arr){
        long a = System.currentTimeMillis();
        for(int i = 0; i<arr.length; i++){
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println( System.currentTimeMillis() - a);
    }

    public static void testSecond(float[] arr){

        long a = System.currentTimeMillis();

        float[] arr1 = new float[arr.length/2];
        float[] arr2 = new float[arr.length/2];


        System.arraycopy(arr, 0, arr1, 0, arr.length/2);
        System.arraycopy(arr, arr.length/2, arr2, 0, arr.length/2);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<arr1.length; i++){
                    arr1[i] = (float)(arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0, j=arr.length/2; i<arr2.length; i++,j++){
                    arr2[i] = (float)(arr2[i] * Math.sin(0.2f + j / 5) * Math.cos(0.2f + j / 5) * Math.cos(0.4f + j / 2));
                }
            }
        });

        t1.start();
        t2.start();

        try{
            t1.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.arraycopy(arr1, 0, arr, 0, arr.length/2);
        System.arraycopy(arr2, 0, arr, arr.length/2, arr.length/2);
        System.out.println( System.currentTimeMillis() - a);
    }

    public static void testThird(float[] array, int numberOfThreads){

        long a = System.currentTimeMillis();

        float[][] tempArrays = new float[numberOfThreads][];

        int sizeOfTempArrays = array.length / numberOfThreads;
        int sizeOfEndTempArrays = array.length / numberOfThreads + array.length % numberOfThreads;

        for (int i = 0; i < numberOfThreads-1; i++){
            tempArrays[i] = new float[sizeOfTempArrays];
            System.arraycopy(array, i*sizeOfTempArrays, tempArrays[i], 0, sizeOfTempArrays);
        }
        tempArrays[numberOfThreads-1] = new float[sizeOfEndTempArrays];
        System.arraycopy (array, (numberOfThreads-1)*sizeOfTempArrays, tempArrays[numberOfThreads-1], 0, sizeOfEndTempArrays);


        Thread[] myThreads = new Thread[numberOfThreads];

        for (int i=0; i<numberOfThreads; i++){
            final int I = i;
            myThreads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0, k=sizeOfTempArrays*I; j<tempArrays[I].length; j++,k++){
                        tempArrays[I][j] = (float)(tempArrays[I][j] * Math.sin(0.2f + k / 5) * Math.cos(0.2f + k / 5) * Math.cos(0.4f + k / 2));
                    }
                }
            });
            myThreads[i].start();
        }

        try {
            for (int i=0;i<numberOfThreads; i++){
                myThreads[i].join();
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        for (int i=0;i<numberOfThreads; i++){
            System.arraycopy(tempArrays[i],0,array,i*sizeOfTempArrays, tempArrays[i].length);
        }


        System.out.println( System.currentTimeMillis() - a);
    }

}
