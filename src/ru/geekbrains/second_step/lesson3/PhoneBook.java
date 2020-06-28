package ru.geekbrains.second_step.lesson3;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PhoneBook {
    HashMap<String, String>  registration;

    public PhoneBook() {
        this.registration = new HashMap<>();
    }

    public PhoneBook(String name, String phone) {
        this.registration = new HashMap<>();
        registration.put(phone,name);
    }

    public void add(String name, String phone){
        registration.put(phone,name);
    }
    public void get(String name){
        if (registration.containsValue(name)){
            Set<Map.Entry<String,String>> set = registration.entrySet();
            for (Map.Entry<String,String> reg : set){
                if(reg.getValue().equalsIgnoreCase(name)){
                    System.out.println( reg.getValue() + "\t Phone - " + reg.getKey());
                }
            }
        }
    }
    public void printAll(){
        Set<Map.Entry<String,String>> set = registration.entrySet();
        for (Map.Entry<String,String> reg : set){
            System.out.println("Name - "+reg.getValue() + "\t Phone - " + reg.getKey());
        }
    }
}
