package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "subcategorias")
public class Subcategoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_subcategoria;
    private Long id_categoria;
    private String nombre;

    public Long getId_subcategoria() { return id_subcategoria; }
    public void setId_subcategoria(Long id_subcategoria) { this.id_subcategoria = id_subcategoria; }

    public Long getId_categoria() { return id_categoria; }
    public void setId_categoria(Long id_categoria) { this.id_categoria = id_categoria; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}