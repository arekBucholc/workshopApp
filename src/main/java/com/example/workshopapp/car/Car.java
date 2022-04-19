package com.example.workshopapp.car;

import com.example.workshopapp.task.Task;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2)
    private String make;
    @Size(min = 2)
    private String model;
    @Min(1908)
    private int year;
    private String ownerFirstName;
    private String ownerLastName;
    @Size(min = 11, max = 11)
    private String ownerContactNumber;

    @OneToMany(mappedBy = "car",cascade = CascadeType.REMOVE)
    private List<Task> tasks = new ArrayList<>();

    public Car(final String make, final String model, final int year, final String ownerFirstName, final String ownerLastName,
               String ownerContactNumber) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.ownerFirstName = ownerFirstName;
        this.ownerLastName = ownerLastName;
        this.ownerContactNumber= ownerContactNumber;
    }

    String getOwnerContactNumber() {
        return ownerContactNumber;
    }

    void setOwnerContactNumber(final String ownerContactNumber) {
        this.ownerContactNumber = ownerContactNumber;
    }

    public Car() {

    }

    public Long getId() {
        return id;
    }

    void setId(final Long carId) {
        this.id = carId;
    }

    public String getMake() {
        return make;
    }

    void setMake(final String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    void setModel(final String model) {
        this.model = model;
    }

    int getYear() {
        return year;
    }

    void setYear(final int year) {
        this.year = year;
    }

    String getOwnerFirstName() {
        return ownerFirstName;
    }

    void setOwnerFirstName(final String ownerFirstName) {
        this.ownerFirstName = ownerFirstName;
    }

    String getOwnerLastName() {
        return ownerLastName;
    }

    void setOwnerLastName(final String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }

    List<Task> getTasks() {
        return tasks;
    }

    void setTasks(final List<Task> tasks) {
        this.tasks = tasks;
    }
}
