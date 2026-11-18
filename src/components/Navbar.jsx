import React from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <nav style={{ backgroundColor: '#0A0A0A', padding: '20px', display: 'flex', justifyContent: 'space-between', alignItems: 'center', borderBottom: '2px solid #FF6B00' }}>
      <h2 style={{ color: '#FF6B00', margin: 0 }}>PowerFuel</h2>
      <div>
        <Link to="/" style={{ color: 'white', marginRight: '20px', textDecoration: 'none', fontWeight: 'bold' }}>Inicio</Link>
        <Link to="/productos" style={{ color: 'white', marginRight: '20px', textDecoration: 'none', fontWeight: 'bold' }}>Productos</Link>
        <Link to="/acerca-de" style={{ color: 'white', textDecoration: 'none', fontWeight: 'bold' }}>Acerca de</Link>
      </div>
    </nav>
  );
};

export default Navbar;