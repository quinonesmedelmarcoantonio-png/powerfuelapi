package com.powerfuel.powerfuelapi.service;

import com.powerfuel.powerfuelapi.model.Lote;
import com.powerfuel.powerfuelapi.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoteService {

    @Autowired
    private LoteRepository loteRepository;

    public List<Lote> listarTodos() {
        return loteRepository.findAll();
    }

    public Lote guardar(Lote lote) {
        return loteRepository.save(lote);
    }

    public Lote obtenerPorId(Long id) {
        return loteRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        loteRepository.deleteById(id);
    }
}