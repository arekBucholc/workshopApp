package com.example.workshopapp.car;

public class CarTaskDto {
    private Long id;
    private String description;
    private Double cost;
    private String carMake;
    private String carModel;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

   public void setDescription(final String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(final Double cost) {
        this.cost = cost;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(final String carMake) {
        this.carMake = carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(final String carModel) {
        this.carModel = carModel;
    }
}
