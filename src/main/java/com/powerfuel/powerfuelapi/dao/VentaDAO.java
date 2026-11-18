package com.powerfuel.powerfuelapi.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VentaDAO {

    private Long id_venta;
    private LocalDateTime fecha_hora;
    private Long id_usuario;  // Cambiado a Long
    private Long id_cliente;  // Cambiado a Long
    private BigDecimal total;

    public VentaDAO() {}

    public VentaDAO(Long id_venta, LocalDateTime fecha_hora, Long id_usuario,
                    Long id_cliente, BigDecimal total) {
        this.id_venta = id_venta;
        this.fecha_hora = fecha_hora;
        this.id_usuario = id_usuario;
        this.id_cliente = id_cliente;
        this.total = total;
    }

    // Getters y Setters
    public Long getId_venta() { return id_venta; }
    public void setId_venta(Long id_venta) { this.id_venta = id_venta; }

    public LocalDateTime getFecha_hora() { return fecha_hora; }
    public void setFecha_hora(LocalDateTime fecha_hora) { this.fecha_hora = fecha_hora; }

    public Long getId_usuario() { return id_usuario; }
    public void setId_usuario(Long id_usuario) { this.id_usuario = id_usuario; }

    public Long getId_cliente() { return id_cliente; }
    public void setId_cliente(Long id_cliente) { this.id_cliente = id_cliente; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}