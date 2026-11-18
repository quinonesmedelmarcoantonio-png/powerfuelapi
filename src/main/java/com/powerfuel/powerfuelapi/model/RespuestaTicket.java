package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "respuestas_ticket")
public class RespuestaTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_respuesta;
    private Long id_ticket;
    private Long id_usuario;
    private String mensaje;
    private LocalDateTime fecha_respuesta;

    public Long getId_respuesta() { return id_respuesta; }
    public void setId_respuesta(Long id_respuesta) { this.id_respuesta = id_respuesta; }

    public Long getId_ticket() { return id_ticket; }
    public void setId_ticket(Long id_ticket) { this.id_ticket = id_ticket; }

    public Long getId_usuario() { return id_usuario; }
    public void setId_usuario(Long id_usuario) { this.id_usuario = id_usuario; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDateTime getFecha_respuesta() { return fecha_respuesta; }
    public void setFecha_respuesta(LocalDateTime fecha_respuesta) { this.fecha_respuesta = fecha_respuesta; }
}