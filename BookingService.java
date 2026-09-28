import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookingService {

    private List<Train> trainList = new ArrayList<>();
    private List<Ticket> ticketList =new ArrayList<>();
    private List<Date> date =new ArrayList<>();

    public BookingService() {
        trainList.add(new Train(101,"Delhi","Rajdhani Express","Nagpur",100, LocalDate.of(2026,3,5)));
        trainList.add(new Train(102,"Delhi","Shatabdi","Mumbai",60,LocalDate.of(2026,3,15)));
        trainList.add(new Train(103,"Agra","Durunto Express","Delhi",70,LocalDate.of(2026,3,25)));
        trainList.add(new Train(104,"Delhi","Vande Bharat Express","Goa",100,LocalDate.of(2026,4,2)));
        trainList.add(new Train(105,"Kolkata","Intercity Express","Manali",90,LocalDate.of(2026,4,20)));
        trainList.add(new Train(106,"Delhi","Tejas Express","Bengaluru",80,LocalDate.of(2026,4,22)));
        trainList.add(new Train(107,"Sehore","Panchwali", "Indore",10,LocalDate.of(2026,04,04)));

    }
    public List<Train> searchTrain(String source,String destination)
    {
        List<Train> res=new ArrayList<>();
        for(Train train :trainList)
        {
            if(train.getSource().equalsIgnoreCase(source)&& train.getDestination().equalsIgnoreCase(destination) )
            {
                res.add(train);
            }
        }
        return res;
    }
    public Ticket bookTicket(User user,int trainId,int seatCount)
    {
        for(Train train:trainList)
        {
            if(train.getTrainId()==trainId)
            {
                if(train.bookSeats(seatCount))
                {
                    Ticket ticket=new Ticket(user,train,seatCount);
                    ticketList.add(ticket);
                    return ticket;
            }
                else{
                    System.out.println("NO enough seats available");
                    return null;
                }
              }
        }
        System.out.println("Train ID not found");
        return null;
    }
    public List<Ticket> getTicketByUser(User user)
    {
        List<Ticket> res =new ArrayList<>();
        for(Ticket ticket:ticketList)
        {
            if(ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername()))
            {
                res.add(ticket);
            }
        }
        return res;
    }
    public boolean CancelTicket(int ticketId,User user)

    {
        Iterator<Ticket> iterator=ticketList.listIterator();
        while(iterator.hasNext()){
            Ticket ticket=iterator.next();
            if(ticket.getTicketId()==ticketId && ticket.getUser().getUsername().equalsIgnoreCase(user.getUsername()))
            {
                Train train=ticket.getTrain();
                train.cancelSeats(ticket.getSeatBooked());
                iterator.remove();
                System.out.println("Ticket"+ticketId+"cancelled Successfully");
                return true;
            }
        }
        System.out.println("Ticket not found or does not belong to current user");
        return false;
    }
     public void listAllTrains()
     {
         System.out.println("list of all trains");
         for(Train train: trainList)
         {
             System.out.println(train);
         }
     }
}
