-- ==========================================
-- BASE DE DATOS: POWERFUEL (25 TABLAS)
-- ==========================================

CREATE TABLE roles (
    id_rol SERIAL PRIMARY KEY,
    nombre VARCHAR(50) UNIQUE NOT NULL
);

-- Insertar roles por defecto
INSERT INTO roles (nombre) VALUES ('Administrador'), ('Vendedor'), ('Cliente') ON CONFLICT DO NOTHING;

CREATE TABLE usuarios (
    id_usuario SERIAL PRIMARY KEY,
    nombre_completo VARCHAR(100) NOT NULL,
    correo VARCHAR(80) UNIQUE NOT NULL,
    telefono VARCHAR(15) NOT NULL DEFAULT '0000000000',
    id_rol INT REFERENCES roles(id_rol) NOT NULL DEFAULT 1,
    contrasena_hash VARCHAR(255) NOT NULL,
    fecha_alta DATE DEFAULT CURRENT_DATE NOT NULL,
    activo BOOLEAN DEFAULT TRUE NOT NULL
);

CREATE TABLE categorias (
    id_categoria SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

-- Insertar categorías por defecto
INSERT INTO categorias (nombre) VALUES ('Proteínas'), ('Aminoácidos'), ('Pre-entrenos'), ('Vitaminas') ON CONFLICT DO NOTHING;

CREATE TABLE productos (
    id_producto SERIAL PRIMARY KEY,
    codigo_barras VARCHAR(20) UNIQUE NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    descripcion TEXT NOT NULL DEFAULT 'Sin descripción',
    id_categoria INT REFERENCES categorias(id_categoria) NOT NULL DEFAULT 1,
    precio_venta DECIMAL(10,2) NOT NULL DEFAULT 0,
    stock_minimo INT DEFAULT 5 NOT NULL
);

CREATE TABLE lotes (
    id_lote SERIAL PRIMARY KEY,
    id_producto INT REFERENCES productos(id_producto) NOT NULL,
    numero_lote VARCHAR(50) NOT NULL DEFAULT 'SIN-LOTE',
    fecha_caducidad DATE NOT NULL,
    cantidad_actual INT NOT NULL DEFAULT 0
);

CREATE TABLE clientes (
    id_cliente SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(15) NOT NULL DEFAULT '0000000000',
    correo VARCHAR(80) NOT NULL DEFAULT 'sin-correo@test.com',
    alergias_conocidas TEXT NOT NULL DEFAULT 'Ninguna',
    objetivo VARCHAR(100) NOT NULL DEFAULT 'No especificado'
);

CREATE TABLE ventas (
    id_venta SERIAL PRIMARY KEY,
    fecha_hora TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    id_usuario INT REFERENCES usuarios(id_usuario) NOT NULL,
    id_cliente INT REFERENCES clientes(id_cliente) NOT NULL,
    total DECIMAL(10,2) NOT NULL DEFAULT 0
);

CREATE TABLE detalle_venta (
    id_detalle SERIAL PRIMARY KEY,
    id_venta INT REFERENCES ventas(id_venta) NOT NULL,
    id_producto INT REFERENCES productos(id_producto) NOT NULL,
    id_lote INT REFERENCES lotes(id_lote) NOT NULL,
    cantidad INT NOT NULL DEFAULT 1,
    precio_unitario DECIMAL(10,2) NOT NULL DEFAULT 0
);

CREATE TABLE permisos (
    id_permiso SERIAL PRIMARY KEY,
    nombre VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE rol_permiso (
    id_rol INT REFERENCES roles(id_rol),
    id_permiso INT REFERENCES permisos(id_permiso),
    PRIMARY KEY (id_rol, id_permiso)
);

CREATE TABLE subcategorias (
    id_subcategoria SERIAL PRIMARY KEY,
    id_categoria INT REFERENCES categorias(id_categoria) NOT NULL DEFAULT 1,
    nombre VARCHAR(50) NOT NULL DEFAULT 'Sin nombre'
);

CREATE TABLE proveedores (
    id_proveedor SERIAL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    contacto VARCHAR(100) NOT NULL DEFAULT 'Sin contacto',
    telefono VARCHAR(15) NOT NULL DEFAULT '0000000000',
    correo VARCHAR(80) NOT NULL DEFAULT 'sin-correo@test.com',
    direccion TEXT NOT NULL DEFAULT 'Sin dirección'
);

CREATE TABLE pagos (
    id_pago SERIAL PRIMARY KEY,
    id_venta INT REFERENCES ventas(id_venta) NOT NULL,
    metodo_pago VARCHAR(30) NOT NULL DEFAULT 'Efectivo',
    monto DECIMAL(10,2) NOT NULL DEFAULT 0,
    fecha_pago TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE facturas (
    id_factura SERIAL PRIMARY KEY,
    id_venta INT REFERENCES ventas(id_venta) NOT NULL,
    rfc VARCHAR(15) NOT NULL DEFAULT 'XAXX010101000',
    razon_social VARCHAR(150) NOT NULL DEFAULT 'Sin razón social',
    folio_fiscal VARCHAR(50) NOT NULL DEFAULT 'SIN-FOLIO',
    fecha_emision TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE comisiones (
    id_comision SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuarios(id_usuario) NOT NULL,
    id_venta INT REFERENCES ventas(id_venta) NOT NULL,
    porcentaje DECIMAL(5,2) NOT NULL DEFAULT 0,
    monto_comision DECIMAL(10,2) NOT NULL DEFAULT 0,
    fecha_calculo DATE DEFAULT CURRENT_DATE NOT NULL
);

CREATE TABLE puntos_lealtad (
    id_punto SERIAL PRIMARY KEY,
    id_cliente INT REFERENCES clientes(id_cliente) NOT NULL,
    puntos_acumulados INT DEFAULT 0 NOT NULL,
    ultima_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE tickets (
    id_ticket SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuarios(id_usuario) NOT NULL,
    asunto VARCHAR(150) NOT NULL DEFAULT 'Sin asunto',
    descripcion TEXT NOT NULL DEFAULT 'Sin descripción',
    estado VARCHAR(20) DEFAULT 'Abierto' NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE respuestas_ticket (
    id_respuesta SERIAL PRIMARY KEY,
    id_ticket INT REFERENCES tickets(id_ticket) ON DELETE CASCADE NOT NULL DEFAULT 1,
    id_usuario INT REFERENCES usuarios(id_usuario) NOT NULL,
    mensaje TEXT NOT NULL DEFAULT 'Sin mensaje',
    fecha_respuesta TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE avisos (
    id_aviso SERIAL PRIMARY KEY,
    titulo VARCHAR(150) NOT NULL DEFAULT 'Sin título',
    mensaje TEXT NOT NULL DEFAULT 'Sin mensaje',
    fecha_publicacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    id_usuario_creador INT REFERENCES usuarios(id_usuario) NOT NULL
);

CREATE TABLE auditoria (
    id_auditoria SERIAL PRIMARY KEY,
    id_usuario INT REFERENCES usuarios(id_usuario) NOT NULL,
    accion VARCHAR(100) NOT NULL DEFAULT 'Sin acción',
    tabla_afectada VARCHAR(50) NOT NULL DEFAULT 'Sin tabla',
    fecha_accion TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
    detalles TEXT NOT NULL DEFAULT 'Sin detalles'
);

CREATE TABLE configuracion (
    id_config SERIAL PRIMARY KEY,
    clave VARCHAR(50) UNIQUE NOT NULL DEFAULT 'sin_clave',
    valor TEXT NOT NULL DEFAULT 'sin_valor',
    descripcion VARCHAR(200) NOT NULL DEFAULT 'Sin descripción'
);
-- ==========================================
-- 22. Movimientos de inventario (entradas/salidas de stock)
-- Guarda cada vez que entra o sale producto del almacén
-- ==========================================
CREATE TABLE movimientos_inventario (
    id_movimiento SERIAL PRIMARY KEY,
    id_producto INT REFERENCES productos(id_producto) NOT NULL,
    tipo_movimiento VARCHAR(20) NOT NULL DEFAULT 'Entrada',
    cantidad INT NOT NULL DEFAULT 0,
    motivo VARCHAR(200) NOT NULL DEFAULT 'Sin motivo',
    fecha_movimiento TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

-- ==========================================
-- 23. Envíos de pedidos (rastreo de paquetería)
-- Guarda la dirección y estado del envío de cada venta
-- ==========================================
CREATE TABLE envios (
    id_envio SERIAL PRIMARY KEY,
    id_venta INT REFERENCES ventas(id_venta) NOT NULL,
    direccion_envio TEXT NOT NULL DEFAULT 'Sin dirección',
    ciudad VARCHAR(100) NOT NULL DEFAULT 'Sin ciudad',
    estado VARCHAR(100) NOT NULL DEFAULT 'Sin estado',
    codigo_postal VARCHAR(10) NOT NULL DEFAULT '00000',
    paqueteria VARCHAR(50) NOT NULL DEFAULT 'Sin paquetería',
    numero_guia VARCHAR(50) NOT NULL DEFAULT 'SIN-GUIA',
    estado_envio VARCHAR(20) NOT NULL DEFAULT 'Preparando',
    fecha_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);

-- ==========================================
-- 24. Promociones (descuentos y ofertas)
-- Guarda promociones activas sobre productos
-- ==========================================
CREATE TABLE promociones (
    id_promocion SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL DEFAULT 'Sin nombre',
    descripcion TEXT NOT NULL DEFAULT 'Sin descripción',
    porcentaje_descuento DECIMAL(5,2) NOT NULL DEFAULT 0,
    fecha_inicio DATE DEFAULT CURRENT_DATE NOT NULL,
    fecha_fin DATE DEFAULT CURRENT_DATE NOT NULL,
    activa BOOLEAN DEFAULT TRUE NOT NULL,
    id_producto INT REFERENCES productos(id_producto) NOT NULL
);

-- ==========================================
-- 25. Reseñas (opiniones y calificaciones)
-- Guarda las reseñas que los clientes dejan a los productos
-- ==========================================
CREATE TABLE resenas (
    id_resena SERIAL PRIMARY KEY,
    id_producto INT REFERENCES productos(id_producto) NOT NULL,
    id_cliente INT REFERENCES clientes(id_cliente) NOT NULL,
    calificacion INT NOT NULL DEFAULT 5,
    comentario TEXT NOT NULL DEFAULT 'Sin comentario',
    fecha_resena TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);
