package com.powerfuel.powerfuelapi.dao;

import java.math.BigDecimal;

public class ProductoDAO {

    private Long id_producto;
    private String nombre;
    private String descripcion;
    private BigDecimal precio_venta;
    private Integer stock_minimo;
    private Integer id_categoria;

    public ProductoDAO() {}

    public ProductoDAO(Long id_producto, String nombre, String descripcion,
                       BigDecimal precio_venta, Integer stock_minimo, Integer id_categoria) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_venta = precio_venta;
        this.stock_minimo = stock_minimo;
        this.id_categoria = id_categoria;
    }

    // Getters y Setters
    public Long getId_producto() { return id_producto; }
    public void setId_producto(Long id_producto) { this.id_producto = id_producto; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public BigDecimal getPrecio_venta() { return precio_venta; }
    public void setPrecio_venta(BigDecimal precio_venta) { this.precio_venta = precio_venta; }

    public Integer getStock_minimo() { return stock_minimo; }
    public void setStock_minimo(Integer stock_minimo) { this.stock_minimo = stock_minimo; }

    public Integer getId_categoria() { return id_categoria; }
    public void setId_categoria(Integer id_categoria) { this.id_categoria = id_categoria; }
}