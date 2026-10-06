package com.powerfuel.powerfuelapi.controller;

import com.powerfuel.powerfuelapi.dao.ProductoDAO;
import com.powerfuel.powerfuelapi.model.Producto;
import com.powerfuel.powerfuelapi.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Endpoint con FILTRO
    @GetMapping("/caros")
    public List<Producto> getProductosCaros(@RequestParam Double precio) {
        return productoService.obtenerProductosCaros(precio);
    }

    // Endpoint con DAO (NUEVO)
    @GetMapping("/listar")
    public List<ProductoDAO> listarProductosDAO() {
        return productoService.listarTodosDAO();
    }

    // Endpoint para listar todos
    @GetMapping
    public List<Producto> listarTodos() {
        return productoService.listarTodos();
    }
}