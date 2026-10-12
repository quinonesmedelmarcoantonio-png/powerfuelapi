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

CREATE TABLE servicio_social (
    id_servicio SERIAL PRIMARY KEY,
    id_cliente INT REFERENCES clientes(id_cliente) NOT NULL,
    institucion VARCHAR(150) NOT NULL DEFAULT 'Sin institución',
    horas_realizadas INT DEFAULT 0 NOT NULL,
    estado VARCHAR(20) NOT NULL DEFAULT 'Pendiente'
);

CREATE TABLE laboratorios (
    id_laboratorio SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL DEFAULT 'Sin nombre',
    ubicacion VARCHAR(150) NOT NULL DEFAULT 'Sin ubicación',
    capacidad INT NOT NULL DEFAULT 0
);

CREATE TABLE reservaciones (
    id_reserva SERIAL PRIMARY KEY,
    id_cliente INT REFERENCES clientes(id_cliente) NOT NULL,
    id_laboratorio INT REFERENCES laboratorios(id_laboratorio) NOT NULL,
    fecha DATE NOT NULL,
    hora_inicio TIME NOT NULL,
    hora_fin TIME NOT NULL,
    estado VARCHAR(20) NOT NULL DEFAULT 'Pendiente'
);

CREATE TABLE documentos (
    id_documento SERIAL PRIMARY KEY,
    id_cliente INT REFERENCES clientes(id_cliente) NOT NULL,
    tipo_documento VARCHAR(50) NOT NULL DEFAULT 'Sin tipo',
    url_archivo TEXT NOT NULL DEFAULT 'sin-url',
    fecha_subida TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);