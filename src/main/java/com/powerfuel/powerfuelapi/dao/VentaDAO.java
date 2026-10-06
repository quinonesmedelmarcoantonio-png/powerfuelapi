package com.powerfuel.powerfuelapi.dao;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VentaDAO {

    private Long id_venta;
    private LocalDateTime fecha_hora;
    private Integer id_usuario;
    private Integer id_cliente;
    private BigDecimal total;

    public VentaDAO() {}

    public VentaDAO(Long id_venta, LocalDateTime fecha_hora, Integer id_usuario,
                    Integer id_cliente, BigDecimal total) {
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

    public Integer getId_usuario() { return id_usuario; }
    public void setId_usuario(Integer id_usuario) { this.id_usuario = id_usuario; }

    public Integer getId_cliente() { return id_cliente; }
    public void setId_cliente(Integer id_cliente) { this.id_cliente = id_cliente; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}