package com.powerfuel.powerfuelapi.service;

import com.powerfuel.powerfuelapi.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    // Método para obtener el detalle de una venta con el nombre del producto (JOIN)
    public List<Object[]> obtenerDetalleConNombre(Long idVenta) {
        return ventaRepository.findDetalleConNombreProducto(idVenta);
    }
}