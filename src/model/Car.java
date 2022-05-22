package model;

public abstract class Car extends Vehicle{
    
    private int numDoors;
    private boolean polarized;
    
    //relaciones
    private TypeCar car;
    
    public Car(boolean used, double basePrice, double sellPrice, String brand, int model, double cilinderCapacity,double kilometers, String plate,int numDoors,boolean polarized,int car){
        super(used, basePrice, sellPrice, brand, model, cilinderCapacity, kilometers, plate);
        this.numDoors=numDoors;
        this.polarized=polarized;
        switch(car){
            case 1: this.car=TypeCar.SEDAN;
                break;
            case 2: this.car=TypeCar.PICKUP_TRUCK;
        }
        
        
    }
    public abstract String toString();
    public TypeCar getCar() {
        return car;
    }

    public void setCar(TypeCar car) {
        this.car = car;
    }

    public boolean isPolarized() {
        return polarized;
    }
    public void setPolarized(boolean polarized) {
        this.polarized = polarized;
    }
    public int getNumDoors() {
        return numDoors;
    }
    public void setNumDoors(int numDoors) {
        this.numDoors = numDoors;
    }
}