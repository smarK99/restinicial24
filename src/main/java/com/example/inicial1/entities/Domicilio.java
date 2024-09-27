package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Table(name = "domicilio")
public class Domicilio extends Base {

    private String calle;

    private int numero;

    @OneToMany(cascade = CascadeType.PERSIST)
    @Builder.Default
    private Set<Localidad> localidades = new HashSet<>();
}
