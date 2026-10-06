package com.powerfuel.powerfuelapi.controller;

import com.powerfuel.powerfuelapi.dao.VentaDAO;
import com.powerfuel.powerfuelapi.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    // Endpoint con JOIN
    @GetMapping("/{idVenta}/detalle")
    public List<Object[]> getDetalleVenta(@PathVariable Long idVenta) {
        return ventaService.obtenerDetalleConNombre(idVenta);
    }

    // Endpoint con DAO (NUEVO)
    @GetMapping("/listar")
    public List<VentaDAO> listarVentasDAO() {
        return ventaService.listarTodasDAO();
    }
}