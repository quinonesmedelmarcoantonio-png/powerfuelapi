package com.powerfuel.powerfuelapi.repository;

import com.powerfuel.powerfuelapi.model.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoteRepository extends JpaRepository<Lote, Long> {
}