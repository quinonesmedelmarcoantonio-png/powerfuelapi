package com.powerfuel.powerfuelapi.controller;

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

    // Endpoint con FILTRO: /api/productos/caros?precio=5000
    @GetMapping("/caros")
    public List<Producto> getProductosCaros(@RequestParam Double precio) {
        return productoService.obtenerProductosCaros(precio);
    }

    // Endpoint para listar todos los productos
    @GetMapping
    public List<Producto> listarTodos() {
        return productoService.listarTodos();
    }
}