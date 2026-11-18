package com.powerfuel.powerfuelapi.dao;

import java.time.LocalDate;

public class UsuarioDAO {

    private Long id_usuario;
    private String nombre_completo;
    private String correo;
    private String telefono;
    private String rol;
    private String contrasena_hash;
    private LocalDate fecha_alta;

    public UsuarioDAO(Long id_usuario, String nombre_completo, String correo, String telefono, String rol, String contrasena_hash, LocalDate fecha_alta) {
        this.id_usuario = id_usuario;
        this.nombre_completo = nombre_completo;
        this.correo = correo;
        this.telefono = telefono;
        this.rol = rol;
        this.contrasena_hash = contrasena_hash;
        this.fecha_alta = fecha_alta;
    }

    public Long getId_usuario() { return id_usuario; }
    public void setId_usuario(Long id_usuario) { this.id_usuario = id_usuario; }

    public String getNombre_completo() { return nombre_completo; }
    public void setNombre_completo(String nombre_completo) { this.nombre_completo = nombre_completo; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getContrasena_hash() { return contrasena_hash; }
    public void setContrasena_hash(String contrasena_hash) { this.contrasena_hash = contrasena_hash; }

    public LocalDate getFecha_alta() { return fecha_alta; }
    public void setFecha_alta(LocalDate fecha_alta) { this.fecha_alta = fecha_alta; }
}