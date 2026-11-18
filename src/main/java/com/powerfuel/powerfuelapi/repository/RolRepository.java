package com.powerfuel.powerfuelapi.repository;

import com.powerfuel.powerfuelapi.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long> {
}