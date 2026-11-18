package com.powerfuel.powerfuelapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "rol_permiso")
public class RolPermiso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long id_rol;
    private Long id_permiso;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getId_rol() { return id_rol; }
    public void setId_rol(Long id_rol) { this.id_rol = id_rol; }

    public Long getId_permiso() { return id_permiso; }
    public void setId_permiso(Long id_permiso) { this.id_permiso = id_permiso; }
}