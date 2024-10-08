package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@SuperBuilder
@Table(name = "libro")
public class Libro extends Base{

    private String titulo;

    private int fecha;

    private String genero;

    private int paginas;

    private String autor;

    @ManyToMany(cascade = CascadeType.REFRESH)//Que los autores para cada libro se mantengan actualizados
    @JoinTable(
            name = "libro_autor",
            joinColumns = @JoinColumn(name = "id_libro"),
            inverseJoinColumns = @JoinColumn(name = "id_autor")
    )
    @Builder.Default
    private List<Autor> autores = new ArrayList<>();
}
