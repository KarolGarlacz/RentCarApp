package pl.camp.it.car.rent.model;

public class Bus extends Vehicle {
    private int seats;
    private boolean lowRider;

    public Bus(String brand, String model, int mileage, int year, double price, String plate, int seats, boolean lowRider, boolean rent) {
        super(brand, model, mileage, year, price, plate, rent);
        this.seats = seats;
        this.lowRider = lowRider;
    }

    public int getSeats() {
        return seats;
    }

    public boolean isLowRider() {
        return lowRider;
    }

    @Override
    public String convertToDbRecord() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bus;")
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
                .append(this.getSeats())
        .append(";")
                .append(this.lowRider)
        .append(";")
                .append(this.isRent());

        return sb.toString();
    }
}
