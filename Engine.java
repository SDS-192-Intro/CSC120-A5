public class Engine {
    private String FuelType;
    private Double currentFuelLevel;
    Double maxFuelLevel;

    /** Accessor */
    public String getFuelType(){
        return this.FuelType;
    }

    /** Constructor */
    public Engine(String FuelType, Double currentFuelLevel, Double maxFuelLevel){
        this.FuelType = FuelType;
        this.currentFuelLevel = currentFuelLevel;
        this.maxFuelLevel = maxFuelLevel;
    }

    /** Resets the Fuel Level to its full capacity */

    public void refuel(double currentFuelLevel, double maxFuelLevel){
        currentFuelLevel = maxFuelLevel;
    }

    /** Prints fuel level left is it above 0. Decreases the current fuel level. */
    public void go(double currentFuelLevel, double x){
        if (this.currentFuelLevel <= 0 ) {
            throw new RuntimeException("Your fuel is empty!");
            
        }
        this.currentFuelLevel -=x;
        System.out.println("You have" + currentFuelLevel + "fuel left");



    }


}