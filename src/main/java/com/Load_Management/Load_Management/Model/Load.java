package com.Load_Management.Load_Management.Model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "loads")
public class Load {
    @Id
    @Column(name = "load_id")
    private String loadId;

    @Embedded
    @Valid
    private Facility facility;

    @NotBlank(message = "Product type is required")
    @Column(name = "product_type")
    private String productType;

    @NotBlank(message = "Truck type is required")
    @Column(name = "truck_type")
    private String truckType;

    @NotNull(message = "Number of trucks is required")
    @Min(value = 1, message = "At least one truck is required")
    @Column(name = "no_of_trucks")
    private Integer noOfTrucks;

    @NotNull(message = "Weight is required")
    @Min(value = 1, message = "Weight must be greater than 0")
    private Double weight;

    private String comment;

    @NotBlank(message = "Shipper ID is required")
    @Column(name = "shipper_id")
    private String shipperId;

    @NotNull(message = "Date is required")
    private LocalDateTime date;

    // Default constructor
    public Load() {
        this.loadId = "load:" + UUID.randomUUID().toString();
    }

    // Constructor with parameters
    public Load(Facility facility, String productType, String truckType, Integer noOfTrucks,
                Double weight, String comment, String shipperId, LocalDateTime date) {
        this.loadId = "load:" + UUID.randomUUID().toString();
        this.facility = facility;
        this.productType = productType;
        this.truckType = truckType;
        this.noOfTrucks = noOfTrucks;
        this.weight = weight;
        this.comment = comment;
        this.shipperId = shipperId;
        this.date = date;
    }

    // Getters and Setters
    public String getLoadId() {
        return loadId;
    }

    public void setLoadId(String loadId) {
        this.loadId = loadId;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getTruckType() {
        return truckType;
    }

    public void setTruckType(String truckType) {
        this.truckType = truckType;
    }

    public Integer getNoOfTrucks() {
        return noOfTrucks;
    }

    public void setNoOfTrucks(Integer noOfTrucks) {
        this.noOfTrucks = noOfTrucks;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getShipperId() {
        return shipperId;
    }

    public void setShipperId(String shipperId) {
        this.shipperId = shipperId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

