package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "avisos")
public class Aviso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_aviso;
    private String titulo;
    private String mensaje;
    private LocalDateTime fecha_publicacion;
    private Long id_usuario_creador;

    public Long getId_aviso() { return id_aviso; }
    public void setId_aviso(Long id_aviso) { this.id_aviso = id_aviso; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getFecha_publicacion() { return fecha_publicacion; }
    public void setFecha_publicacion(LocalDateTime fecha_publicacion) { this.fecha_publicacion = fecha_publicacion; }

    public Long getId_usuario_creador() { return id_usuario_creador; }
    public void setId_usuario_creador(Long id_usuario_creador) { this.id_usuario_creador = id_usuario_creador; }
}