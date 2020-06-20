package ru.geekbrains.second_step.lesson1;

public class MainClass  {

    public static void main(String[] args) {



        Team dreamTeam = new Team("Dream Team",new Human("Василий"), new Cat("Барсик"), new Dog("Джек"));
        Course c = new Course(new Cross (100), new Water(10), new Wall(1), new Wall (15));

        c.dolt(dreamTeam);

        dreamTeam.showResult();

//        Competitor[] competitors = {new Human("Василий"), new Cat("Барсик"), new Dog("Джек")};
//        Obstacle[] obstacles = {new Cross (100), new Water(10), new Wall(1), new Wall (15)};
//        for (Competitor comp :
//                competitors) {
//            for (Obstacle o :
//                    obstacles) {
//                o.doIt(comp);
//                if (!comp.isOnDistance()){
//                    break;
//                }
//            }
//        }
//        for (Competitor comp :
//                competitors) {
//            comp.info();
//        }
    }

}
