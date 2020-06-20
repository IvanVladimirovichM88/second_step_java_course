package ru.geekbrains.second_step.lesson1;

public class Team {
    private Competitor [] competitors;
    private int counterCompetitorOnDistance;
    private String nameTeam;

    public Team(String nameTeam, Competitor... competitors){
        this.nameTeam = nameTeam;
        this.competitors = competitors;
        counterCompetitorOnDistance = this.competitors.length;
    }


    public Competitor[] returnCompetitors(){
        return competitors;
    }


    public boolean isOnDistance() {
        return counterCompetitorOnDistance > 0;
    }

    public void infoFinishedDistance() {
        if ( this.isOnDistance() ){
            System.out.println("дистанцию прошли следующие участники: ");
            for (Competitor competitor : competitors) {
                if (competitor.isOnDistance()) {
                    competitor.info();
                }
            }
        }else {
            System.out.println("команда не смогла пройти дистанцию");
        }
    }
    public void infoAllCompetitor()
    {
        System.out.println(" на дистанции стартовали следующие участники ");
        for (Competitor competitor : competitors) {
            competitor.info();
        }
    }

    public void showResult(){
        System.out.println();
        this.infoAllCompetitor();
        System.out.println();
        this.infoFinishedDistance();
    }


}
