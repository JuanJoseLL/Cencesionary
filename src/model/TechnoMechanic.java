package model;
import java.time.LocalDate;
public class TechnoMechanic extends Document{
    private double levelsGas;
    public TechnoMechanic(double price, LocalDate date, double gas,int[][] image,String num) {
        super(price, date,image,num);
        levelsGas=gas;
    }
    public double getLevelsGas() {
        return levelsGas;
    }
    public void setLevelsGas(double levelsGas) {
        this.levelsGas = levelsGas;
    }
    
}