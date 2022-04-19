package com.example.workshopapp.task;

import java.util.Date;

public class TaskDto {
    private Long id;
    private String description;
    private Date startDate;
    private Double cost;
    private Long carId;
    private String carMake;
    private String carModel;

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    String getDescription() {
        return description;
    }

    void setDescription(final String description) {
        this.description = description;
    }

    Date getStartDate() {
        return startDate;
    }

    void setStartDate(final Date startDate) {
        this.startDate = startDate;
    }

    Double getCost() {
        return cost;
    }

    void setCost(final Double cost) {
        this.cost = cost;
    }

    Long getCarId() {
        return carId;
    }

    void setCarId(final Long carId) {
        this.carId = carId;
    }

    String getCarMake() {
        return carMake;
    }

    void setCarMake(final String carMake) {
        this.carMake = carMake;
    }

    String getCarModel() {
        return carModel;
    }

    void setCarModel(final String carModel) {
        this.carModel = carModel;
    }
}
