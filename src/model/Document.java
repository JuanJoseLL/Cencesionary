package model;
import java.time.LocalDate;
public abstract class Document{
    private double price;
    private LocalDate date;
    private int[][] image;
    private String code;
    public Document(double price, LocalDate date,int[][] image,String code) {
        this.price = price;
        this.setDate(date);
        this.image=image;
        this.code=code;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public int[][] getImage() {
        return image;
    }
    public void setImage(int[][] image) {
        this.image = image;
    }
    
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    
    
} 