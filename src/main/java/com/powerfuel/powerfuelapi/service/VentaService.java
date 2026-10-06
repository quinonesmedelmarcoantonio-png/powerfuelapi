package com.powerfuel.powerfuelapi.service;

import com.powerfuel.powerfuelapi.dao.VentaDAO;
import com.powerfuel.powerfuelapi.model.Venta;
import com.powerfuel.powerfuelapi.repository.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    // Convertir Venta (entidad) a VentaDAO (DTO)
    public VentaDAO convertirAVentaDAO(Venta v) {
        return new VentaDAO(
            v.getId_venta(),
            v.getFechaVenta(),
            v.getId_cliente(),
            v.getId_cliente(),
            v.getTotal()
        );
    }

    // Listar todas las ventas como VentaDAO (limpio)
    public List<VentaDAO> listarTodasDAO() {
        List<Venta> ventas = ventaRepository.findAll();
        List<VentaDAO> ventasDAO = new ArrayList<>();
        for (Venta v : ventas) {
            ventasDAO.add(convertirAVentaDAO(v));
        }
        return ventasDAO;
    }

    // JOIN: Detalle de venta con nombre de producto
    public List<Object[]> obtenerDetalleConNombre(Long idVenta) {
        return ventaRepository.findDetalleConNombreProducto(idVenta);
    }
}