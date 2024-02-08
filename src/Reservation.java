public class Reservation {
    private String name; //not implemented yet lol
    private int nPeople;
    private int timeMade;
    private int timeFor;
    private boolean waitlisted; //not implemented yet

    public Reservation() {
        nPeople = (int)(Math.random() * 10) + 1;
        timeFor = (int) (Math.random() * 960) + 360;
        timeMade = (int) (Math.random() * 1440);
    }

    public String printInfo(){
        if (timeFor % 60 < 10 && timeMade % 60 < 10){
            return ("Reservation for " + nPeople + " at " + (int)(timeFor/60) + ":0" + (int)(timeFor%60) + " made at " + (int)(timeMade/60) + ":0" + (int)(timeMade%60) );
        } else if (timeFor % 60 < 10){
            return ("Reservation for " + nPeople + " at " + (int)(timeFor/60) + ":0" + (int)(timeFor%60) + " made at " + (int)(timeMade/60) + ":" + (int)(timeMade%60) );
        } else if (timeMade % 60 < 10){
            return ("Reservation for " + nPeople + " at " + (int)(timeFor/60) + ":" + (int)(timeFor%60) + " made at " + (int)(timeMade/60) + ":0" + (int)(timeMade%60) );
        } else {
            return ("Reservation for " + nPeople + " at " + (int) (timeFor / 60) + ":" + (int) (timeFor % 60) + " made at " + (int) (timeMade / 60) + ":" + (int) (timeMade % 60));
        }
    }

    public int getNPeople(){
        return nPeople;
    }
    public int getTimeFor() { return timeFor; }
    public int getTimeMade() { return timeMade; }

}
