package com.powerfuel.powerfuelapi.repository;

import com.powerfuel.powerfuelapi.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    // Consulta JOIN nativa (SQL puro) para evitar errores de JPQL
    @Query(value = "SELECT d.id_detalle, p.nombre, d.cantidad, d.precio_unitario " +
                   "FROM detalle_venta d " +
                   "JOIN productos p ON d.id_producto = p.id_producto " +
                   "WHERE d.id_venta = :idVenta", nativeQuery = true)
    List<Object[]> findDetalleConNombreProducto(@Param("idVenta") Long idVenta);
}