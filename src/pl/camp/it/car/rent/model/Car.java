package pl.camp.it.car.rent.model;

public class Car extends Vehicle {
    public Car(String brand, String model, int mileage, int year, double price, String plate, boolean rent) {
        super(brand, model, mileage, year, price, plate, rent);
    }

    @Override
    public String convertToDbRecord() {
        StringBuilder sb = new StringBuilder();
        sb.append("Car;")
                .append(this.getBrand())
        .append(";")
        .append(this.getModel())
        .append(";")
        .append(this.getMileage())
        .append(";")
        .append((this.getYear()))
        .append(";")
        .append(this.getPrice())
        .append(";")
        .append(this.getPlate())
        .append(";")
        .append(this.isRent());

        return sb.toString();
    }
}
