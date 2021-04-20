package pl.camp.it.car.rent.gui;

import pl.camp.it.car.rent.model.Bus;
import pl.camp.it.car.rent.model.Motorcycle;
import pl.camp.it.car.rent.model.Vehicle;
import java.util.List;

public class GUI {
    static public void showMainMenu() {
        System.out.println("1. List Vehicles");
        System.out.println("2. Rent Vehicle");
        System.out.println("3. Return Vehicle");
        System.out.println("4. Exit");
    }

    static public void showAllVehicles(List<Vehicle> vehicles) {
        for(Vehicle vehicle : vehicles) {
            StringBuilder sb = new StringBuilder();
            sb.append(vehicle.getBrand())
                    .append(" ")
                    .append(vehicle.getModel())
                    .append(" Year of production: ")
                    .append(vehicle.getYear())
                    .append(" Mileage: ")
                    .append(vehicle.getMileage())
                    .append(" Price: ")
                    .append(vehicle.getPrice())
                    .append(" Plate: ")
                    .append(vehicle.getPlate());

            if(vehicle instanceof Bus) {
                Bus bus = (Bus) vehicle;
                sb.append(" Number od seats: ")
                        .append(bus.getSeats())
                        .append(" Low rider: ")
                        .append(bus.isLowRider() ? "Yes" : "No");
            }

            if(vehicle instanceof Motorcycle) {
                Motorcycle motorcycle = (Motorcycle) vehicle;
                sb.append(" Extra seats: ")
                        .append(motorcycle.isExtraSeat() ? "No" : "Yes")
                        .append(" type: ")
                        .append(motorcycle.getType());
            }

            sb.append(" Available: ")
                    .append(vehicle.isRent() ? "No" : "Yes");


            System.out.println(sb.toString());
        }
    }




    static public void showRentResult(boolean rentResult) {
        if(rentResult) {
            System.out.println("Rented !!");
        } else {
            System.out.println("Vehicle not found or rented !!");
        }
    }

    static public void showReturnResult(boolean returnResult) {
        if(returnResult) {
            System.out.println("Returned  !!");
        } else {
            System.out.println("Vehicle not found or not rented !!");
        }
    }
}
