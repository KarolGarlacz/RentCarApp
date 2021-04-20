package pl.camp.it.car.rent.database;

//import org.apache.commons.codec.digest.DigestUtils;

import pl.camp.it.car.rent.model.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Vehicle> vehicles = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private static Database instance = new Database();
    private final String pathToDbFile = "carRent.txt";

    private Database() {
    loadDataFromFile();
       /* this.vehicles.add(new Car("BMW", "5", 200000, 2010, 300.0, "KR11"));
        this.vehicles.add(new Car("Audi", "A6", 150000, 2012, 400.0, "KR22"));
        this.vehicles.add(new Car("Toyota", "Corolla", 70000, 2019, 350.0, "KR33"));
        this.vehicles.add(new Car("Mercedes", "E", 200000, 2009, 320.0, "KR44"));
        this.vehicles.add(new Car("Honda", "Civic", 40000, 2016, 360.99, "KR55"));

        this.vehicles.add(new Bus("Solaris", "5000", 500000, 2007, 600.0, "KR666", 50, true));
        this.vehicles.add(new Bus("Solaris", "2000", 700000, 2002, 500.0, "KR777", 40, false));

        this.vehicles.add(new Motorcycle("BMW", "500", 30000, 2010, 300.0, "KR1111", false, "Ścigacz"));
        this.vehicles.add(new Motorcycle("Harley Davidson", "Night Rod", 30000, 2014, 400.0, "KR2222", false, "Chopper"));
        this.vehicles.add(new Motorcycle("Honda", "CB1000R", 10000, 2016, 450.0, "KR3333", false, "Street"));

        this.users.add(new User("admin", "admin"));*/

    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public static Database getInstance() {
        if (Database.instance == null) {
            Database.instance = new Database();
        }
        return Database.instance;

    }

    public boolean rentVehicle(String plate) {
        Vehicle vehicle = findVehicle(plate);
        if (vehicle != null && !vehicle.isRent()) {
            vehicle.setRent(true);
            return true;
        }
        return false;
    }

    public boolean returnVehicle(String plate) {
        Vehicle vehicle = findVehicle(plate);
        if (vehicle != null && vehicle.isRent()) {
            vehicle.setRent(false);
            return true;
        }
        return false;
    }

    private Vehicle findVehicle(String plate) {
        for (Vehicle vehicle : this.vehicles) {
            if (vehicle.getPlate().equals(plate)) {
                return vehicle;
            }
        }
        return null;
    }

    public boolean authenticate(String login, String password) {
        for (User currentUser : this.users) {
            if (currentUser.getLogin().equals(login) && currentUser.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public void listUsers() {
        for (User user : this.users) {
            System.out.println(user.getLogin() + " - " + user.getPassword());
        }
    }

    public void writeDataToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(this.pathToDbFile));
            for(Vehicle vehicle : this.vehicles){
                writer.append(vehicle.convertToDbRecord());
                writer.newLine();
            }
            for(User user :this.users){
                writer.append(user.convertToDbRecord());
                writer.newLine();

            }
           writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadDataFromFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(this.pathToDbFile));
            String record;
            while((record = reader.readLine()) != null){
               String[] recordArray = record.split(";");
               switch (recordArray[0]){
                   case "Car":
                       Car c = new Car(recordArray[1], recordArray[2], Integer.parseInt(recordArray[3]),Integer.parseInt(recordArray[4]),Double.parseDouble(recordArray[5]),recordArray[6], Boolean.parseBoolean(recordArray[7]));
                       this.vehicles.add(c);
                       break;
                   case "Bus":
                       this.vehicles.add(
                               new Bus(recordArray[1], recordArray[2],
                                       Integer.parseInt(recordArray[3]), Integer.parseInt(recordArray[4]),
                                       Double.parseDouble(recordArray[5]), recordArray[6],
                                       Integer.parseInt(recordArray[7]), Boolean.parseBoolean(recordArray[8]),
                                       Boolean.parseBoolean(recordArray[9])));
                       break;
                   case "Motorcycle":
                       this.vehicles.add(
                               new Motorcycle(recordArray[1], recordArray[2],
                                       Integer.parseInt(recordArray[3]), Integer.parseInt(recordArray[4]),
                                       Double.parseDouble(recordArray[5]), recordArray[6],
                                       Boolean.parseBoolean(recordArray[7]), recordArray[8],
                                       Boolean.parseBoolean(recordArray[9]))
                       );
                       break;
                   case "User":
                       this.users.add(new User(recordArray[1], recordArray[2]));
                       break;
               }
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
