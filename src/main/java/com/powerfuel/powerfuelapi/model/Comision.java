package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "comisiones")
public class Comision {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_comision;
    private Long id_usuario;
    private Long id_venta;
    private BigDecimal porcentaje;
    private BigDecimal monto_comision;
    private LocalDate fecha_calculo;

    public Long getId_comision() { return id_comision; }
    public void setId_comision(Long id_comision) { this.id_comision = id_comision; }

    public Long getId_usuario() { return id_usuario; }
    public void setId_usuario(Long id_usuario) { this.id_usuario = id_usuario; }

    public Long getId_venta() { return id_venta; }
    public void setId_venta(Long id_venta) { this.id_venta = id_venta; }

    public BigDecimal getPorcentaje() { return porcentaje; }
    public void setPorcentaje(BigDecimal porcentaje) { this.porcentaje = porcentaje; }

    public BigDecimal getMonto_comision() { return monto_comision; }
    public void setMonto_comision(BigDecimal monto_comision) { this.monto_comision = monto_comision; }

    public LocalDate getFecha_calculo() { return fecha_calculo; }
    public void setFecha_calculo(LocalDate fecha_calculo) { this.fecha_calculo = fecha_calculo; }
}