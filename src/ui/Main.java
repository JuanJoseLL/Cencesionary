package ui;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import model.Company;
public class Main{
    /**
     * class Main
     * package ui
     * @author Juan José López
     * @date 20/05/2022
     */
    public static Scanner lt=new Scanner(System.in);
    public static Company objCompany=new Company();    
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        boolean contineu=true;
        int opt=0;
        while(contineu==true){
            System.out.println("1. Register gasoline car \n2. Register electric car \n3. Register hybrid car \n4. Register motorcycle \n5. Calculate sell price \n6. Deploy info \n7. Status of vehicle documents \n8. Generate map  \n9. Occupation inform of the parking \n0. Exit" );
            opt=lt.nextInt();
            lt.nextLine();
            switch(opt){
                case 1: String a=registerCar();
                    System.out.println(a);
                    break;
                case 2: String b=registerElectric();
                    System.out.println(b);
                    break;
                case 3: String h=registerHybrid();
                    System.out.println(h);
                    break;
                case 4: String r=registerMotorcycle();
                    System.out.println(r);
                    break;
                case 5: String l=calculateSellPrice();
                    System.out.println(l);
                    break;
                case 6: String k=deployInfo();
                    System.out.println(k);
                    break;
                case 7: String j=statusDocuments();
                    System.out.println(j);
                    break;
                case 8: String p=mapMatrix();
                    System.out.println(p);
                    break;
                case 9: String x=generateInform();
                    System.out.println(x);
                    break;
                case 0: contineu=false;
            }
        }
    }
    
    /** This method collects the data needed to register a gasoline car
     * Name: registerCar
     * postCondition: The gasoline car is created sucesfully.
     * @return String The message that says if the procces was completed or if wasn`t
     */
    public static String registerCar(){
        String message="";
        boolean used=false;
        boolean polarized=true;
        int[][] image=new int[4][4];
        Random rand=new Random();
        int maxNum=99;
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                image[i][j]=rand.nextInt(maxNum);
            }
        }
        System.out.println("Does the car is used? 1. yes 2. no");
        int opt=lt.nextInt();
        lt.nextLine();
        if(opt==1)
            used=true;
        System.out.println("Type the base price ");
        double basePrice=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the brand of the car");
        String brand=lt.nextLine();
        System.out.println("Type the model of the car");
        int model=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the cylinder capacity");
        double cylinder=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the kilometers of the car");
        double kilometers=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the plate of the car");
        String plate=lt.nextLine();
        System.out.println("Type num of doors ");
        int numDoors=lt.nextInt();
        lt.nextLine();
        System.out.println("Is the car polarized? 1. yes 2. no");
        int opt2=lt.nextInt();
        lt.nextLine();
        if(opt2==2)
            polarized=false;
        System.out.println("Type if the car is 1. Sedan 2.Pickup truck ");
        int typeCar=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the gasoline capacity");
        double gasolineCapacity=lt.nextDouble();
        lt.nextLine();
        double gasolineConsume=gasolineCapacity*(cylinder/150);
        System.out.println("Type if the gasoline is 1. Extra 2. Corriente 3. Diesel");
        int typeGasoline=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the value of the soat");
        double valueSoat=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the damage coverage of the soat");
        double damageCoverage=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the expiration day ");
        int daySoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration month");
        int monthSoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration year");
        int yearSoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the value of the technomechanic");
        double valueTechno=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the levels of gas that the car threw");
        double gas=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the expiration day");
        int dayThech=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration month");
        int monthThech=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration year");
        int yearTech=lt.nextInt();
        lt.nextLine();
        LocalDate dateSoat=LocalDate.of(yearSoat,monthSoat,daySoat);
        LocalDate dateTechno=LocalDate.of(yearTech,monthThech,dayThech);
        if(used==true){
            System.out.println("Type the value of the property card");
            double valProperty=lt.nextDouble();
            lt.nextLine();
            System.out.println("Type the expiration day");
            int dayProperty=lt.nextInt();
            lt.nextLine();
            System.out.println("Type the expiration month");
            int monthProperty=lt.nextInt();
            lt.nextLine();
            System.out.println("Type the expiration year");
            int yearProperty=lt.nextInt();
            lt.nextLine();
            LocalDate dateProperty=LocalDate.of(yearProperty,monthProperty,dayProperty);
            message=objCompany.addGasolineCar(used,basePrice,0,brand,model,cylinder,kilometers,plate,numDoors,polarized,typeCar,gasolineCapacity,gasolineConsume,typeGasoline,valueSoat,valueTechno,dateSoat,dateTechno,damageCoverage,gas,valProperty,dateProperty,image);
        }else{message=objCompany.addGasolineCar(used,basePrice,0,brand,model,cylinder,kilometers,plate,numDoors,polarized,typeCar,gasolineCapacity,gasolineConsume,typeGasoline,valueSoat,valueTechno,dateSoat,dateTechno,damageCoverage,gas,0,null,image);}
        
        return message;
    }
    
    /** This method collects the data needed to register an electric car
     * Name: registerElectric
     * postCondition: The electric car is created sucesfully.
     * @return String The message that says if the procces was completed or if wasn`t
     */
    public static String registerElectric(){
        String message="";
        boolean used=false;
        boolean polarized=true;
        int[][] image=new int[4][4];
        Random rand=new Random();
        int maxNum=99;
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                image[i][j]=rand.nextInt(maxNum);
            }
        }
        System.out.println("Does the car is used? 1. yes 2. no");
        int opt=lt.nextInt();
        lt.nextLine();
        if(opt==1)
            used=true;
        System.out.println("Type the base price ");
        double basePrice=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the brand of the car");
        String brand=lt.nextLine();
        System.out.println("Type the model of the car");
        int model=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the cylinder capacity");
        double cylinder=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the kilometers of the car");
        double kilometers=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the plate of the car");
        String plate=lt.nextLine();
        System.out.println("Type num of doors ");
        int numDoors=lt.nextInt();
        lt.nextLine();
        System.out.println("Is the car polarized? 1. yes 2. no");
        int opt2=lt.nextInt();
        lt.nextLine();
        if(opt2==2)
            polarized=false;
        System.out.println("Type if the car is 1. Sedan 2.Pickup truck ");
        int typeCar=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the battery duration of the car");
        double duration=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type if the charger is 1. fast 2. normal");
        int charger=lt.nextInt();
        lt.nextLine();
        double consume=0;
        if (charger==1){
            consume=(duration+13)*(cylinder/100);}
        else{consume=(duration+18)+(cylinder/100);}
        System.out.println("Type the value of the soat");
        double valueSoat=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the damage coverage of the soat");
        double damageCoverage=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the expiration day ");
        int daySoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration month");
        int monthSoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration year");
        int yearSoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the value of the technomechanic");
        double valueTechno=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the levels of gas that the car threw");
        double gas=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the expiration day");
        int dayThech=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration month");
        int monthThech=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration year");
        int yearTech=lt.nextInt();
        lt.nextLine();
        LocalDate dateSoat=LocalDate.of(yearSoat,monthSoat,daySoat);
        LocalDate dateTechno=LocalDate.of(yearTech,monthThech,dayThech);
        if(used==true){
            System.out.println("Type the value of the property card");
            double valProperty=lt.nextDouble();
            lt.nextLine();
            System.out.println("Type the expiration day");
            int dayProperty=lt.nextInt();
            lt.nextLine();
            System.out.println("Type the expiration month");
            int monthProperty=lt.nextInt();
            lt.nextLine();
            System.out.println("Type the expiration year");
            int yearProperty=lt.nextInt();
            lt.nextLine();
            LocalDate dateProperty=LocalDate.of(yearProperty,monthProperty,dayProperty);
            message=objCompany.addElectricCar(used,basePrice,0,brand,model,cylinder,kilometers,plate,numDoors,polarized,typeCar,duration,consume,charger,valueSoat,valueTechno,dateSoat,dateTechno,damageCoverage,gas,valProperty,dateProperty,image);
        }else{message=objCompany.addElectricCar(used,basePrice,0,brand,model,cylinder,kilometers,plate,numDoors,polarized,typeCar,duration,consume,charger,valueSoat,valueTechno,dateSoat,dateTechno,damageCoverage,gas,0,null,image);}
        
        return message;
    }
    
    /** 
     * This method collects the data needed to register an hybrid car
     * Name: registerHybrid
     * postCondition: The hybrid car is created sucesfully.
     * @return String The message that says if the procces was completed or if wasn`t
     */
    public static String registerHybrid(){
        String message="";
        boolean used=false;
        boolean polarized=true;
        int[][] image=new int[4][4];
        Random rand=new Random();
        int maxNum=99;
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                image[i][j]=rand.nextInt(maxNum);
            }
        }
        System.out.println("Does the car is used? 1. yes 2. no");
        int opt=lt.nextInt();
        lt.nextLine();
        if(opt==1)
            used=true;
        System.out.println("Type the base price ");
        double basePrice=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the brand of the car");
        String brand=lt.nextLine();
        System.out.println("Type the model of the car");
        int model=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the cylinder capacity");
        double cylinder=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the kilometers of the car");
        double kilometers=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the plate of the car");
        String plate=lt.nextLine();
        System.out.println("Type num of doors ");
        int numDoors=lt.nextInt();
        lt.nextLine();
        System.out.println("Is the car polarized? 1. yes 2. no");
        int opt2=lt.nextInt();
        lt.nextLine();
        if(opt2==2)
            polarized=false;
        System.out.println("Type if the car is 1. Sedan 2.Pickup truck ");
        int typeCar=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the battery duration of the car");
        double duration=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type if the charger is 1. fast 2. normal");
        int charger=lt.nextInt();
        lt.nextLine();
        double consume=0;
        if (charger==1){
            consume=duration*(cylinder/200);
        }else{consume=(duration+7)*(cylinder/200);}
        System.out.println("Type the gasoline capacity");
        double gasolineCapacity=lt.nextDouble();
        lt.nextLine();
        double gasolineConsume=gasolineCapacity*(cylinder/180);
        System.out.println("Type if the gasoline is 1. Extra 2. Corriente 3. Diesel");
        int typeGasoline=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the value of the soat");
        double valueSoat=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the damage coverage of the soat");
        double damageCoverage=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the expiration day ");
        int daySoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration month");
        int monthSoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration year");
        int yearSoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the value of the technomechanic");
        double valueTechno=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the levels of gas that the car threw");
        double gas=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the expiration day");
        int dayThech=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration month");
        int monthThech=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration year");
        int yearTech=lt.nextInt();
        lt.nextLine();
        LocalDate dateSoat=LocalDate.of(yearSoat,monthSoat,daySoat);
        LocalDate dateTechno=LocalDate.of(yearTech,monthThech,dayThech);
        if(used==true){
            System.out.println("Type the value of the property card");
            double valProperty=lt.nextDouble();
            lt.nextLine();
            System.out.println("Type the expiration day");
            int dayProperty=lt.nextInt();
            lt.nextLine();
            System.out.println("Type the expiration month");
            int monthProperty=lt.nextInt();
            lt.nextLine();
            System.out.println("Type the expiration year");
            int yearProperty=lt.nextInt();
            lt.nextLine();
            LocalDate dateProperty=LocalDate.of(yearProperty,monthProperty,dayProperty);
            message=objCompany.addHybridCar(used,basePrice,0,brand,model,cylinder,kilometers,plate,numDoors,polarized,typeCar,duration,consume,charger,gasolineCapacity,gasolineConsume,typeGasoline,valueSoat,valueTechno,dateSoat,dateTechno,damageCoverage,gas,valProperty,dateProperty,image);
        }else{message=objCompany.addHybridCar(used,basePrice,0,brand,model,cylinder,kilometers,plate,numDoors,polarized,typeCar,duration,consume,charger,gasolineCapacity,gasolineConsume,typeGasoline,valueSoat,valueTechno,dateSoat,dateTechno,damageCoverage,gas,0,null,image);}
        
        return message;
    }
    
    /** This method collects the data needed to register a motorcycle
     * Name: regiserMotorcycle
     * postCondition: The motorcycle is created sucesfully
     * @return String The message that says if the procces was completed or if wasn`t
     */
    public static String registerMotorcycle(){
        String message="";
        boolean used=false;
        boolean polarized=false;
        int[][] image=new int[4][4];
        Random rand=new Random();
        int maxNum=99;
        for(int i=0;i<image.length;i++){
            for(int j=0;j<image[0].length;j++){
                image[i][j]=rand.nextInt(maxNum);
            }
        }
        System.out.println("Does the motorcycle is used? 1. yes 2. no");
        int opt=lt.nextInt();
        lt.nextLine();
        if(opt==1)
            used=true;
        System.out.println("Type the base price ");
        double basePrice=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the brand of the motorcycle");
        String brand=lt.nextLine();
        System.out.println("Type the model of the motorcycle");
        int model=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the cylinder capacity");
        double cylinder=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the kilometers of the motorcycle");
        double kilometers=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the plate of the motorcycle");
        String plate=lt.nextLine();
        System.out.println("Type the gasoline capacity");
        double gasolineCapacity=lt.nextDouble();
        lt.nextLine();
        double gasolineConsume=gasolineCapacity*(cylinder/75);
        System.out.println("Type if the motorcycle is 1. Standar 2. Sport 3. Scooter 4. Cross");
        int typeMoto=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the value of the soat");
        double valueSoat=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the damage coverage of the soat");
        double damageCoverage=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the expiration day ");
        int daySoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration month");
        int monthSoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration year");
        int yearSoat=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the value of the technomechanic");
        double valueTechno=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the levels of gas that the car threw");
        double gas=lt.nextDouble();
        lt.nextLine();
        System.out.println("Type the expiration day");
        int dayThech=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration month");
        int monthThech=lt.nextInt();
        lt.nextLine();
        System.out.println("Type the expiration year");
        int yearTech=lt.nextInt();
        lt.nextLine();
        LocalDate dateSoat=LocalDate.of(yearSoat,monthSoat,daySoat);
        LocalDate dateTechno=LocalDate.of(yearTech,monthThech,dayThech);
        if(used==true){
            System.out.println("Type the value of the property card");
            double valProperty=lt.nextDouble();
            lt.nextLine();
            System.out.println("Type the expiration day");
            int dayProperty=lt.nextInt();
            lt.nextLine();
            System.out.println("Type the expiration month");
            int monthProperty=lt.nextInt();
            lt.nextLine();
            System.out.println("Type the expiration year");
            int yearProperty=lt.nextInt();
            lt.nextLine();
            LocalDate dateProperty=LocalDate.of(yearProperty,monthProperty,dayProperty);
            message=objCompany.addMotorcycle(used,basePrice,0,brand,model,cylinder,kilometers,plate,polarized,gasolineCapacity,gasolineConsume,typeMoto,valueSoat,valueTechno,dateSoat,dateTechno,damageCoverage,gas,valProperty,dateProperty,image);
        }else{message=objCompany.addMotorcycle(used,basePrice,0,brand,model,cylinder,kilometers,plate,polarized,gasolineCapacity,gasolineConsume,typeMoto,valueSoat,valueTechno,dateSoat,dateTechno,damageCoverage,gas,0,null,image);}
        
        return message;
    }
    
    /** This method collects the plate of the vehicle to calculate it's sell price
     * Name: calculateSellPrice 
     * @return String The sell price of the vehicle with the introduced plate.
     */
    public static String calculateSellPrice(){
        String message="";
        System.out.println("Type the plate of the vehicle to calculate it`s sell price");
        String vehicle=lt.nextLine();
        LocalDate currentDate=LocalDate.now();
        message=objCompany.calculateSellPrice(vehicle,currentDate);
        return message;
    }
    
    /** This method collects the parameters on how to generate the information of the vehicles
     * Name: deployInfo
     * @return String The information of the vehicles according to the parameters introduced 
     */
    public static String deployInfo(){
        String message="";
        int option2=0;
        System.out.println("Type how you want to generate the info 1. Used/New vehicles  2. Type gas  3. Type vehicle");
        int option=lt.nextInt();
        lt.nextLine();
        switch(option){
            case 1: System.out.println("Generate for 1. Used 2. New");
                option2=lt.nextInt();
                lt.nextLine();
                break;
            case 2: System.out.println("Generate for 1. Extra 2. Corriente 3. Diesel");
                option2=lt.nextInt();
                lt.nextLine();
                break;
            case 3: System.out.println("Generate for 1. Sedan 2. Pickup truck");
                option2=lt.nextInt();
                lt.nextLine();
                break;
        }
        message=objCompany.deployInfo(option, option2);
        return message;
    }
    
    /** This method collects the plate of a vehicle requiered to know the status of it's documents
     * Name: statusDocuments
     * @return String Shows the status of the documents
     */
    public static String statusDocuments(){
        String message="";
        System.out.println("Type the plate of the vehicle to view its documents");
        String plate=lt.nextLine();
        message=objCompany.showDocuments(plate);
        return message;
    }
    
    /** This method calls a method in the class Company
     * Name: mapMatrix
     * @return String Shows the map of the parking 
     */
    public static String mapMatrix(){
        String message=objCompany.mapMatrix();
        return message;
    }
    
    /** This method collects the parameters on how to generate the information of the vehicles that are in the parking 
     * Name: generateInform
     * @return String
     */
    public static String generateInform(){
        String message=objCompany.showMatrix();
        int year1=0;
        int year2=0;
        System.out.println("Type how you want to generate the info 1. List of information given a range of years  2. Newest vehicle and oldest vehicle  3. Ocupation percentage of the parking");
        int option=lt.nextInt();
        lt.nextLine();
        switch(option){
            case 1: System.out.println("Type the base year ");
                year1=lt.nextInt();
                lt.nextLine();
                System.out.println("Type the final year ");
                year2=lt.nextInt();
                lt.nextLine();
                message=objCompany.generateInrform(option,year1,year2);
                break;
            case 2: message=objCompany.generateInrform(option,0,0);
                break;
            case 3: message=objCompany.generateInrform(option,0,0); 
                break;
        }
      
        return message;
    }
}