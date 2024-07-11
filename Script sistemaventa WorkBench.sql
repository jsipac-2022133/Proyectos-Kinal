create database sistemaventa;

use sistemaventa;

create table if not exists usuarios(
	id int not null auto_increment,
    nombre varchar(100),
    correo varchar(100),
    pass varchar(100),
    rol varchar(100),
    primary key(id)
);

create table if not exists clientes(
	id int not null auto_increment,
    dni int not null,
    nombre varchar(50),
    telefono int,
    direccion varchar(200),
    primary key(id)
);

create table if not exists proveedor(
	id int not null auto_increment,
    ruc int,
    nombre varchar(200),
    telefono int,
    direccion varchar(200),
    primary key(id)
);

create table if not exists productos(
	id int not null auto_increment,
    codigo varchar(30),
    nombre varchar(200),
    proveedor varchar(100),
    stock int,
    precio double,
    primary key(id)
);

create table if not exists detalle(
	id int not null auto_increment,
    cod_pro varchar(50),
    cantidad int,
    precio double,
    id_venta int,
    primary key(id)
);

create table if not exists ventas(
	id int not null auto_increment,
    cliente varchar(100),
    vendedor varchar(100),
    total double,
    fecha varchar(200),
    primary key(id)
);

create table if not exists config(
	id int not null auto_increment,
    ruc int,
    nombre varchar(100),
    telefono int,
    direccion varchar(200),
    primary key(id)
);

select * from usuarios;
select * from productos;
select * from proveedor;
select * from clientes;
select * from ventas;


create view vista_historial as
select v.id, v.cliente, v.vendedor, v.total, v.fecha, u.correo from
usuarios as u
inner join
ventas as v
on u.nombre=v.cliente;

select * from vista_historial where cliente="John";











