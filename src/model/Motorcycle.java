package model;
import java.time.LocalDate;
public class Motorcycle extends Vehicle implements Sellable{
    private TypeMotorcycle type;
    private double gasolineCapacity;
    private double gasolineConsume;
    public Motorcycle(boolean used, double basePrice, double sellPrice, String brand, int model,double cilinderCapacity, double kilometers, String plate, double gasolineCapacity,double gasolineConsume,int type) {
        super(used, basePrice, sellPrice, brand, model, cilinderCapacity, kilometers, plate);
        this.gasolineCapacity = gasolineCapacity;
        this.gasolineConsume = gasolineConsume;
        switch(type){
            case 1: this.type=TypeMotorcycle.STANDAR;
                break;
            case 2: this.type=TypeMotorcycle.SPORT;
                break;
            case 3:this.type=TypeMotorcycle.SCOOTER;
                break;
            case 4: this.type=TypeMotorcycle.CROSS;
                break;
        }
    }
  
    public TypeMotorcycle getType() {
        return type;
    }

    public void setType(TypeMotorcycle type) {
        this.type = type;
    }

    public double getGasolineConsume() {
        return gasolineConsume;
    }
    public void setGasolineConsume(double gasolineConsume) {
        this.gasolineConsume = gasolineConsume;
    }
    public double getGasolineCapacity() {
        return gasolineCapacity;
    }
    public void setGasolineCapacity(double gasolineCapacity) {
        this.gasolineCapacity = gasolineCapacity;
    }
    
    /** 
     * @return String
     */
    public String toString() {
        return "\n-*-*-*-*-*-*-*-*-*-\n Motorcycle \n Plate: "+getPlate()+"\n Gasoline capacity: " + gasolineCapacity + "\n Gasoline consume: " + gasolineConsume + "\n Type: "+ type+"\n Used: "+isUsed()+"\n Base price: "+getBasePrice()+"\n Sell price: "+calculatePrice(isUsed(), getBasePrice(),getDate())+"\n Brand: "+getBrand()+"\n Model: "+getModel()+"\n Cilinder capacity: "+getCilinderCapacity()+"\n Kilometers: "+getKilometers();
                
    }
    
    /** 
     * This method calculates the the sell price of the vehicle 
     * Name: calculatePrice
     * @param used
     * @param basePrice
     * @param current
     * @return double
     */
    public double calculatePrice(boolean used, double basePrice,LocalDate current) {
        boolean expire=super.expire(current);
        double result=basePrice;
        result*=0.04;
        basePrice+=result;
        double aux=basePrice;
        aux*=0.02;
        if(used==true){
            basePrice-=aux;
        }
        if(expire==true){
            basePrice+=500000;
        }
        return basePrice;
        
    }
   
}