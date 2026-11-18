package com.powerfuel.powerfuelapi.controller;

import com.powerfuel.powerfuelapi.dao.ProductoDAO;
import com.powerfuel.powerfuelapi.model.Producto;
import com.powerfuel.powerfuelapi.repository.ProductoRepository;
import com.powerfuel.powerfuelapi.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity; // <-- Import necesario para el PUT
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private ProductoRepository productoRepository; // <-- Agregamos el repo

    // Endpoint con FILTRO
    @GetMapping("/caros")
    public List<Producto> getProductosCaros(@RequestParam BigDecimal precio) {
        return productoService.obtenerProductosCaros(precio);
    }

    // Endpoint con DAO
    @GetMapping("/listar")
    public List<ProductoDAO> listarProductosDAO() {
        return productoService.listarTodosDAO();
    }

    // Endpoint para listar todos
    @GetMapping
    public List<Producto> listarTodos() {
        return productoService.listarTodos();
    }

    // ¡AQUÍ ESTÁ EL NUEVO ENDPOINT POST!
    @PostMapping
    public Producto crear(@RequestBody Producto producto) {
        return productoRepository.save(producto);
    }

    // --- NUEVO ENDPOINT PUT (Para actualizar imágenes y datos) --- // recien echo ayer el cambio 
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(@PathVariable Long id, @RequestBody Producto datos) {
        return productoRepository.findById(id)
                .map(producto -> {
                    producto.setNombre(datos.getNombre());
                    producto.setDescripcion(datos.getDescripcion());
                    producto.setPrecio(datos.getPrecio());
                    producto.setStock(datos.getStock());
                    producto.setCategoria(datos.getCategoria());
                    producto.setMarca(datos.getMarca());
                    producto.setImagen(datos.getImagen());
                    return ResponseEntity.ok(productoRepository.save(producto));
                })
                .orElse(ResponseEntity.notFound().build());
    }
}