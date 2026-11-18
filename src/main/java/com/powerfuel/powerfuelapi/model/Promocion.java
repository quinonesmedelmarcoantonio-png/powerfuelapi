package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "promociones")
public class Promocion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_promocion;
    private String nombre;
    private String descripcion;
    private BigDecimal porcentaje_descuento;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;
    private Boolean activa;
    private Long id_producto;

    public Long getId_promocion() { return id_promocion; }
    public void setId_promocion(Long id_promocion) { this.id_promocion = id_promocion; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getPorcentaje_descuento() { return porcentaje_descuento; }
    public void setPorcentaje_descuento(BigDecimal porcentaje_descuento) { this.porcentaje_descuento = porcentaje_descuento; }

    public LocalDate getFecha_inicio() { return fecha_inicio; }
    public void setFecha_inicio(LocalDate fecha_inicio) { this.fecha_inicio = fecha_inicio; }

    public LocalDate getFecha_fin() { return fecha_fin; }
    public void setFecha_fin(LocalDate fecha_fin) { this.fecha_fin = fecha_fin; }

    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }

    public Long getId_producto() { return id_producto; }
    public void setId_producto(Long id_producto) { this.id_producto = id_producto; }
}