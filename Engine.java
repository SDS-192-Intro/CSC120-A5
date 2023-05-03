public class Engine {
    private FuelType FuelType;
    private double currentFuelLevel;
    private double maxFuelLevel;

    /** Accessor */
    public FuelType getFuelType(){
        return this.FuelType;
    }

    public double getFuelLevel(){
        return this.currentFuelLevel;
    }

    /** Constructor */
    public Engine(FuelType FuelType, double maxFuelLevel){
        this.FuelType = FuelType;
        this.currentFuelLevel = maxFuelLevel;
    }

    /** Resets the Fuel Level to its full capacity */

    public void refuel(){
        this.currentFuelLevel = this.maxFuelLevel;
    }

    /** Prints fuel level left is it above 0. Decreases the current fuel level. */
    public void go(){
        if (this.currentFuelLevel <= 0 ) {
            throw new RuntimeException("Your fuel is empty!");
            
        }
        this.currentFuelLevel --;
        System.out.println("You have" + currentFuelLevel + "fuel left");



    }


}