package ru.geekbrains.second_step.lesson1;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles){
        this.obstacles = obstacles;
    }

    public void dolt(Competitor competitor){
        for(Obstacle o: this.obstacles){
            if ( competitor.isOnDistance() ){
                o.doIt(competitor);
            }
        }
    }

    public void dolt(Team team){
        for ( Competitor competitor : team.returnCompetitors() ){
            this.dolt(competitor);
        }
    }
}
