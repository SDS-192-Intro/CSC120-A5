import java.util.ArrayList;

public class Car {
   String name;
   private ArrayList<Passenger> passengersOnboard;
   private int maxCapacity;


   /** Constructor */

   public Car(int maxCapacity){
    this.maxCapacity = maxCapacity;
    this.passengersOnboard = new ArrayList<Passenger>() ;
    
   }

   /** Accessor-like Methods */
   public int getCapacity(){
    return this.passengersOnboard.size();
   }

   public int seatsRemaining(){
      return this.maxCapacity - this.passengersOnboard.size();

   }
   public void addPassenger(Passenger p){
      if (this.passengersOnboard.contains(p)){ /** Already on the train */
         throw new RuntimeException(p.getName() + "is already on this train");
      }
      this.passengersOnboard.add(p);

      System.out.println(p.getName() + " was successfully addeed to the train ");

   }

   public void removePassenger(Passenger p){
      if (!this.passengersOnboard.contains(p)){ /** The passenger is not on the train */
         throw new RuntimeException(p.getName() + "is not on this train");
      }
      this.passengersOnboard.remove(p);

      System.out.println(p.getName() + " was successfully removed from this train" + "; " + (this.maxCapacity - this.passengersOnboard.size()+ "spots remaining.")); 
      
   }

   public void printManifest(){
      if (this.passengersOnboard.size() == 0){
         throw new RuntimeException("This car is EMPTY!");
      }

      System.out.println(this.passengersOnboard);

      
   }
    public static void main(String[] args) {
      Car myCar = new Car(5);
      myCar.printManifest();
    }



}

