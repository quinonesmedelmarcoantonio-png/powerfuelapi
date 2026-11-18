package com.powerfuel.powerfuelapi.controller;

import com.powerfuel.powerfuelapi.model.Lote;
import com.powerfuel.powerfuelapi.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lotes")
public class LoteController {

    @Autowired
    private LoteRepository loteRepository;

    @GetMapping
    public List<Lote> listar() {
        return loteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lote> obtenerPorId(@PathVariable Long id) {
        return loteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lote crear(@RequestBody Lote lote) {
        return loteRepository.save(lote);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lote> actualizar(@PathVariable Long id, @RequestBody Lote datos) {
        return loteRepository.findById(id)
                .map(lote -> {
                    lote.setId_producto(datos.getId_producto());
                    lote.setNumero_lote(datos.getNumero_lote());
                    lote.setFecha_caducidad(datos.getFecha_caducidad());
                    lote.setCantidad_actual(datos.getCantidad_actual());
                    return ResponseEntity.ok(loteRepository.save(lote));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (loteRepository.existsById(id)) {
            loteRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}