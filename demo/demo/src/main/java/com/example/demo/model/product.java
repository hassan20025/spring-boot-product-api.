package com.example.demo.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class product{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String description;
    private String brand;
    private Float price;
    private String category;
    private Date releasedate;
    private Boolean productAvalability;
    private int stockQuantity;
    private String imageName;
    private String imageType;
    @Lob
    private byte[] imageData;
}