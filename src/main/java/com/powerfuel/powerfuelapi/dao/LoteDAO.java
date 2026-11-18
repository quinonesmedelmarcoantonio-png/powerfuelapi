package com.powerfuel.powerfuelapi.dao;

import java.time.LocalDate;

public class LoteDAO {

    private Long id_lote;
    private Long id_producto;
    private String numero_lote;
    private LocalDate fecha_caducidad;
    private Integer cantidad_actual;

    public LoteDAO(Long id_lote, Long id_producto, String numero_lote, LocalDate fecha_caducidad, Integer cantidad_actual) {
        this.id_lote = id_lote;
        this.id_producto = id_producto;
        this.numero_lote = numero_lote;
        this.fecha_caducidad = fecha_caducidad;
        this.cantidad_actual = cantidad_actual;
    }

    public Long getId_lote() { return id_lote; }
    public void setId_lote(Long id_lote) { this.id_lote = id_lote; }

    public Long getId_producto() { return id_producto; }
    public void setId_producto(Long id_producto) { this.id_producto = id_producto; }

    public String getNumero_lote() { return numero_lote; }
    public void setNumero_lote(String numero_lote) { this.numero_lote = numero_lote; }

    public LocalDate getFecha_caducidad() { return fecha_caducidad; }
    public void setFecha_caducidad(LocalDate fecha_caducidad) { this.fecha_caducidad = fecha_caducidad; }

    public Integer getCantidad_actual() { return cantidad_actual; }
    public void setCantidad_actual(Integer cantidad_actual) { this.cantidad_actual = cantidad_actual; }
}