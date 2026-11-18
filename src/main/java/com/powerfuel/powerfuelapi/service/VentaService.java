package com.powerfuel.powerfuelapi.service;

import com.powerfuel.powerfuelapi.dao.VentaDAO;
import com.powerfuel.powerfuelapi.model.Venta;
import com.powerfuel.powerfuelapi.model.DetalleVenta;
import com.powerfuel.powerfuelapi.repository.VentaRepository;
import com.powerfuel.powerfuelapi.repository.ProductoRepository;
import com.powerfuel.powerfuelapi.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private LoteRepository loteRepository;

    // 1. MÉTODOS VIEJOS
    public List<Object[]> obtenerDetalleConNombre(Long idVenta) {
        return ventaRepository.findDetalleConNombreProducto(idVenta);
    }

    public List<VentaDAO> listarTodasDAO() {
        List<Venta> ventas = ventaRepository.findAll();
        List<VentaDAO> ventasDAO = new ArrayList<>();
        for (Venta v : ventas) {
            ventasDAO.add(new VentaDAO(
                v.getId_venta(),
                v.getFecha_hora(),
                v.getId_usuario(),
                v.getId_cliente(),
                v.getTotal()
            ));
        }
        return ventasDAO;
    }

    // 2. REGLA DE NEGOCIO
    public Venta registrarVenta(Venta venta, List<DetalleVenta> detalles) {
        BigDecimal total = BigDecimal.ZERO;

        for (DetalleVenta detalle : detalles) {
            if (!productoRepository.existsById(detalle.getId_producto())) {
                throw new RuntimeException("El producto con ID " + detalle.getId_producto() + " no existe.");
            }
            
            BigDecimal subtotal = BigDecimal.valueOf(detalle.getCantidad()).multiply(detalle.getPrecio_unitario());
            total = total.add(subtotal);
        }
        venta.setTotal(total);
        return ventaRepository.save(venta);
    }
}