package model;
import java.time.LocalDate;
public class OwnerCard extends Document{
    public OwnerCard(double price, LocalDate date,int[][] image,String code) {
        super(price, date,image,code);
        
    }
    
}