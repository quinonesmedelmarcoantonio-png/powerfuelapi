package com.powerfuel.powerfuelapi.repository;

import com.powerfuel.powerfuelapi.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    // CONSULTA CON FILTRO: Productos con precio mayor al valor enviado
    @Query("SELECT p FROM Producto p WHERE p.precio > :precio")
    List<Producto> findProductosCaros(@Param("precio") Double precio);
}