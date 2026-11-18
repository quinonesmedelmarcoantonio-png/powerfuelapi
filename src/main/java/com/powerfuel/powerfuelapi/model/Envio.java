package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "envios")
public class Envio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_envio;
    private Long id_venta;
    private String direccion_envio;
    private String ciudad;
    private String estado;
    private String codigo_postal;
    private String paqueteria;
    private String numero_guia;
    private String estado_envio;
    private LocalDateTime fecha_envio;

    public Long getId_envio() { return id_envio; }
    public void setId_envio(Long id_envio) { this.id_envio = id_envio; }

    public Long getId_venta() { return id_venta; }
    public void setId_venta(Long id_venta) { this.id_venta = id_venta; }

    public String getDireccion_envio() { return direccion_envio; }
    public void setDireccion_envio(String direccion_envio) { this.direccion_envio = direccion_envio; }

    public String getCiudad() { return ciudad; }
    public void setCiudad(String ciudad) { this.ciudad = ciudad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCodigo_postal() { return codigo_postal; }
    public void setCodigo_postal(String codigo_postal) { this.codigo_postal = codigo_postal; }

    public String getPaqueteria() { return paqueteria; }
    public void setPaqueteria(String paqueteria) { this.paqueteria = paqueteria; }

    public String getNumero_guia() { return numero_guia; }
    public void setNumero_guia(String numero_guia) { this.numero_guia = numero_guia; }

    public String getEstado_envio() { return estado_envio; }
    public void setEstado_envio(String estado_envio) { this.estado_envio = estado_envio; }

    public LocalDateTime getFecha_envio() { return fecha_envio; }
    public void setFecha_envio(LocalDateTime fecha_envio) { this.fecha_envio = fecha_envio; }
}