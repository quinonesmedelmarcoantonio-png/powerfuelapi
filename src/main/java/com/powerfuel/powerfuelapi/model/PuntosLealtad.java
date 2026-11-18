package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "puntos_lealtad")
public class PuntosLealtad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_punto;
    private Long id_cliente;
    private Integer puntos_acumulados;
    private LocalDateTime ultima_actualizacion;

    public Long getId_punto() { return id_punto; }
    public void setId_punto(Long id_punto) { this.id_punto = id_punto; }

    public Long getId_cliente() { return id_cliente; }
    public void setId_cliente(Long id_cliente) { this.id_cliente = id_cliente; }

    public Integer getPuntos_acumulados() { return puntos_acumulados; }
    public void setPuntos_acumulados(Integer puntos_acumulados) { this.puntos_acumulados = puntos_acumulados; }

    public LocalDateTime getUltima_actualizacion() { return ultima_actualizacion; }
    public void setUltima_actualizacion(LocalDateTime ultima_actualizacion) { this.ultima_actualizacion = ultima_actualizacion; }
}