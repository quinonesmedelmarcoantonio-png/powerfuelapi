package com.powerfuel.powerfuelapi.dao;

public class ClienteDAO {

    private Long id_cliente;
    private String nombre;
    private String telefono;
    private String correo;
    private String alergias_conocidas;
    private String objetivo;

    public ClienteDAO(Long id_cliente, String nombre, String telefono, String correo, String alergias_conocidas, String objetivo) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.alergias_conocidas = alergias_conocidas;
        this.objetivo = objetivo;
    }

    public Long getId_cliente() { return id_cliente; }
    public void setId_cliente(Long id_cliente) { this.id_cliente = id_cliente; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getAlergias_conocidas() { return alergias_conocidas; }
    public void setAlergias_conocidas(String alergias_conocidas) { this.alergias_conocidas = alergias_conocidas; }

    public String getObjetivo() { return objetivo; }
    public void setObjetivo(String objetivo) { this.objetivo = objetivo; }
}