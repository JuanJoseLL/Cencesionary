package model;
import java.util.*;
import java.time.LocalDate;
public class Company{
    /**
     * Class Company
     * Package Model
     */
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Vehicle> parkingVehicles;
    private Vehicle[][] parking;
    public Company(){
        vehicles=new ArrayList<Vehicle>();
        parkingVehicles=new ArrayList<Vehicle>();
        parking=new Vehicle[10][5];
    }
    
    /** 
     * @return ArrayList<Vehicle>
     */
    public ArrayList<Vehicle> getParikingVehicles() {
        return parkingVehicles;
    }
    
    /** 
     * @param parikingVehicles
     */
    public void setParikingVehicles(ArrayList<Vehicle> parikingVehicles) {
        this.parkingVehicles = parikingVehicles;
    }
    
    /** 
     * This method searchs a vehicle by its plate in the ArrayList of vehicles 
     * Name: searchVehicle
     * @param plate !=null
     * @return boolean True if the vehicle exists and false if it doesnt 
     */
    public boolean searchVehicle(String plate){
        boolean result=false;
        boolean flag=true;
        for (int i=0;i<vehicles.size() && flag==true;i++){
            Vehicle obj=vehicles.get(i);
            if(obj.getPlate().equals(plate)){
                result=true;
                flag=false;
            }
        }
        return result;
    }
    
    /** 
     * This method does a special travel in the matrix of soat and returns a number, then searchs the vehicle to add the soat to this vehicle 
     * Name addDocumentSoat
     * @param valueSoat Value of the soat !=null
     * @param dateSoat Expiration date of the soat !=null
     * @param plate The plate of the vehicle that the methos is going to find in the ArrayList !=null
     * @param amountCoverage The damage coverage of the soat
     * @param image The matrix !=null
     * @return String Confiramtion message 
     */
    public String addDocumentSoat(double valueSoat, LocalDate dateSoat,String plate, double amountCoverage,int[][] image){
        String message="";
        boolean flag=true;
        String num="";
        for (int i=0;i<image.length;i++){
            num+=image[i][0];
        }
        for (int j=1;j<image.length;j++){
            num+=image[image.length-1][j];
        }
        for (int i=0;i<vehicles.size() && flag==true;i++){
            Vehicle obj=vehicles.get(i);
            if(obj.getPlate().equals(plate)){
                message=obj.addDocumentSoat(valueSoat, dateSoat,amountCoverage,image,num);
                flag=false;
            }
        }
        
        return message;
    }
    
    /** 
     * This method does a special travel in the matrix of Technomechanic and returns a number, then searchs the vehicle to add the technomechanic to this vehicle 
     * Name addDocumentTechno
     * @param val Value of the technomechanic !=null
     * @param date  Expiration date of the technomechanic
     * @param plate The plate of the vehicle that the methos is going to find in the ArrayList !=null
     * @param gas The amount of gas that the car expelled 
     * @param image The matrix 
     * @return String confirmation message 
     */
    public String addDocumentTechno(double val,LocalDate date,String plate, double gas,int[][] image){
        String message="";
        boolean flag=true;
        String num="";
        for (int i=0;i<image.length;i++){
            num+=image[0][i];
        }
        for (int x=1;x<image.length;x++){
            for(int y=0;y<image.length;y++){
                if(y+x==image.length-1){
                 num+=image[x][y];
                }
            }
        }
        for (int a=1;a<image.length;a++){
            num+=image[image.length-1][a];
        }
        for (int i=0;i<vehicles.size() && flag==true;i++){
            Vehicle obj=vehicles.get(i);
            if(obj.getPlate().equals(plate)){
                message=obj.addDocumentTechno(val, date,gas,image,num);
                flag=false;
            }
        }
        return message;
    }
    
    /** 
     * This method does a special travel in the matrix of Property Card and returns a number, then searchs the vehicle to add the Property Card to this vehicle 
     * Name addDocumentProperty 
     * @param val Value of the property card 
     * @param date Expiration date of the property card 
     * @param plate The plate of the vehicle that the methos is going to find in the ArrayList !=null
     * @param image The matrix
     * @return String Confirmation message 
     */
    public String addDocumentProperty(double val,LocalDate date,String plate,int[][] image){
        String message="";
        boolean flag=true;
        String num="";
        for (int i=image.length-1;i>=0;i--){
            for (int j=image.length-1;j>=0;j--){
                if((i+j)%2==0){
                    num+=image[i][j];
                }
            }
        }

        for (int i=0;i<vehicles.size() && flag==true;i++){
            Vehicle obj=vehicles.get(i);
            if(obj.getPlate().equals(plate)){
                message=obj.addDocumentProperty(val, date,image,num);
                flag=false;
            }
        }
        return message;
    }
    
