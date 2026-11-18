package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resenas")
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_resena;
    private Long id_producto;
    private Long id_cliente;
    private Integer calificacion;
    private String comentario;
    private LocalDateTime fecha_resena;

    public Long getId_resena() { return id_resena; }
    public void setId_resena(Long id_resena) { this.id_resena = id_resena; }

    public Long getId_producto() { return id_producto; }
    public void setId_producto(Long id_producto) { this.id_producto = id_producto; }

    public Long getId_cliente() { return id_cliente; }
    public void setId_cliente(Long id_cliente) { this.id_cliente = id_cliente; }

    public Integer getCalificacion() { return calificacion; }
    public void setCalificacion(Integer calificacion) { this.calificacion = calificacion; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public LocalDateTime getFecha_resena() { return fecha_resena; }
    public void setFecha_resena(LocalDateTime fecha_resena) { this.fecha_resena = fecha_resena; }
}