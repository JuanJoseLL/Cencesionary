package model;

import java.time.LocalDate;
public class Electric extends Car implements Sellable{
    private double batteryDuration;
    private double batteryConsume;
    private TypeCharger type;
    public Electric(boolean used, double basePrice, double sellPrice, String brand, int model,double cilinderCapacity, double kilometers, String plate, int numDoors, boolean polarized, int car,double batteryDuration, double batteryConsume, int type) {
        super(used, basePrice, sellPrice, brand, model, cilinderCapacity, kilometers, plate, numDoors, polarized, car);
        this.batteryDuration = batteryDuration;
        this.batteryConsume = batteryConsume;
        switch(type){
            case 1:this.type=TypeCharger.FAST;
                break;
            case 2: this.type=TypeCharger.NORMAL;
                break;
        }
    }
    
    public TypeCharger getType() {
        return type;
    }
    public void setType(TypeCharger type) {
        this.type = type;
    }
    public double getBatteryDuration() {
        return batteryDuration;
    }
    
    public double getBatteryConsume() {
        return batteryConsume;
    }
    public void setBatteryConsume(double batteryConsume) {
        this.batteryConsume = batteryConsume;
    }
    public void setBatteryDuration(double batteryDuration) {
        this.batteryDuration = batteryDuration;
    }
    
    
    /** 
     * @return String
     */
    public String toString() {
        return "\n-*-*-*-*-*-*-*-*-*-\n Electric Car \n Used: "+isUsed()+"\n Base price: "+getBasePrice()+"\n Sell price: "+calculatePrice(isUsed(), getBasePrice(),getDate())+"\n Brand: "+getBrand()+"\n Model: "+getModel()+"\n Cilinder capacity: "+getCilinderCapacity()+"\n Kilometers: "+getKilometers()+"\n Plate: "+getPlate()+"\n Num doors: "+getNumDoors()+"\n Polarized: "+isPolarized()+"\n Car: "+getCar()+"\n Electric batteryConsume: " + batteryConsume + "\n Battery duration: " + batteryDuration + "\n Type charger: " + type;
                
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
        result*=0.2;
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