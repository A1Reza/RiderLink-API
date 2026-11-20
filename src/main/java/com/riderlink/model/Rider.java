package com.riderlink.model;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue("RIDER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rider extends UserDao {

    @Column(length = 200, nullable = true)
    private String homeAddress;
}
/*
We do not use `@Builder` in the child class,
so that it does not conflict with the parent class's builder.
*/
