package pl.camp.it.car.rent.model;

public abstract class Vehicle {
    private String brand;
    private String model;
    private int mileage;
    private int year;
    private double price;
    private String plate;
    private boolean rent;

    public Vehicle(String brand, String model, int mileage, int year, double price, String plate, boolean rent) {
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
        this.year = year;
        this.price = price;
        this.plate = plate;
        this.rent = rent;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    abstract public String convertToDbRecord();
}
