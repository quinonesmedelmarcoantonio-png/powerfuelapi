import React, { useEffect, useState } from 'react';
import axios from 'axios';

const Productos = () => {
  const [productos, setProductos] = useState([]);
  const [cargando, setCargando] = useState(true);

  useEffect(() => {
    axios.get('http://localhost:8080/api/productos')
      .then(res => {
        setProductos(res.data);
        setCargando(false);
      })
      .catch(err => {
        console.error("Error al conectar con la API", err);
        setCargando(false);
      });
  }, []);

  if (cargando) return <h2 style={{ color: 'white', textAlign: 'center' }}>Cargando productos...</h2>;

  return (
    <div style={{ padding: '40px', color: 'white' }}>
      <h1 style={{ textAlign: 'center' }}>Catálogo de Suplementos</h1>
      <div style={{ display: 'flex', flexWrap: 'wrap', gap: '20px', justifyContent: 'center', marginTop: '30px' }}>
        {productos.length === 0 ? (
          <p>No hay productos en la base de datos.</p>
        ) : (
          productos.map(prod => (
            <div key={prod.id_producto} style={{ backgroundColor: '#1E1E1E', padding: '20px', borderRadius: '10px', width: '250px' }}>
              <h3 style={{ color: '#FF6B00' }}>{prod.nombre}</h3>
              <p>Precio: ${prod.precio}</p>
            </div>
          ))
        )}
      </div>
    </div>
  );
};

export default Productos;