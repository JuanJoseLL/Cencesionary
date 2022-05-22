package model;
import java.time.LocalDate;
public class Soat extends Document{
    private double damageCoverage;
    
    public Soat(double price, LocalDate date,double damageCoverage,int[][] image,String code) {
        super(price,date,image,code);
        this.damageCoverage=damageCoverage;
    }
    public double getDamageCoverage() {
        return damageCoverage;
    }
    public void setDamageCoverage(double damageCoverage) {
        this.damageCoverage = damageCoverage;
    }
   
    
}