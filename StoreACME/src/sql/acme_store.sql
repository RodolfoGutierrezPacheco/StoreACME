create database acme_store;
use acme_store;

create table clientes(
	id_cliente int(4) PRIMARY KEY not null AUTO_INCREMENT,
	nombre varchar(20) not null,
	ap_paterno varchar(20) not null,
	ap_materno varchar(20) not null,
	telefono int(15) not null,
	e_mail varchar(40) not null,
	RFC varchar(15) not null,
	calle varchar(20) not null,
	no int(5) not null,
	colonia varchar(20) not null,
	ciudad varchar(20) not null,
	estado varchar(20) not null
);

create table ventas(
	id_vetas int(4) PRIMARY KEY not null AUTO_INCREMENT,
	fecha date not null,
		id_cliente int(4) not null,
	subtotal decimal(7,2) not null,
	iva decimal(6,2) not null,
	total decimal(7,2) not null,
		FOREIGN KEY (id_cliente) REFERENCES clientes (id_cliente)
);

create table productos(
	id_producto int(4) PRIMARY KEY not null AUTO_INCREMENT,
	producto varchar(30) not null,
	descripcion varchar(140) not null,
	precio_compra decimal(7,2) not null,
	precio_venta decimal(7,2) not null,
	existencias int(8)
);

create table detalle_ventas(
	id_detalle_venta int(4) PRIMARY KEY not null AUTO_INCREMENT,
		id_vetas int(4) not null,
		id_producto int(4) not null,
	cantidad int(5) not null,
	tatal_producto int(7) not null,
	precio decimal(7,2) not null,
		FOREIGN KEY (id_vetas) REFERENCES ventas (id_vetas),
		FOREIGN KEY (id_producto) REFERENCES productos (id_producto)
);

create table proveedores(
	id_proveedor int(4) PRIMARY KEY not null AUTO_INCREMENT,
	nombre varchar(30) not null,
	ap_paterno varchar(30) not null,
	ap_materno varchar(30) not null,
	rfc varchar(15) not null,
	calle varchar(20) not null,
	no_calle int(5) not null,
	colonia varchar(20) not null,
	ciudad varchar(20) not null,
	estado varchar(20) not null,
	nombre_contacto varchar(70) not null,
	telefono int(15) not null,
	e_mail varchar(40) not null
);

#INSERT INTO proveedores (nombre, ap_paterno, ap_materno, rfc, calle, no_calle, colonia, ciudad, estado, nombre_contacto, telefono, e_mail) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
#UPDATE proveedores nombre=?, ap_paterno=?, ap_materno=?, rfc=?, calle=?, no_calle=?, colonia=?, ciudad=?, estado=?, nombre_contacto=?, telefono=?, e_mail=? WHERE id_proveedor=?

create table compras(
	id_compra int(4) PRIMARY KEY not null AUTO_INCREMENT,
	fecha date not null,
		id_proveedor int(4) not null,
	subtotal decimal(7,2) not null,
	iva decimal(6,2) not null,
	total decimal(7,2) not null,
		FOREIGN KEY (id_proveedor) REFERENCES proveedores (id_proveedor)
	);

create table detalle_compras(
	id_detalle_compra int(4) PRIMARY KEY not null AUTO_INCREMENT,
		id_compra int(4) not null,
		id_producto int(4) not null,
	cantidad int(5) not null,
	tatal_producto int(7) not null,
		FOREIGN KEY (id_compra) REFERENCES compras (id_compra),
		FOREIGN KEY (id_producto) REFERENCES productos (id_producto)
	);