package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_detalle;
    
    private Long id_venta;
    private Long id_producto;
    private Integer cantidad;
    private BigDecimal precio_unitario;

    // Getters y Setters
    public Long getId_detalle() { return id_detalle; }
    public void setId_detalle(Long id_detalle) { this.id_detalle = id_detalle; }

    public Long getId_venta() { return id_venta; }
    public void setId_venta(Long id_venta) { this.id_venta = id_venta; }

    public Long getId_producto() { return id_producto; }
    public void setId_producto(Long id_producto) { this.id_producto = id_producto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public BigDecimal getPrecio_unitario() { return precio_unitario; }
    public void setPrecio_unitario(BigDecimal precio_unitario) { this.precio_unitario = precio_unitario; }
}