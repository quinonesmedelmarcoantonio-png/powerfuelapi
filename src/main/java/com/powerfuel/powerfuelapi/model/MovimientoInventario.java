package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "movimientos_inventario")
public class MovimientoInventario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_movimiento;
    private Long id_producto;
    private String tipo_movimiento;
    private Integer cantidad;
    private String motivo;
    private LocalDateTime fecha_movimiento;

    public Long getId_movimiento() { return id_movimiento; }
    public void setId_movimiento(Long id_movimiento) { this.id_movimiento = id_movimiento; }

    public Long getId_producto() { return id_producto; }
    public void setId_producto(Long id_producto) { this.id_producto = id_producto; }

    public String getTipo_movimiento() { return tipo_movimiento; }
    public void setTipo_movimiento(String tipo_movimiento) { this.tipo_movimiento = tipo_movimiento; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public String getMotivo() { return motivo; }
    public void setMotivo(String motivo) { this.motivo = motivo; }

    public LocalDateTime getFecha_movimiento() { return fecha_movimiento; }
    public void setFecha_movimiento(LocalDateTime fecha_movimiento) { this.fecha_movimiento = fecha_movimiento; }
}