package com.example.workshopapp.task;

import com.example.workshopapp.car.Car;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 200)
    private String description;
    @JsonFormat(pattern = "yyyy-MM-dd",shape = JsonFormat.Shape.STRING)
    @Future
    private Date startDate;
    private Double cost;
    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id")
    private Car car;



    public Task( String description,  Date startDate,  Double cost,  Car car) {
        this.description = description;
        this.startDate = startDate;
        this.cost = cost;
        this.car = car;
    }

    public Double getCost() {
        return cost;
    }

    void setCost(final Double cost) {
        this.cost = cost;
    }

    public Task() {

    }

    public Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    public String getDescription() {
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

   public Car getCar() {
        return car;
    }

    void setCar(final Car car) {
        this.car = car;
    }
}
