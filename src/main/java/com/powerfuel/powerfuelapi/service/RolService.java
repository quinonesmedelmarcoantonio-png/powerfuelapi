package com.powerfuel.powerfuelapi.service;

import com.powerfuel.powerfuelapi.model.Rol;
import com.powerfuel.powerfuelapi.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepository;

    public List<Rol> listarTodos() {
        return rolRepository.findAll();
    }

    public Rol guardar(Rol rol) {
        return rolRepository.save(rol);
    }

    public Rol obtenerPorId(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    public void eliminar(Long id) {
        rolRepository.deleteById(id);
    }
}