package ua.gatolabs.web.dto;

import java.time.LocalDate;

public class CarCharacteristic {

    private String typeOfTransport;
    private  String brand;
    private LocalDate year;
    private double carMileage;
    private String bodyType;
    private String modification;
    private String region;
    private String transmission;
//    private String model;
//    private String color;
//    private String city;
//    private LocalDate yearOfProduction;
//    private String engineType;
//    private BigDecimal price;


    public CarCharacteristic(String typeOfTransport, String brand, LocalDate year, double carMileage, String bodyType, String modification, String region, String transmission) {
        this.typeOfTransport = typeOfTransport;
        this.brand = brand;
        this.year = year;
        this.carMileage = carMileage;
        this.bodyType = bodyType;
        this.modification = modification;
        this.region = region;
        this.transmission = transmission;
    }

    public String getTypeOfTransport() {
        return typeOfTransport;
    }

    public void setTypeOfTransport(String typeOfTransport) {
        this.typeOfTransport = typeOfTransport;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public double getCarMileage() {
        return carMileage;
    }

    public void setCarMileage(double carMileage) {
        this.carMileage = carMileage;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getModification() {
        return modification;
    }

    public void setModification(String modification) {
        this.modification = modification;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String formatData() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ")
                .append("type of transport = " + typeOfTransport)
                .append("brand = " + brand)
                .append("year = " + year)
                .append("car mileage = " + carMileage)
                .append("bodyType = " + bodyType)
                .append("modification = " + modification)
                .append("region = " + region)
                .append("transmission = " + transmission)
                .append(" ]");
        return sb.toString();
    }
}
