package model;
import java.time.LocalDate;
public interface Sellable{
    public double calculatePrice(boolean used,double basePrice,LocalDate current);
}