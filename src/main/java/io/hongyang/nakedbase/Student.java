package io.hongyang.nakedbase;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    UUID id;

    @Column(name = "AGE")
    int age;

    @Column(name = "NAME")
    String name;

}
