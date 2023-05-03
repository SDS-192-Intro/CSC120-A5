import java.util.ArrayList;
public class Train {

    private final Engine engine;
    private ArrayList<Car> CarsAttached;

/*Creates the Train */
    public Train(FuelType FuelType, double maxFuelLevel, int nCars, int maximum_capacity){
        this.engine = new Engine(FuelType, maxFuelLevel);
        this.CarsAttached = new ArrayList<Car>();
        for (int i=0; i<nCars; i++){
            this.CarsAttached.add(new Car(maximum_capacity));
        }

    }

    public Engine getEngine(){
        return this.engine;
    }

    public Car getCar(int i){
        if (i>CarsAttached.size()){
            throw new RuntimeException(" 'i' is out of range; The train has "+ CarsAttached.size() + "cars .");
        }
        return this.CarsAttached.get(i);
    }

    public int getMaxCapacity(){
        int getMaxCapacity_value = 0;
        for (int i =0; i<CarsAttached.size(); i++) {
            getMaxCapacity_value = getMaxCapacity_value + CarsAttached.get(i).getCapacity();
        }
        return getMaxCapacity_value;
    }

    public int seatsRemaining() {
       int seatsRemaining_value = 0; 
       for (int i=0; i<CarsAttached.size(); i++) {
           seatsRemaining_value = seatsRemaining_value + CarsAttached.get(i).seatsRemaining();
       }
       return seatsRemaining_value;
    }

    public void printManifest() {
        for (int i=0; i<this.CarsAttached.size(); i++){ 
            CarsAttached.get(i).printManifest();
        }
    }


    public static void main(String[] args) {
        Train newTrain = new Train (FuelType.ELECTRIC,100.0, 5, 35);
        newTrain.CarsAttached.add(new Car(15));
        try{
            while (true) {
                newTrain.engine.go();
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
        newTrain.engine.refuel();
        System.out.println(newTrain.engine.getFuelLevel());

        Passenger Steve = new Passenger("Steve Jobs");
        Passenger Finn = new Passenger("Finn");

        newTrain.CarsAttached.get(0).addPassenger(Steve);
        newTrain.CarsAttached.get(1).addPassenger(Finn);
        newTrain.CarsAttached.get(1).removePassenger(Steve);
        System.out.println(newTrain.getMaxCapacity());
        System.out.println(newTrain.seatsRemaining());
        newTrain.printManifest();

        Car carOne = new Car(10);
        Finn.boardCar(carOne);
        Finn.boardCar(carOne); 
        Finn.getOffCar(carOne);
        Finn.getOffCar(carOne); 
        carOne.addPassenger(Finn);
        carOne.printManifest();
        carOne.removePassenger(Finn);
        System.out.println("Passenger kicked out.");
        carOne.printManifest();

    }
}