    /** This method adds to the ArrayList of vehicles an object Gasoline car. And if the car is used && its model<2015 its added to the ArrayList of parkingVehicles 
     * addGasolineCar
     * Name: addGasolineCar
     * @param used
     * @param basePrice
     * @param sellPrice
     * @param brand
     * @param model
     * @param cylinder
     * @param kilometers
     * @param plate
     * @param numDoors
     * @param polarized
     * @param typeCar
     * @param gasolineCapacity
     * @param gasolineConsume
     * @param typeGasoline
     * @param valueSoat
     * @param valueTechno
     * @param dateSoat
     * @param datetechno
     * @param damageCoverage
     * @param gas
     * @param valProperty
     * @param dateProperty
     * @param image
     * @return String Confirmation message 
     */
    public String addGasolineCar(boolean used, double basePrice, double sellPrice, String brand, int model, double cylinder, double kilometers, String plate, int numDoors, boolean polarized, int typeCar, double gasolineCapacity, double gasolineConsume, int typeGasoline,double valueSoat,double valueTechno,LocalDate dateSoat,LocalDate datetechno,double damageCoverage,double gas,double valProperty,LocalDate dateProperty,int[][] image){
        vehicles.add(new Gasoline(used,basePrice,sellPrice,brand,model,cylinder,kilometers,plate,numDoors,polarized,typeCar,gasolineCapacity,typeGasoline,typeGasoline));
        String message="Car registered succesfully";
        message+=" ; "+addDocumentSoat(valueSoat, dateSoat, plate, damageCoverage,image);
        message+=" ; "+addDocumentTechno(valueTechno, datetechno, plate, gas,image);
        message+=" ; "+addDocumentProperty(valProperty, dateProperty, plate,image);
        if(model<2015 && used==true){
            parkingVehicles.add(new Gasoline(used,basePrice,sellPrice,brand,model,cylinder,kilometers,plate,numDoors,polarized,typeCar,gasolineCapacity,typeGasoline,typeGasoline));
        }
           
        return message;
    }
    
    /** 
     * This method adds to the ArrayList of vehicles an object Electric car. And if the car is used && its model<2015 its added to the ArrayList of parkingVehicles 
     * Name: addElectricCar
     * @param used
     * @param basePrice
     * @param sellPrice
     * @param brand
     * @param model
     * @param cylinder
     * @param kilometers
     * @param plate
     * @param numDoors
     * @param polarized
     * @param typeCar
     * @param duration
     * @param consume
     * @param charger
     * @param valueSoat
     * @param valueTechno
     * @param dateSoat
     * @param datetechno
     * @param damageCoverage
     * @param gas
     * @param valProperty
     * @param dateProperty
     * @param image[][]
     * @return String
     */
    public String addElectricCar(boolean used, double basePrice, double sellPrice, String brand, int model, double cylinder, double kilometers, String plate, int numDoors, boolean polarized, int typeCar, double duration, double consume, int charger,double valueSoat,double valueTechno,LocalDate dateSoat,LocalDate datetechno,double damageCoverage,double gas,double valProperty,LocalDate dateProperty,int image[][]){
        vehicles.add(new Electric(used, basePrice, sellPrice, brand, model, cylinder, kilometers, plate, numDoors, polarized, typeCar, duration,consume, charger));
        String message="Car registered succesfully";
        message+=" ; "+addDocumentSoat(valueSoat, dateSoat, plate, damageCoverage,image);
        message+=" ; "+addDocumentTechno(valueTechno, datetechno, plate, gas,image);
        message+=" ; "+addDocumentProperty(valProperty, dateProperty, plate,image);
        if(model<2015 && used==true){
            parkingVehicles.add(new Electric(used, basePrice, sellPrice, brand, model, cylinder, kilometers, plate, numDoors, polarized, typeCar, duration,consume, charger));
        }
           
        return message;
    }
    
