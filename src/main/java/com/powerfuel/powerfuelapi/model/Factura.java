package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_factura;
    private Long id_venta;
    private String rfc;
    private String razon_social;
    private String folio_fiscal;
    private LocalDateTime fecha_emision;

    public Long getId_factura() { return id_factura; }
    public void setId_factura(Long id_factura) { this.id_factura = id_factura; }

    public Long getId_venta() { return id_venta; }
    public void setId_venta(Long id_venta) { this.id_venta = id_venta; }

    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }

    public String getRazon_social() { return razon_social; }
    public void setRazon_social(String razon_social) { this.razon_social = razon_social; }

    public String getFolio_fiscal() { return folio_fiscal; }
    public void setFolio_fiscal(String folio_fiscal) { this.folio_fiscal = folio_fiscal; }

    public LocalDateTime getFecha_emision() { return fecha_emision; }
    public void setFecha_emision(LocalDateTime fecha_emision) { this.fecha_emision = fecha_emision; }
}