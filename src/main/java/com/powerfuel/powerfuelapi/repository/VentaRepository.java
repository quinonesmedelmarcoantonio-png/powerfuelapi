package com.powerfuel.powerfuelapi.repository;

import com.powerfuel.powerfuelapi.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Long> {

    // CONSULTA JOIN: Obtener el detalle de una venta con el nombre del producto
    @Query("SELECT d, p.nombre FROM DetalleVenta d JOIN Producto p ON d.id_producto = p.id_producto WHERE d.id_venta = :idVenta")
    List<Object[]> findDetalleConNombreProducto(@Param("idVenta") Long idVenta);
}