    /** 
     * This method adds to the ArrayList of vehicles an object Hybrid car. And if the car is used && its model<2015 its added to the ArrayList of parkingVehicles 
     * Name: addHybridCar
     * @param used
     * @param basePrice
     * @param sellPrice
     * @param brand
     * @param model
     * @param cylinder
     * @param kilometers
     * @param plate
     * @param numDoors
     * @param polarized
     * @param typeCar
     * @param duration
     * @param consume
     * @param charger
     * @param gasolineCapacity
     * @param gasolineConsume
     * @param typeGasoline
     * @param valueSoat
     * @param valueTechno
     * @param dateSoat
     * @param datetechno
     * @param damageCoverage
     * @param gas
     * @param valProperty
     * @param dateProperty
     * @param image
     * @return String Confirmation message
     */
    public String addHybridCar(boolean used, double basePrice, double sellPrice, String brand, int model, double cylinder, double kilometers, String plate, int numDoors, boolean polarized, int typeCar, double duration, double consume, int charger, double gasolineCapacity, double gasolineConsume, int typeGasoline,double valueSoat,double valueTechno,LocalDate dateSoat,LocalDate datetechno,double damageCoverage,double gas,double valProperty,LocalDate dateProperty,int[][] image){
        vehicles.add(new Hybrid(used, basePrice, sellPrice, brand, model, cylinder, kilometers, plate, numDoors, polarized, typeCar, duration, consume, charger, gasolineCapacity, gasolineConsume, typeGasoline));
        String message="Car registered succesfully";
        message+=" ; "+addDocumentSoat(valueSoat, dateSoat, plate, damageCoverage,image);
        message+=" ; "+addDocumentTechno(valueTechno, datetechno, plate, gas,image);
        message+=" ; "+addDocumentProperty(valProperty, dateProperty, plate,image);
        if(model<2015 && used==true){
            vehicles.add(new Hybrid(used, basePrice, sellPrice, brand, model, cylinder, kilometers, plate, numDoors, polarized, typeCar, duration, consume, charger, gasolineCapacity, gasolineConsume, typeGasoline));
        }
        return message;
    }
    
    /** 
     * This method adds to the ArrayList of vehicles an object Motorcycle car. And if the car is used && its model<2015 its added to the ArrayList of parkingVehicles 
     * Name: addMotorcycle
     * @param used
     * @param basePrice
     * @param sellPrice
     * @param brand
     * @param model
     * @param cylinder
     * @param kilometers
     * @param plate
     * @param polarized
     * @param gasolineCapacity
     * @param gasolineConsume
     * @param typeMoto
     * @param valueSoat
     * @param valueTechno
     * @param dateSoat
     * @param datetechno
     * @param damageCoverage
     * @param gas
     * @param valProperty
     * @param dateProperty
     * @param image
     * @return String Confirmation message
     */
    public String addMotorcycle(boolean used, double basePrice, double sellPrice, String brand, int model, double cylinder, double kilometers, String plate,boolean polarized, double gasolineCapacity, double gasolineConsume, int typeMoto,double valueSoat,double valueTechno,LocalDate dateSoat,LocalDate datetechno,double damageCoverage,double gas,double valProperty,LocalDate dateProperty,int[][] image){
        vehicles.add(new Motorcycle(used, basePrice, sellPrice, brand, model, cylinder, kilometers, plate, gasolineCapacity, gasolineConsume, typeMoto));
        String message="Motorcycle registered succesfully";
        message+=" ; "+addDocumentSoat(valueSoat, dateSoat, plate, damageCoverage,image);
        message+=" ; "+addDocumentTechno(valueTechno, datetechno, plate, gas,image);
        message+=" ; "+addDocumentProperty(valProperty, dateProperty, plate,image);
        if(model<2015 && used==true){
            vehicles.add(new Motorcycle(used, basePrice, sellPrice, brand, model, cylinder, kilometers, plate, gasolineCapacity, gasolineConsume, typeMoto));
        }
        return message;
    }
    
    /** 
     * This method calculates the sell price of a vehicle givent its plate 
     * Name; calculateSellPrice
     * @param plate The plate of the vehicle that the method is going to calculate its sell price
     * @param date The actual date 
     * @return String The sell price of the vehicle 
     */
    public String calculateSellPrice(String plate,LocalDate date){
        String message="";
        boolean cont=true;
        for (int i=0;i<vehicles.size() && cont==true;i++){
            Vehicle obj=vehicles.get(i);
            if(obj.getPlate().equals(plate)){
                if(vehicles.get(i) instanceof Motorcycle){
                    Motorcycle aux=(Motorcycle)vehicles.get(i);
                    aux.setSellPrice(aux.calculatePrice(aux.isUsed(), aux.getBasePrice(),date));
                    message="The sell price of the motorcycle with plate "+obj.getPlate()+" is: "+aux.getSellPrice();
                }else if(vehicles.get(i) instanceof Electric){
                    Electric aux=(Electric)vehicles.get(i);
                    aux.setSellPrice(aux.calculatePrice(aux.isUsed(), aux.getBasePrice(),date));
                    message="The sell price of the electric car with plate "+obj.getPlate()+" is: "+aux.getSellPrice();
                }else if(vehicles.get(i) instanceof Hybrid){
                    Hybrid aux=(Hybrid)vehicles.get(i);
                    aux.setSellPrice(aux.calculatePrice(aux.isUsed(), aux.getBasePrice(),date));
                    message="The sell price of the Hybrid car with plate "+obj.getPlate()+" is: "+aux.getSellPrice();
                }else if(vehicles.get(i) instanceof Gasoline){
                    Gasoline aux=(Gasoline)vehicles.get(i);
                    aux.setSellPrice(aux.calculatePrice(aux.isUsed(), aux.getBasePrice(),date));
                    message="The sell price of the Gasoline car with plate "+obj.getPlate()+" is: "+aux.getSellPrice();
                }
                cont=false;
            }
        }
        return message;
    }
    
