package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "ventas")
public class Venta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_venta;
    
    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;
    
    private Integer id_cliente;
    private BigDecimal total;

    // Getters y Setters
    public Long getId_venta() { return id_venta; }
    public void setId_venta(Long id_venta) { this.id_venta = id_venta; }

    public LocalDateTime getFechaVenta() { return fechaVenta; }
    public void setFechaVenta(LocalDateTime fechaVenta) { this.fechaVenta = fechaVenta; }

    public Integer getId_cliente() { return id_cliente; }
    public void setId_cliente(Integer id_cliente) { this.id_cliente = id_cliente; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}