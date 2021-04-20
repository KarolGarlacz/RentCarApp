package pl.camp.it.car.rent.model;

public class Motorcycle extends Vehicle {
    private boolean extraSeat;
    private String type;

    public Motorcycle(String brand, String model, int mileage,
                      int year, double price, String plate,
                      boolean extraSeat, String type, boolean rent) {
        super(brand, model, mileage, year, price, plate, rent);
        this.extraSeat = extraSeat;
        this.type = type;
    }

    public boolean isExtraSeat() {
        return extraSeat;
    }

    public String getType() {
        return type;
    }

    @Override
    public String convertToDbRecord() {
        StringBuilder sb = new StringBuilder();
        sb.append("Motorcycle;")
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
                .append(this.extraSeat)
        .append(";")
        .append(this.type)
                .append(";")
                .append(this.isRent());

        return sb.toString();
    }
}