    /** 
     * This method deploys the information of the vehicles according to some criteria
     * Name: deployInfo
     * @param principal The first criteria 
     * @param second The second criteria 
     * @return String The information of the vehicles that match the criteria 
     */
    public String deployInfo(int principal, int second){
        String message="";
        boolean cont=true;
        if(principal==1){
            if(second==1){
                for (int i=0;i<vehicles.size() && cont==true;i++){
                    if(vehicles.get(i).isUsed()==true){
                        message+=vehicles.toString();
                        cont=false;
                    }
                }
            }else if(second==2){
                for(int i=0;i<vehicles.size() && cont==true;i++){
                    if(vehicles.get(i).isUsed()==false){
                        message+=vehicles.toString();
                        cont=false;
                    }
                }
            }
            
        }
        if(principal==2){
            if(second==1){
                for(int i=0;i<vehicles.size() ;i++){
                    if(vehicles.get(i) instanceof Gasoline){
                        Gasoline obj=(Gasoline)vehicles.get(i);
                        if(obj.getType().equals(TypeGasoline.EXTRA)){
                            message+=obj.toString();
                        }
                    }else if(vehicles.get(i) instanceof Hybrid){
                        Hybrid obj=(Hybrid)vehicles.get(i);
                        if(obj.getTypeGasoline().equals(TypeGasoline.EXTRA)){
                            message+=obj.toString();
                        }
                    }
                    
                }
            }else if(second==2){
                for(int i=0;i<vehicles.size();i++){
                    if(vehicles.get(i) instanceof Gasoline){
                        Gasoline obj=(Gasoline)vehicles.get(i);
                        if(obj.getType().equals(TypeGasoline.CORRIENTE)){
                            message+=obj.toString();
                        }
                    }else if(vehicles.get(i) instanceof Hybrid){
                        Hybrid obj=(Hybrid)vehicles.get(i);
                        if(obj.getTypeGasoline().equals(TypeGasoline.CORRIENTE)){
                            message+=obj.toString();
                        }
                    }
                }
            }else if(second==3){
                for(int i=0;i<vehicles.size();i++){
                    if(vehicles.get(i) instanceof Gasoline){
                        Gasoline obj=(Gasoline)vehicles.get(i);
                        if(obj.getType().equals(TypeGasoline.CORRIENTE)){
                            message+=obj.toString();
                        }
                    }else if(vehicles.get(i) instanceof Hybrid){
                        Hybrid obj=(Hybrid)vehicles.get(i);
                        if(obj.getTypeGasoline().equals(TypeGasoline.CORRIENTE)){
                            message+=obj.toString();
                        }
                    }
                }
            }
        }
        if(principal==3){
            if(second==1){
                for(int i=0;i<vehicles.size();i++){
                    if(vehicles.get(i) instanceof Car){
                        Car obj=(Car)vehicles.get(i);
                        if(obj.getCar().equals(TypeCar.SEDAN)){
                            message+=obj.toString();
                        }
                    }
                }
            }else if(second==2){
                for(int i=0;i<vehicles.size();i++){
                    if(vehicles.get(i) instanceof Car ){
                        Car obj=(Car)vehicles.get(i);
                        if(obj.getCar().equals(TypeCar.PICKUP_TRUCK)){
                            message+=obj.toString();
                        }
                    }
                }
            }
        }
        if(message.length()<1)
            message="No vehicles found with that characteristics";
        return message;
    }
    
    /** This method shows the state of the docuements of certain vehicle 
     * Name: showDocuments
     * @param plate The plate of the vehicel that the method is going to search the state of the documents 
     * @return String The documents 
     */
    public String showDocuments(String plate){
        String message="";
        for (int i=0;i<vehicles.size();i++){
            Vehicle obj=vehicles.get(i);
            if(obj.getPlate().equals(plate)){
                message=obj.showDocuments();
            }
        }
        return message;
    }
    
