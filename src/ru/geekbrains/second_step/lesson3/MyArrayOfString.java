package ru.geekbrains.second_step.lesson3;

import com.sun.javaws.IconUtil;

import java.util.ArrayList;

public class MyArrayOfString {

    private ArrayList<UniqueElement> uniqueElements;

    public MyArrayOfString(String[] elements) {
        this.uniqueElements = new ArrayList<UniqueElement>(elements.length);
        for (int i=0; i<elements.length; i++){
            if ( ! hasElementBeforePositionInArray(elements, i, elements[i]) ){
                int counter = quantityElementInArray(elements, i);
                uniqueElements.add( new UniqueElement(elements[i],counter) );
            }
        }
    }

    public  void printUniqueElements(){
        for (UniqueElement uniqueElement : uniqueElements) {
            System.out.println(uniqueElement.getElement() + " occurs in array - " +
                    uniqueElement.getCounter());
        }
    }

    private boolean hasElementBeforePositionInArray(String[] array, int position, String string ){

        if ( position == 0 ){
            return false;
        }
        for (int i=position-1; i>0; i--){
            if (array[i].equalsIgnoreCase(string)){
                return true;
            }
        }
        return false;
    }

    private int quantityElementInArray(String[] array, int indexElement ){
        int counter = 0;
        for (int i=indexElement; i<array.length; i++){
            if ( array[i].equalsIgnoreCase(array[indexElement]) ){
                counter++;
            }
        }
        return  counter;
    }
}

class UniqueElement {
    String element;
    int counter;

    public UniqueElement(String element, int counter) {
        this.element = element;
        this.counter = counter;
    }

    public String getElement() {
        return element;
    }

    public int getCounter() {
        return counter;
    }
}
