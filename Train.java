import java.time.LocalDate;

public class Train {
    private int trainId;
    private String source;
    private String name;
    private String destination;
    private int totalSeats;
    private int availableSeats;
    public LocalDate date;

    public Train(int trainId,String source,String name,String destination,int totalSeats, LocalDate date){
        this.trainId= trainId;
        this.name= name;
        this.availableSeats= totalSeats;
        this.source= source;
        this.destination= destination;
        this.totalSeats= totalSeats;
        this.date=date;
    }

    public int getTrainId(){
        return trainId;
    }
    public void setTrainId(int trainID){
        this.trainId = trainId;
    }
    public String getname(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAvailableSeats(){
        return availableSeats;
    }
    public void setAvailableSeats(int availableSeats){
        this.availableSeats=availableSeats;
    }
    public String getSource(){
        return source;
    }
    public void setSource(String source){
        this.source=source;
    }
    public String getDestination(){
        return destination;
    }
    public void setDestination(String destination){
        this.destination=destination;
    }
    public int getTotalSeats(){
        return totalSeats;
    }
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public boolean bookSeats(int count){
        if(count<=availableSeats){
            availableSeats-=count;
            return true;
        }
             return false;
    }
    public void cancelSeats(int count){
        availableSeats+=count;
    }
    @Override
    public String toString(){
        return trainId +"|"+name+"|"+source+"->"+destination+"Seats Available:"+availableSeats+"|"+"Date"+date;
    }
}
