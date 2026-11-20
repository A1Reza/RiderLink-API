package com.riderlink.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("DRIVER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends UserDao {

    @Column(length = 30, nullable = true)
    private String vehicleLicenseNumber;
}
