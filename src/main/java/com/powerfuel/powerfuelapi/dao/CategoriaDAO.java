package com.powerfuel.powerfuelapi.dao;

public class CategoriaDAO {

    private Long id_categoria;
    private String nombre;

    public CategoriaDAO(Long id_categoria, String nombre) {
        this.id_categoria = id_categoria;
        this.nombre = nombre;
    }

    public Long getId_categoria() { return id_categoria; }
    public void setId_categoria(Long id_categoria) { this.id_categoria = id_categoria; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}