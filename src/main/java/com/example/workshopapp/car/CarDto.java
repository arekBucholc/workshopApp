package com.example.workshopapp.car;

public class CarDto {
    private Long id;
    private String make;
    private String model;
    private int year;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerContactNumber;

     public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(final String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(final int year) {
        this.year = year;
    }

   public String getOwnerFirstName() {
        return ownerFirstName;
    }

    public void setOwnerFirstName(final String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

   public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(final String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

   public  String getOwnerContactNumber() {
        return ownerContactNumber;
    }

    public void setOwnerContactNumber(final String ownerContactNumber) {
        this.ownerContactNumber = ownerContactNumber;
    }
}
