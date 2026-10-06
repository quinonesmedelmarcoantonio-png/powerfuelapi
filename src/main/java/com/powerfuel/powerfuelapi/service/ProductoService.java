package com.powerfuel.powerfuelapi.service;

import com.powerfuel.powerfuelapi.model.Producto;
import com.powerfuel.powerfuelapi.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Método para obtener productos con precio mayor al enviado
    public List<Producto> obtenerProductosCaros(Double precio) {
        return productoRepository.findProductosCaros(precio);
    }

    // Método para listar todos los productos
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }
}