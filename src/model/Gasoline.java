package model;
import java.time.LocalDate;
public class Gasoline extends Car implements Sellable{
    private double gasolineCapacity;
    private double gasolineConsume;
    private TypeGasoline type;
    public Gasoline(boolean used, double basePrice, double sellPrice, String brand, int model,double cilinderCapacity, double kilometers, String plate, int numDoors, boolean polarized, int car, double gasolineCapacity, double gasolineConsume, int type) {
        super(used, basePrice, sellPrice, brand, model, cilinderCapacity, kilometers, plate, numDoors, polarized, car);
        this.gasolineCapacity = gasolineCapacity;
        this.gasolineConsume = gasolineConsume;
        switch(type){
            case 1: this.setType(TypeGasoline.EXTRA);
                break;
            case 2: this.setType(TypeGasoline.CORRIENTE);
                break;
            case 3: this.setType(TypeGasoline.DIESEL);
            
        }
    }
    public TypeGasoline getType() {
        return type;
    }
    public void setType(TypeGasoline type) {
        this.type = type;
    }
    public double getGasolineCapacity() {
        return gasolineCapacity;
    }
    
    public double getGasolineConsume() {
        return gasolineConsume;
    }
    public void setGasolineConsume(double gasolineConsume) {
        this.gasolineConsume = gasolineConsume;
    }
    public void setGasolineCapacity(double gasolineCapacity) {
        this.gasolineCapacity = gasolineCapacity;
    }
    /** 
     * @return String
     */
    public String toString() {
        return "\n-*-*-*-*-*-*-*-*-*-\n Gasoline Car \n Plate: "+getPlate()+"\nGasoline capacity: " + gasolineCapacity + "\n Gasoline consume: " + gasolineConsume + "\n Type: "+ type+"\n Used: "+isUsed()+"\n Base price: "+getBasePrice()+"\n Sell price: "+calculatePrice(isUsed(), getBasePrice(),getDate())+"\n Brand: "+getBrand()+"\n Model: "+getModel()+"\n Cilinder capacity: "+getCilinderCapacity()+"\n Kilometers: "+getKilometers()+"\n Num doors: "+getNumDoors()+"\n Polarized: "+isPolarized()+"\n Type car: "+getCar();
                
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
        result*=0.1;
        if(used==true){
            basePrice-=result;
        }
        if(expire==true){
            basePrice+=500000;
        }
        return basePrice;
    }
}