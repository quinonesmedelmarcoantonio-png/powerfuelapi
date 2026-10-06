package com.powerfuel.powerfuelapi.service;

import com.powerfuel.powerfuelapi.dao.ProductoDAO;
import com.powerfuel.powerfuelapi.model.Producto;
import com.powerfuel.powerfuelapi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Convertir Producto (entidad) a ProductoDAO (DTO)
    public ProductoDAO convertirAProductoDAO(Producto p) {
        return new ProductoDAO(
            p.getId_producto(),
            p.getNombre(),
            null,
            p.getPrecio(),
            p.getStock(),
            null
        );
    }

    // Listar todos los productos como DAO (limpio)
    public List<ProductoDAO> listarTodosDAO() {
        List<Producto> productos = productoRepository.findAll();
        List<ProductoDAO> productosDAO = new ArrayList<>();
        for (Producto p : productos) {
            productosDAO.add(convertirAProductoDAO(p));
        }
        return productosDAO;
    }

    // Filtro de productos caros
    public List<Producto> obtenerProductosCaros(Double precio) {
        return productoRepository.findProductosCaros(precio);
    }

    // Listar todos (versión entidad)
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }
}