    /** 
     * @return ArrayList<Vehicle>
     */
    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
    
    /** 
     * @param vehicles
     */
    public void setVehicles(ArrayList<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
    /** 
     * This method travels the ArrayList of parkingVehicles and gets the model of the vehicle in the position i, depending the model it gives a value to the column
     * Name: calcularColumna
     * @param model The model of the vehicle that you want to get the column
     * @return int The column according to the model
     */
    public int calcularColumna(int model){
        boolean flag=true;
        int colum=0;
        for (int i=0;i<parkingVehicles.size() && flag==true;i++){
            Vehicle obj=parkingVehicles.get(i);
            if(obj.getModel()<2015 && obj.isUsed()==true){    
                if(obj.getModel()==2014){
                    colum=0;

                }else if(obj.getModel()==2013){
                    colum=1;

                }else if(obj.getModel()==2012){
                    colum=2;

                }else if(obj.getModel()==2011){
                    colum=3;

                }else if(obj.getModel()<2011){
                    colum=4;
                }
            }
        }
        return colum;
    }
    
    /** 
     * This method adds the vehicles tho the matrix according to the model of the vehicle 
     * Name: mapMatrix
     * @return String The map of the matrix
     */
    public String mapMatrix(){
       for (int j=0;j<vehicles.size();j++){
           Vehicle obj=vehicles.get(j);
            for(int k=0;k<parking[0].length&&!parkingVehicles.contains(obj);k++){
                int columna=calcularColumna(obj.getModel());
                System.out.println(columna+"Col");
                if(parking[k][columna]==null ){
                    parkingVehicles.add(obj);
                    parking[k][columna]=obj;
                }
            }   
       }
        String message=showMatrix();
        return message;
    }
    
    /** 
     * 
     * This method shows the map of the parking 
     * Name: showMatrix
     * @return String The map showing the places that are occupied or empty
     */
    public String showMatrix(){
        String message="";
        for(int i=0; i<parking.length; i++){
            for(int j=0; j<parking[0].length; j++){
                    if(j+1<parking[0].length){
                        if(parking[i][j]!=null){
                            message+="|  Occupied |";
                        }else{ message+="|   Empty   |";}
                    }
                    else{
                        if(parking[i][j]!=null){
                            message+="|  Occupied |"+" \n";
                        }else{ message+="|   Empty   |"+" \n";}
                    }
            }
        }
        return message;
    }
    
    /** 
     * This method shows the inform of the parking depending of the criteria 
     * Name: generateInform
     * @param opt The criteria
     * @param y1 The first year
     * @param y2 The second year
     * @return String The inform 
     */
    public String generateInrform(int opt,int y1, int y2){
        String message="";
        double percentage=0;
        int cont=0;
        int parkingPlaces=50;
        int currentNum=0;
        int currentNew=0;
        int oldest=parkingVehicles.get(0).getModel();
        int newest=parkingVehicles.get(0).getModel();
        if(opt==1){
            for (int i=0;i<parkingVehicles.size();i++){
                Vehicle obj=parkingVehicles.get(i);
                if(obj.getModel()>=y1 && obj.getModel()<=y2){
                    message+=obj.toString();
                }
            } 
        }else if(opt==2){
            for (int i=0;i<parkingVehicles.size();i++){
                Vehicle obj=parkingVehicles.get(i);
                currentNum=obj.getModel();
                if(currentNum<=oldest){
                    oldest=currentNum;
                    message+="The oldest car is :\n"+obj.toString();
                }
                
            }
            for (int i=0;i<parkingVehicles.size();i++){ 
                Vehicle obj=parkingVehicles.get(i);
                currentNew=obj.getModel();
                if(currentNew>=newest){
                    newest=currentNew;
                    message+="\nThe newest car is :\n"+obj.toString();
                }
                
            }
            
        }else if(opt==3){
            
            for(int i=0;i<parkingVehicles.size();i++){
                cont++;
                percentage+=cont;
            }
            percentage/=parkingPlaces;
            percentage*=100;
            message="The percentage of occupation of the parking is : "+percentage+"%";
        }
                
        return message;
    }
    
    /** 
     * @return Vehicle[][]
     */
    public Vehicle[][] getParking() {
        return parking;
    }
    
    /** 
     * @param parking
     */
    public void setParking(Vehicle[][] parking) {
        this.parking = parking;
    }
}