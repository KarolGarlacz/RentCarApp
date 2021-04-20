package pl.camp.it.car.rent;

import pl.camp.it.car.rent.database.Database;
import pl.camp.it.car.rent.gui.GUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {
    public static void main(String[] args) {
        Database database = Database.getInstance();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int loginCounter = 0;
        while (true) {
            String login, password;

            try {
                System.out.println("Enter login:");
                login = reader.readLine();
                System.out.println("Enter password:");
                password = reader.readLine();
            } catch (IOException e) {
                System.out.println("Data loading failed !!");
                continue;
            }


            boolean authResult = database.authenticate(login, password);
            if (authResult) {
                break;
            } else {
                System.out.println("Incorrect data !!");
                loginCounter++;
            }

            if (loginCounter >= 3) {
                System.out.println("Login failed !!");
                System.exit(0);
            }
        }

        boolean flag = true;
        while (flag) {
            try {
                GUI.showMainMenu();
                switch (reader.readLine()) {
                    case "1":
                        GUI.showAllVehicles(database.getVehicles());
                        break;
                    case "2":
                        System.out.println("Enter the plate number of the vehicle:");
                        GUI.showRentResult(database.rentVehicle(reader.readLine()));
                        break;
                    case "3":
                        System.out.println("Enter the plate number of the vehicle:");
                        GUI.showReturnResult(database.returnVehicle(reader.readLine()));
                        break;
                    case "4":
                        flag = false;
                        Database.getInstance().writeDataToFile();
                        break;
                    default:
                        System.out.println("Invalid selection !!");
                }
            } catch (IOException e) {
                System.out.println("Error !");

            }

        }
    }
}
