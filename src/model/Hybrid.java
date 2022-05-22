package model;
import java.time.LocalDate;

public class Hybrid extends Car implements Sellable{
    private double batteryDuration;
    private double batteryConsume;
    private TypeCharger typeCharger;
    private double gasolineCapacity;
    private double gasolineConsume;
    private TypeGasoline typeGasoline;
    
    public Hybrid(boolean used, double basePrice, double sellPrice, String brand, int model, double cilinderCapacity,double kilometers, String plate, int numDoors, boolean polarized, int car, double batteryDuration,double batteryConsume, int typeCharger, double gasolineCapacity, double gasolineConsume, int typeGasoline) {
        super(used, basePrice, sellPrice, brand, model, cilinderCapacity, kilometers, plate, numDoors, polarized, car);
        this.batteryDuration = batteryDuration;
        this.batteryConsume = batteryConsume;
        this.gasolineCapacity = gasolineCapacity;
        this.gasolineConsume = gasolineConsume;
        switch(typeGasoline){
            case 1: this.typeGasoline=TypeGasoline.EXTRA;
                break;
            case 2: this.typeGasoline=TypeGasoline.CORRIENTE;
                break;
            case 3: this.typeGasoline=TypeGasoline.DIESEL;
            
        }
        switch(typeCharger){
            case 1: this.typeCharger=TypeCharger.FAST;
                break;
            case 2: this.typeCharger=TypeCharger.NORMAL;
                break;
        }

    }
    
    public double getBatteryDuration() {
        return batteryDuration;
    }
    public void setBatteryDuration(double batteryDuration) {
        this.batteryDuration = batteryDuration;
    }
    public double getBatteryConsume() {
        return batteryConsume;
    }
    public void setBatteryConsume(double batteryConsume) {
        this.batteryConsume = batteryConsume;
    }
    
    public double getGasolineCapacity() {
        return gasolineCapacity;
    }
    public void setGasolineCapacity(double gasolineCapacity) {
        this.gasolineCapacity = gasolineCapacity;
    }
    public double getGasolineConsume() {
        return gasolineConsume;
    }
    public void setGasolineConsume(double gasolineConsume) {
        this.gasolineConsume = gasolineConsume;
    }
   public TypeGasoline getTypeGasoline(){
       return typeGasoline;
   }
   public TypeCharger getTypeCharger(){
       return typeCharger;
   }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "\n-*-*-*-*-*-*-*-*-*-\n Hybrid Car \n Used: "+isUsed()+"\n Base price: "+getBasePrice()+"\n Sell price: "+calculatePrice(isUsed(), getBasePrice(),getDate())+"\n Brand: "+getBrand()+"\n Model: "+getModel()+"\n Cilinder capacity: "+getCilinderCapacity()+"\n Kilometers: "+getKilometers()+"\n Plate: "+getPlate()+"\n Num doors: "+getNumDoors()+"\n Polarized: "+isPolarized()+"\n Car: "+getCar()+"\n Electric batteryConsume: " + getBatteryConsume() + "\n Battery duration: " + getBatteryDuration() + "\n Type charger: " + getTypeCharger()+"\n Gasoline capacity: "+gasolineCapacity+"\n Gasoline consume: "+gasolineConsume+"\n Type gasoline: "+typeGasoline;

    }
    
    /** 
     * This method calculates the sell price of the vehicle 
     * Name: calculatePrice
     * @param used
     * @param basePrice
     * @param current
     * @return double
     */
    public double calculatePrice(boolean used, double basePrice,LocalDate current) {
        boolean expire=super.expire(current);
        double result=basePrice;
        result*=0.15;
        basePrice+=result;
        double aux=basePrice;
        aux*=0.1;
        if(used==true){
            basePrice-=aux;
        }
        if(expire==true){
            basePrice+=500000;
        }
        return basePrice;
    }
}