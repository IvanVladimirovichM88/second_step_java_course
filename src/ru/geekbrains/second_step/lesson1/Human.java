package ru.geekbrains.second_step.lesson1;

public class Human implements Competitor {
    String name;

    int maxRunDistance;
    int maxJumpDistance;
    int maxSwimDistance;

    boolean onDistance;

    public Human( String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxJumpDistance = 20;
        this.maxSwimDistance = 1000;
        this.onDistance = true;
    }

    @Override
    public void run(int dist) {
        if (dist<=maxRunDistance){
            System.out.println(" " + name + " хорошо справился с кроссом ");
        }else {
            System.out.println(" " + name + " не справился с кроссом ");
            onDistance = false;
        }
    }

    @Override
    public void swim(int dist) {
        if (maxSwimDistance == 0){
            System.out.println(" " + name + " не умеет плавать ");
            onDistance = false;
            return;
        }
        if (dist<=maxSwimDistance){
            System.out.println(" " + name + " переплыл ");
        }else {
            System.out.println(" " + name + " не доплыл ");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height<=maxJumpDistance){
            System.out.println(" " + name + " перепрыгнул стену ");
        }else {
            System.out.println(" " + name + " не смог перепрыгнуть ");
            onDistance = false;
        }

    }

    @Override
    public boolean isOnDistance() {
        return onDistance;
    }

    @Override
    public void info() {
        System.out.println(" " + name + " " +  onDistance);
    }

}
