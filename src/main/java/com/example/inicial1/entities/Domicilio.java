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

    @ManyToOne(optional = false)//La relacion no puede ser null, si o si debe existir una localidad para cada domiciliio creado
    @JoinColumn(name = "fk_localidad")
    private Localidad localidad;
}
