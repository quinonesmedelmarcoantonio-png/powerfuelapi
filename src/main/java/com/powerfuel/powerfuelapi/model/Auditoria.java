package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auditoria")
public class Auditoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_auditoria;
    private Long id_usuario;
    private String accion;
    private String tabla_afectada;
    private LocalDateTime fecha_accion;
    private String detalles;

    public Long getId_auditoria() { return id_auditoria; }
    public void setId_auditoria(Long id_auditoria) { this.id_auditoria = id_auditoria; }

    public Long getId_usuario() { return id_usuario; }
    public void setId_usuario(Long id_usuario) { this.id_usuario = id_usuario; }

    public String getAccion() { return accion; }
    public void setAccion(String accion) { this.accion = accion; }

    public String getTabla_afectada() { return tabla_afectada; }
    public void setTabla_afectada(String tabla_afectada) { this.tabla_afectada = tabla_afectada; }

    public LocalDateTime getFecha_accion() { return fecha_accion; }
    public void setFecha_accion(LocalDateTime fecha_accion) { this.fecha_accion = fecha_accion; }

    public String getDetalles() { return detalles; }
    public void setDetalles(String detalles) { this.detalles = detalles; }
}