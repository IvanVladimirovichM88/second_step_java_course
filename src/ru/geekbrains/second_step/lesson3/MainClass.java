package ru.geekbrains.second_step.lesson3;

public class MainClass {
    public static void main(String[] args) {

// первое задание
        String [] array = fillArray();
        array[10] = array[15] = array[2];

        MyArrayOfString myArray = new MyArrayOfString(array);
        myArray.printUniqueElements();

// второе задание
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Лисица", "11-30");
        phoneBook.add("Бобер", "15-40");
        phoneBook.add("Волчара", "21-40");
        phoneBook.add("Воробей", "65-05");
        phoneBook.add("Медведь", "26-73");
        phoneBook.add("Волчара", "30-72");
        phoneBook.add("Бобер", "15-78");

        phoneBook.printAll();

        System.out.println("ищем телефон Бобра");
        phoneBook.get("Бобер");

    }

    static String[] fillArray(){
        String[] array = new String['z'-'a'+1];
        int counter =0;
        for (char i='a'; i <='z'; i++){
            array[counter] = ""+i+i+i+i;
            counter++;
        }
        return array;
    }

}
