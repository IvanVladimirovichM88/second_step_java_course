package ru.geekbrains.second_step.lesson1;

public class Animal implements Competitor {
    String type;
    String name;

    int maxRunDistance;
    int maxJumpDistance;
    int maxSwimDistance;

    boolean onDistance;

    public Animal(String type, String name, int maxRunDistance, int maxJumpDistance, int maxSwimDistance) {
        this.type = type;
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpDistance = maxJumpDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (dist<=maxRunDistance){
            System.out.println(type + " " + name + " хорошо справился с кроссом ");
        }else {
            System.out.println(type + " " + name + " не справился с кроссом ");
            onDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (maxSwimDistance == 0){
            System.out.println(type + " " + name + " не умеет плавать ");
            onDistance = false;
            return;
        }
        if (dist<=maxSwimDistance){
            System.out.println(type + " " + name + " переплыл ");
        }else {
            System.out.println(type + " " + name + " не доплыл ");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height<=maxJumpDistance){
            System.out.println(type + " " + name + " перепрыгнул стену ");
        }else {
            System.out.println(type + " " + name + " не смог перепрыгнуть ");
            onDistance = false;
        }

    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(type + " " + name + " " +  onDistance);
    }
}
