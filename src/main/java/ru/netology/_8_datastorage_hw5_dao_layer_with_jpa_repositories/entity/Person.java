package ru.netology._8_datastorage_hw5_dao_layer_with_jpa_repositories.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "persons", schema = "hibernate")
public class Person {
    @EmbeddedId
    private NameSurnameAge nameSurnameAge;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "city_of_living", nullable = false)
    private String cityOfLiving = "Moscow";
}