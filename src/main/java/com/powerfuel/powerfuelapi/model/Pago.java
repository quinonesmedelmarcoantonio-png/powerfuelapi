package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_pago;
    private Long id_venta;
    private String metodo_pago;
    private BigDecimal monto;
    private LocalDateTime fecha_pago;

    public Long getId_pago() { return id_pago; }
    public void setId_pago(Long id_pago) { this.id_pago = id_pago; }

    public Long getId_venta() { return id_venta; }
    public void setId_venta(Long id_venta) { this.id_venta = id_venta; }

    public String getMetodo_pago() { return metodo_pago; }
    public void setMetodo_pago(String metodo_pago) { this.metodo_pago = metodo_pago; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public LocalDateTime getFecha_pago() { return fecha_pago; }
    public void setFecha_pago(LocalDateTime fecha_pago) { this.fecha_pago = fecha_pago; }
}