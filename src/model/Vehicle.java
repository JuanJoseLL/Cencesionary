package model;
import java.util.ArrayList;
import java.time.LocalDate;
public abstract class Vehicle{
    private boolean used;
    private double basePrice;
    private double sellPrice;
    private String brand;
    private int model;
    private double cilinderCapacity;
    private double kilometers;
    private String plate;
    //relaciones
    private LocalDate date;
    private ArrayList<Document>documents;
    public Vehicle(boolean used, double basePrice, double sellPrice, String brand, int model,
            double cilinderCapacity, double kilometers, String plate) {
        this.used = used;
        this.basePrice = basePrice;
        this.sellPrice = sellPrice;
        this.brand = brand;
        this.model = model;
        this.cilinderCapacity=cilinderCapacity;
        this.kilometers = kilometers;
        this.plate = plate;
        date=LocalDate.now();
        documents=new ArrayList<Document>();
        
    }
    
    /** 
     * @return LocalDate
     */
    public LocalDate getDate() {
        return date;
    }
    
    /** 
     * @param date
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    /** 
     * This method adds the soat to the ArrayList of documents 
     * Name: addDocumentSoat
     * @param val 
     * @param date
     * @param amountCoverage
     * @param image
     * @param code
     * @return String Confirmation message
     */
    public String addDocumentSoat(double val,LocalDate date,double amountCoverage,int[][] image,String code){
        String message="";
        documents.add(new Soat(val, date,amountCoverage,image,code));
        message="Soat added correctly";
        return message;
    }
    
    /** 
     * This method adds The technomechanic to the ArrayList of documents
     * Name: addDocumentTechno
     * @param val
     * @param date
     * @param gas
     * @param image
     * @param num
     * @return String Confirmation message
     */
    public String addDocumentTechno(double val,LocalDate date, double gas,int[][] image,String num){
        String message="";
        documents.add(new TechnoMechanic(val, date,gas,image,num));
        message="Techno added correctly";
        return message;
    }
    /** 
     * This method adds the property card to the ArrayList of documents 
     * Name: addDocumentProperty
     * @param val
     * @param date
     * @param image
     * @param code
     * @return String confirmation message 
     */
    public String addDocumentProperty(double val,LocalDate date,int[][] image,String code){
        String message="";
        documents.add(new OwnerCard(val, date,image,code));
        message="Property card added correctly";
        return message;
    }
    
    /**
     * This method shows the docuements that the vehicle has, and its state 
     * Name: showDocuments 
     * @return String Shows the documents of the vehicles 
     */
    public String showDocuments(){
        String message="";
        LocalDate current=LocalDate.now();
        for (int i=0;i<documents.size();i++){
            if (documents.get(i) instanceof Soat){
                Soat obj=(Soat)documents.get(i);
                if (expire(current)==true){
                    message+="Soat :"+obj.getCode()+" Expired \n";
                }else{message+="Soat :"+obj.getCode()+" Vigent \n";}
            }
            if (documents.get(i) instanceof TechnoMechanic){
                TechnoMechanic obj=(TechnoMechanic)documents.get(i);
                if(expire(current)==true){
                    message+="Technomechanich :"+obj.getCode()+" Expired \n";

                }else{message+="Technomechanich :"+obj.getCode()+" Vigent \n";}
            }
            if (documents.get(i) instanceof OwnerCard){
                OwnerCard obj=(OwnerCard)documents.get(i);
                if(expire(current)==true){
                    message+="Owner card :"+obj.getCode()+" Expired \n";

                }else{message+="Owner card :"+obj.getCode()+" Vigent \n";}
            }
            
        }
        return message;
    }
    
    /** 
     * This method determines if one document is expired or vigent 
     * Name: expire
     * @param current
     * @return boolean
     */
    public boolean expire(LocalDate current){
        boolean expire=false;
        setDate(current);
        for (int i=0;i<documents.size();i++){
            Document obj=documents.get(i);
            if(obj.getDate().isAfter(current)){
                expire=false;
            }else{expire=true;}
            
        }
        return expire;
    }
    public abstract String toString();
    
    /** 
     * @return ArrayList<Document>
     */
    public ArrayList<Document> getDocuments() {
        return documents;
    }
    
    /** 
     * @param documents
     */
    public void setDocuments(ArrayList<Document> documents) {
        this.documents = documents;
    }
    
    /** 
     * @return double
     */
    public double getCilinderCapacity() {
        return cilinderCapacity;
    }
    
    /** 
     * @param cilinderCapacity
     */
    public void setCilinderCapacity(double cilinderCapacity) {
        this.cilinderCapacity = cilinderCapacity;
    }
    
    /** 
     * @return boolean
     */
    public boolean isUsed() {
        return used;
    }
    
    /** 
     * @return String
     */
    public String getPlate() {
        return plate;
    }
    
    /** 
     * @param plate
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }
    
    /** 
     * @return double
     */
    public double getKilometers() {
        return kilometers;
    }
    
    /** 
     * @param kilometers
     */
    public void setKilometers(double kilometers) {
        this.kilometers = kilometers;
    }
    
    
    /** 
     * @return int
     */
    public int getModel() {
        return model;
    }
    
    /** 
     * @param model
     */
    public void setModel(int model) {
        this.model = model;
    }
    
    /** 
     * @return String
     */
    public String getBrand() {
        return brand;
    }
    
    /** 
     * @param brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    
    /** 
     * @return double
     */
    public double getSellPrice() {
        return sellPrice;
    }
    
    /** 
     * @param sellPrice
     */
    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }
    
    /** 
     * @return double
     */
    public double getBasePrice() {
        return basePrice;
    }
    
    /** 
     * @param basePrice
     */
    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    
    /** 
     * @param used
     */
    public void setUsed(boolean used) {
        this.used = used;
    }
}