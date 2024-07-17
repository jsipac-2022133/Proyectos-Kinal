/*
	Programador:	James Brian Sipac Sipac
    Carnet:			2022133
    Creación:		28/03/2023
    Modificación	28/03/2023, 09/04/2023, 25/05/2023
*/

drop database if exists DBTonysKinal2023;
create database DBTonysKinal2023;
use DBTonysKinal2023;

create table Empresas(
	codigoEmpresa int not null auto_increment,
    nombreEmpresa varchar(150) not null,
    direccion varchar(150) not null,
    telefono varchar(8) not null,
    primary key PK_codigoEmpresa(codigoEmpresa)
);

create table TipoEmpleado(
	codigoTipoEmpleado int not null auto_increment,
    descripcion varchar(150) not null,
    primary key PK_codigoTipoEmpleado(codigoTipoEmpleado)
);

create table TipoPlato(
	codigoTipoPlato int not null auto_increment,
    descripcionTipo varchar(100) not null,
    primary key PK_codigoTipoPlato(codigoTipoPlato)
);

create table Productos(
	codigoProducto int not null auto_increment,
    nombreProducto varchar(150) not null,
    cantidadProducto int not null,
    primary key PK_codigoProductos(codigoProducto)
);

create table Empleados(
	codigoEmpleado int not null auto_increment,
    numeroEmpleado int not null,
    apellidosEmpleado varchar(150) not null,
    nombresEmpleado varchar(150) not null,
    direccionEmpleado varchar(150) not null,
    telefonoContacto varchar(8) not null,
    gradoCocinero varchar(50),
    codigoTipoEmpleado int not null,
    primary key PK_codigoEmpleado(codigoEmpleado),
    constraint FK_Empleados_TipoEmpleado foreign key (codigoTipoEmpleado) 
		references TipoEmpleado(codigoTipoEmpleado) 
);

create table Servicios(
	codigoServicio int not null auto_increment,
    fechaServicio date not null,
    tipoServicio varchar(150) not null,
    horaServicio time not null,
    lugarServicio varchar(150) not null,
    telefonoContacto varchar(8),
    codigoEmpresa int not null,
    primary key PK_codigoServicio(codigoServicio),
    constraint FK_Servicios_Empresas foreign key(codigoEmpresa)
		references Empresas(codigoEmpresa)
);

create table Presupuesto(
	codigoPresupuesto int not null auto_increment,
    fechaSolicitud date not null,
    cantidadPresupuesto decimal(10,2) not null,
    codigoEmpresa int not null,
    primary key PK_codigoPresupuesto(codigoPresupuesto),
    constraint FK_Presupuesto_Empresas foreign key(codigoEmpresa)
		references Empresas(codigoEmpresa) 
);

create table Platos(
	codigoPlato int not null auto_increment,
    cantidad int not null,
    nombrePlato varchar(50) not null,
    descripcionPlato varchar(150) not null,
    precioPlato decimal(10,2) not null,
    codigoTipoPlato int not null,
    primary key PK_codigoPlato(codigoPlato),
    constraint FK_Platos_TipoPlato foreign key(codigoTipoPlato)
		references TipoPlato(codigoTipoPlato)
);

create table Productos_has_Platos(
	Productos_codigoProducto int not null,
    codigoPlato int not null,
    codigoProducto int not null,
    primary key PK_Productos_codigoProducto(Productos_codigoProducto),
    constraint FK_Productos_has_Platos_Plato foreign key(codigoPlato)
		references Platos(codigoPlato),
	constraint FK_Productos_has_Platos_Productos foreign key(codigoProducto)
		references Productos(codigoProducto)
);

create table Servicios_has_Platos(
	Servicios_codigoProducto int not null,
    codigoPlato int not null,
    codigoServicio int not null,
    primary key PK_Servicios_codigoServicio(Servicios_codigoProducto),
	constraint FK_Servicios_has_Platos_Servicios foreign key(codigoServicio)
		references Servicios(codigoServicio),
	constraint FK_Servicios_has_Platos_Platos foreign key(codigoPlato)
		references Platos(codigoPlato)
);

create table Servicios_has_Empleados(
	Servicios_codigoServicio int not null,
    codigoServicio int not null,
    codigoEmpleado int not null,
    fechaEvento date not null,
    horaEvento time not null,
    lugarEvento varchar(150) not null,
    primary key PK_Servicios_codigoServicio(Servicios_codigoServicio),
	constraint FK_Servicios_has_Empleados_Servicios foreign key(codigoServicio)
		references Servicios(codigoServicio),
	constraint FK_Servicios_has_Empleados_Empleados foreign key(codigoEmpleado)
		references Empleados(codigoEmpleado)
);


create table Usuario(
	codigoUsuario int not null auto_increment,
    nombreUsuario varchar(100) not null,
    apellidoUsuario varchar(100) not null,
    usuarioLogin varchar(50) not null,
    contrasena varchar(50) not null,
    primary key PK_codigoUsuario(codigoUsuario)
);


create table Login(
	usuarioMaster varchar(50) not null,
    passwordLogin varchar(50) not null,
    primary key PK_usuarioMaster(usuarioMaster)
);

delimiter //
	create procedure sp_AgregarUsuario(in nombreUsuario varchar(100), in apellidoUsuario varchar(100),
		in usuarioLogin varchar(50), in contrasena varchar(50))
	begin
		insert into Usuario(`codigoUsuario`, `nombreUsuario`, `apellidoUsuario`, `usuarioLogin`, `contrasena`)
			values (`codigoUsuario`, `nombreUsuario`, `apellidoUsuario`, `usuarioLogin`, `contrasena`);
    end//
delimiter ;


delimiter //
	create procedure sp_ListarUsuarios()
    begin
		select 
			U.codigoUsuario, 
            U.nombreUsuario, 
            U.apellidoUsuario, 
            U.usuarioLogin, 
            U.contrasena        
        from Usuario U;
    end//
delimiter ;


call sp_AgregarUsuario('James', 'Sipac', 'jsipac', '2022133');
call sp_ListarUsuarios();



-- ---------------------------------------------------------------------------------------
-- ---------------------------------------PROCEDIMIENTOS ALMACENADOS ---------------------
-- ---------------------------------------------------------------------------------------


-- ---------------------------------------EMPRESAS --------------------

-- ------------------------------AGREGAR EMPRESA ---------------------

delimiter //
	create procedure sp_AgregarEmpresa(in nombreEmpresa varchar(150), in direccion varchar(150), 
		in telefono varchar(8))
    begin
		insert into Empresas(nombreEmpresa, direccion, telefono)
			values(nombreEmpresa, direccion, telefono);
    end//
delimiter ;

call sp_AgregarEmpresa('Agencias Way', '7a calle zona 8 Guatemala', '45036201');
call sp_AgregarEmpresa('Pizza Hut', '1ra calle zona 2 Guatemala', '45202695');
call sp_AgregarEmpresa('Tigo', '8a calle zona 8 Guatemala', '65023602');
call sp_AgregarEmpresa('Claro', '7ra calle zona 9 Guatemala', '50360265');
call sp_AgregarEmpresa('Pepsi', '5a calle zona 4 Guatemala', '45210362');
call sp_AgregarEmpresa('Coca-Cola', '2a calle zona 7 Guatemala', '45210369');
call sp_AgregarEmpresa('Kinal', '6ta calle zona 7 Guatemala', '12365021');
call sp_AgregarEmpresa('Helados Sarita', '5ta calle zona 12 Guatemala', '12360215');
call sp_AgregarEmpresa('Masesa', '8a calle zona 13 Chimaltenango', '45023697');
call sp_AgregarEmpresa('Malher', '6ta calle zona 7 Guatemala', '12365021');
call sp_AgregarEmpresa('Azúcar Caña Real', '4ta calle zona 11 Guatemala', '45023619');
call sp_AgregarEmpresa('Pollo Campero', '1ra calle zona 2 Santa Rosa', '12365201');

-- ---------------------------LISTAR EMPRESAS ----------------
delimiter //
	create procedure sp_ListarEmpresas()
    begin
		select 
			E.codigoEmpresa,
			E.nombreEmpresa,
            E.direccion,
			E.telefono
            from Empresas E;
    end//
delimiter ;

call sp_ListarEmpresas();



-- -----------------------------BUSCAR EMPRESA ---------------
delimiter //
	create procedure sp_BuscarEmpresa(in codEmpresa int)
    begin
		select 
			E.codigoEmpresa,
			E.nombreEmpresa,
            E.direccion,
			E.telefono
            from Empresas E
				where E.codigoEmpresa=codEmpresa;
    end//
delimiter ;

call sp_BuscarEmpresa(1);


-- ------------------------EDITAR EMPRESA ------------
delimiter //
	create procedure sp_EditarEmpresa(in codEmpresa int, in nomEmpresa varchar(150), in dir varchar(150), in tel varchar(8))
    begin
		update Empresas	E
			set 
            E.nombreEmpresa=nomEmpresa,
            E.direccion=dir,
            E.telefono=tel
				where E.codigoEmpresa=codEmpresa;
    end//
delimiter ;





-- ---------------------------ELIMINAR EMPRESA -----------------------------
delimiter //
	create procedure sp_EliminarEmpresa(in codEmpresa int)
    begin
		delete from Empresas 
			where codigoEmpresa=codEmpresa;
    end//
delimiter ;





-- -----------------------------------------PRESUPUESTO -----------------------------------

-- ------------------AGREGAR PRESUPUESTO---------------
delimiter //
	create procedure sp_AgregarPresupuesto(in fechaSolicitud date, in cantidadPresupuesto decimal(10,2), 
		in codigoEmpresa int)
    begin
		insert into Presupuesto(fechaSolicitud, cantidadPresupuesto, codigoEmpresa)
			values(fechaSolicitud, cantidadPresupuesto, codigoEmpresa);
    end//
delimiter ;

call sp_AgregarPresupuesto('2023-05-05', 3000, 2);
call sp_AgregarPresupuesto('2023-07-01', 5000, 2);
call sp_AgregarPresupuesto('2023-07-01', 7000, 4);
call sp_AgregarPresupuesto('2023-06-02', 5000, 3);
call sp_AgregarPresupuesto('2023-07-11', 6500, 4);
call sp_AgregarPresupuesto('2023-11-07', 4500, 6);
call sp_AgregarPresupuesto('2023-06-12', 7500, 5);



-- ------------------LISTAR PRESUPUESTOS
delimiter //
	create procedure sp_ListarPresupuestos()
    begin
		select 
			P.codigoPresupuesto,
            P.fechaSolicitud,
            P.cantidadPresupuesto,
            P.codigoEmpresa
            from Presupuesto P;
    end//
delimiter ;

call sp_ListarPresupuestos();


-- -----------------BUSCAR PRESUPUESTO
delimiter //
	create procedure sp_BuscarPresupuesto(in codPresupuesto int)
    begin
		select 
			P.codigoPresupuesto,
            P.fechaSolicitud,
            P.cantidadPresupuesto,
            P.codigoEmpresa
            from Presupuesto P
				where P.codigoPresupuesto=codPresupuesto;    
	end//
delimiter ;

call sp_BuscarPresupuesto(2);


-- ---------------EDITAR PRESUPUESTO
delimiter //
	create procedure sp_EditarPresupuesto(in codPresupuesto int, in fechaSol date, 
		in cantPresupuesto decimal(10,2))
	begin
		update Presupuesto P
			set
				P.fechaSolicitud=fechaSol,
                P.cantidadPresupuesto=cantPresupuesto
					where P.codigoPresupuesto=codPresupuesto;
    end//
delimiter ;

call sp_EditarPresupuesto(2, '2023-12-12', 4000);


-- -----------------------ELIMINAR PRESUPUESTO
delimiter //
	create procedure sp_EliminarPresupuesto(in codPresupuesto int)
    begin
		delete from Presupuesto 
			where codigoPresupuesto=codPresupuesto;
    end//
delimiter ;

call sp_EliminarPresupuesto(1);



-- -------------------------------------------SERVICIOS -------------------------

-- -------------------------------AGREGAR SERCICIO
delimiter //
	create procedure sp_AgregarServicio(in fechaServicio date, in tipoServicio varchar(150),
		in horaServicio time, in lugarServicio varchar(150), in telefonoContacto varchar(8),
        in codigoEmpresa int)
	begin
		insert into Servicios(fechaServicio, tipoServicio, horaServicio, lugarServicio,
        telefonoContacto, codigoEmpresa)
        values (fechaServicio, tipoServicio, horaServicio, lugarServicio,
        telefonoContacto, codigoEmpresa);
    end//
delimiter ;

call sp_AgregarServicio('2023-05-05', 'Boda', '12:00:00', 'Chimaltenango', '23650182', 2);
call sp_AgregarServicio('2023-07-15', 'Boda', '14:00:00', 'Santa Rosa', '55203652', 2);
call sp_AgregarServicio('2023-08-09', 'Graduación', '10:30:00', 'Santa Chimaltenango', '32156202', 7);
call sp_AgregarServicio('2023-05-01', 'Cumpleaños', '13:00:00', 'Petén', '23026501', 4);
call sp_AgregarServicio('2023-09-12', 'Aniversario', '17:45:00', 'Tecpán', '12023978', 3);
call sp_AgregarServicio('2023-12-11', 'Boda', '18:30:00', 'Quiché', '12032687', 5);
call sp_AgregarServicio('2023-07-10', 'Cumpleaños', '20:00:00', 'Guatemala', '12786508', 6);
call sp_AgregarServicio('2023-12-12', 'Graduación', '15:00:00', 'Sacatepequez', '12036581', 5);


-- -------------------------------LISTAR SERVICIOS
delimiter //
	create procedure sp_ListarServicios()
    begin
		select 
			S.codigoServicio,
            S.fechaServicio,
            S.tipoServicio,
            S.horaServicio,
            S.lugarServicio,
            S.telefonoContacto,
            S.codigoEmpresa
            from Servicios S;
    end//
delimiter ;

call sp_ListarServicios();


-- ------------------------BUSCAR SERVICIO --------------------------------
delimiter //
	create procedure sp_BuscarServicio(in codServicio int)
    begin
		select 
			S.codigoServicio,
            S.fechaServicio,
            S.tipoServicio,
            S.horaServicio,
            S.lugarServicio,
            S.telefonoContacto,
            S.codigoEmpresa
            from Servicios S
				where S.codigoServicio=codServicio;
    end//
delimiter ;

call sp_BuscarServicio(1);


-- ------------------------------EDITAR SERVICIO -----------------------------
delimiter //
	create procedure sp_EditarServicio(in codServicio int, in fechaServi date, in tipoServi varchar(150),
		in horaServi time, in lugarServi varchar(150), in telContacto varchar(8))
	begin
		update Servicios S
			set
				S.fechaServicio=fechaServi,
                S.tipoServicio=tipoServi,
                S.horaServicio=horaServi,
                S.lugarServicio=lugarServi,
                S.telefonoContacto=telContacto
					where codigoServicio=codServicio;
    end//
delimiter ;

call sp_EditarServicio(1,'2023-05-05', 'Graduación', '08:00:00', 'Guatemala', '30213701');


-- ----------------------------ELIMINAR SERVICIO-----------------------------------
delimiter //
	create procedure sp_EliminarServicio(in codServicio int)
    begin
		delete from Servicios
			where codigoServicio=codServicio;
    end//
delimiter ;

call sp_EliminarServicio(1);


-- -------------------------------TIPO EMPLEADO -------------------------

-- -------------------------------AGREGAR TIPOEMPLEADO
delimiter //
	create procedure sp_AgregarTipoEmpleado(in descripcion varchar(150))
    begin
		insert into TipoEmpleado(descripcion)
			values(descripcion);
    end//
delimiter ;

call sp_AgregarTipoEmpleado('Mesero');
call sp_AgregarTipoEmpleado('Lavaplatos');
call sp_AgregarTipoEmpleado('Chef');
call sp_AgregarTipoEmpleado('Repartidor');
call sp_AgregarTipoEmpleado('Recepcionista');
call sp_AgregarTipoEmpleado('Administrador');
call sp_AgregarTipoEmpleado('Gastrónomo');
call sp_AgregarTipoEmpleado('Ayudante de camarero');
call sp_AgregarTipoEmpleado('Bartender');


-- ------------------------------LISTAR TIPOEMPLEADO
delimiter //
	create procedure sp_ListarTipoEmpleados()
    begin
		select 
			T.codigoTipoEmpleado,
            T.descripcion
            from TipoEmpleado T;
    end//
delimiter ;

call sp_ListarTipoEmpleados();


-- ---------------------------------BUSCAR TIPOEMPLEADO -----------------------------
delimiter //
	create procedure sp_BuscarTipoEmpleado(in codTipoEmpleado int)
    begin
		select
			T.codigoTipoEmpleado,
            T.descripcion
            from TipoEmpleado T
				where T.codigoTipoEmpleado=codTipoEmpleado;
    end//
delimiter ;

call sp_BuscarTipoEmpleado(2);


-- --------------------------EDITAR TIPOEMPLEADO------------------------------
delimiter //
	create procedure sp_EditarTipoEmpleado(in codTipoEmpleado int, in descrip varchar(150))
    begin
		update TipoEmpleado T
			set
            T.descripcion=descrip
				where T.codigoTipoEmpleado=codTipoEmpleado;
    end//
delimiter ;

call sp_EditarTipoEmpleado(2, 'Chef');


-- ------------------------ELIMINAR TIPOEMPLEADO-----------------------
delimiter //
	create procedure sp_EliminarTipoEmpleado(in codTipoEmpleado int)
    begin
		delete from TipoEmpleado
			where codigoTipoEmpleado=codTipoEmpleado;
    end//
delimiter ;




-- ------------------------EMPLEADOS ---------------------

-- ----------------------AGREGAR EMPLEADO
delimiter //
	create procedure sp_AgregarEmpeado(in numeroEmpleado int, apellidosEmpleado varchar(150),
		in nombresEmpleado varchar(150), in direccionEmpleado varchar(150), in telefonoContacto varchar(8),
        in gradoCocinero varchar(50), in codigoTipoEmpleado int)
	begin
		insert into Empleados(numeroEmpleado, apellidosEmpleado, nombresEmpleado, direccionEmpleado,
			telefonoContacto, gradoCocinero, codigoTipoEmpleado)
		values(numeroEmpleado, apellidosEmpleado, nombresEmpleado, direccionEmpleado,
			telefonoContacto, gradoCocinero, codigoTipoEmpleado);
    end//
delimiter ;

call sp_AgregarEmpeado(7, 'Estrada Zelada', 'Christian Ricardo', '5ta calle zona 2 Guatemala', '23650125',
	'Chef de partida', 1);
call sp_AgregarEmpeado(9, 'Reyes Orón', 'Luis Armando', '6ta calle zona 1 Guatemala', '20310259',
	'Sous chef', 2);
    call sp_AgregarEmpeado(7, 'Paredes Alvarado', 'Juan Armando', '5ta calle zona 7 Guatemala', '45962036',
	'Sous chef', 3);
    call sp_AgregarEmpeado(1, 'Churrunel Vaquín', 'Luis Diego', '1ra calle zona 6 Guatemala', '50623502',
	'Chef de partida', 4);
call sp_AgregarEmpeado(10, 'Coronado Zelada', 'Juan Fernando', '6ta calle zona 1 Guatemala', '15203265',
	'Sous chef', 1);
    call sp_AgregarEmpeado(15, 'Martinez Calel', 'Edy Santiago', '7a calle zona 8 Guatemala', '33410570',
	'Chef de partida', 9);
    call sp_AgregarEmpeado(8, 'Reyes Orón', 'Chirstian Fernando', '4ta calle zona 12 Guatemala', '12035620',
	'Sous Chef', 6);
    call sp_AgregarEmpeado(13, 'Tzay Magzul', 'Javier Antonio', '5ta calle zona 9 Guatemala', '36202135',
	'Sous Chef', 8);
    call sp_AgregarEmpeado(22, 'Aroche Coronado', 'Carlos Ezequiel', '4ta calle zona 9 Guatemala', '45102102',
	'Chef de partida', 7);
    call sp_AgregarEmpeado(16, 'Batres Pineda', 'Pablo Armando', '2da calle zona 1 Guatemala', '95021036',
	'Sous Chef', 3);

-- ------------------------------LISTAR EMPLEADOS ------------------------------------
delimiter //
	create procedure sp_ListarEmpleados()
    begin
		select 
			E.codigoEmpleado,
            E.numeroEmpleado,
            E.apellidosEmpleado,
            E.nombresEmpleado,
            E.direccionEmpleado,
            E.telefonoContacto,
            E.gradoCocinero,
            E.codigoTipoEmpleado
            from Empleados E;
    end//
delimiter ;

call sp_ListarEmpleados();


-- ---------------------------------BUSCAR EMPLEADO ------------------------------
delimiter //
	create procedure sp_BuscarEmpleados(in codEmpleado int)
    begin
		select 
			E.codigoEmpleado,
            E.numeroEmpleado,
            E.apellidosEmpleado,
            E.nombresEmpleado,
            E.direccionEmpleado,
            E.telefonoContacto,
            E.gradoCocinero,
            E.codigoTipoEmpleado
            from Empleados E
				where codigoEmpleado=codEmpleado;
    end//
delimiter ;

call sp_BuscarEmpleados(2);


-- ---------------------------------EDITAR EMPLEADO ---------------------------------------
delimiter //
	create procedure sp_EditarEmpleado(in codEmpleado int, in numEmpleado int, apellidosEmple varchar(150),
		in nombresEmple varchar(150), in direccionEmple varchar(150), in telContacto varchar(8),
        in gradoCoci varchar(50))
	begin
		update Empleados E
			set
				E.numeroEmpleado=numEmpleado,
                E.apellidosEmpleado=apellidosEmple,
                E.nombresEmpleado=nombresEmple,
                E.direccionEmpleado=direccionEmple,
                E.telefonoContacto=telContacto,
                E.gradoCocinero=gradoCoci
					where E.codigoEmpleado=codEmpleado;
				
    end//
delimiter ;

call sp_EditarEmpleado(2, 9, 'Reyes Orón', 'Luis Fernando', '6ta calle zona 1 Santa Rosa', '12369502',
	'Sous chef');


-- -----------------------------ELIMINAR EMPLEADO-----------------------------
delimiter //
	create procedure sp_EliminarEmpleado(in codEmpleado int)
    begin
		delete from Empleados 
			where codigoEmpleado=codEmpleado;
    end//
delimiter ;

call sp_EliminarEmpleado(2);
call sp_ListarEmpleados();

-- --------------------------------------TIPO PLATO-------------------------------

-- -----------------------------------AGREGAR TIPOPLATO--------------------------
delimiter //
	create procedure sp_AgregarTipoPlato(in descripcionTipo varchar(100))
    begin
		insert into TipoPlato(descripcionTipo)
			values (descripcionTipo);
    end//
delimiter ;

call sp_AgregarTipoPlato('Comida Italiana');
call sp_AgregarTipoPlato('Comida Vegetariana');
call sp_AgregarTipoPlato('Comida Oriental');
call sp_AgregarTipoPlato('Comida Mexicana');
call sp_AgregarTipoPlato('Comida Peruana');
call sp_AgregarTipoPlato('Comida Coreana');
call sp_AgregarTipoPlato('Comida China');
call sp_AgregarTipoPlato('Comida Japonesa');


-- ---------------------------------LISTAR TIPOPLATOS-----------------------
delimiter //
	create procedure sp_ListarTipoPlatos()
	begin
		select
			T.codigoTipoPlato,
            T.descripcionTipo
            from TipoPlato T;
    end//
delimiter ;

 call sp_ListarTipoPlatos();


-- ----------------------BUSCAR TIPOPLATO------------------------------
delimiter //
	create procedure sp_BuscarTipoPlato(in codTipoPlato int)
    begin
		select
			T.codigoTipoPlato,
            T.descripcionTipo
            from TipoPlato T
				where T.codigoTipoPlato=codTipoPlato;
    end//
delimiter ;
 
call sp_BuscarTipoPlato(2);


-- --------------------EDITAR TIPOPLATO---------------------------
delimiter //
	create procedure sp_EditarTipoPlato(in codTipoPlato int, in descTipo varchar(100))
    begin
		update TipoPlato T
			set 
            T.descripcionTipo=descTipo
            where T.codigoTipoPlato=codTipoPlato;
    end//
delimiter ;




-- ----------------------------ELIMINAR TIPOPLATO------------------
delimiter //
	create procedure sp_EliminarTipoPlato(in codTipoPlato int)
    begin
		delete from TipoPlato
			where codigoTipoPlato=codTipoPlato;
    end//
delimiter ;



-- -----------------------------PLATOS-------------------------------

-- -------------------------AGREGAR PLATO---------------------------
delimiter //
	create procedure sp_AgregarPlato(in cantidad int, in nombrePlato varchar(50), 
		in descripcionPlato varchar(150), in precioPlato decimal(10,2), in codigoTipoPlato int)
	begin
		insert into Platos(cantidad, nombrePlato, descripcionPlato, precioPlato, codigoTipoPlato)
			values (cantidad, nombrePlato, descripcionPlato, precioPlato, codigoTipoPlato);
    end//
delimiter ;

call sp_AgregarPlato(50, 'Pizza', '5 carnes', 30, 1);
call sp_AgregarPlato(30, 'Spaghetti', 'Simple', 35, 3);
call sp_AgregarPlato(25, 'Hamburguesa', 'Mixta', 40, 4);
call sp_AgregarPlato(11, 'Calzone', 'Completa', 20, 6);
call sp_AgregarPlato(37, 'Sandwich', 'Simple', 15, 5);
call sp_AgregarPlato(24, 'Hot Dog', 'Mixto', 8, 7);
call sp_AgregarPlato(26, 'Dona', 'Simple', 15, 8);
call sp_AgregarPlato(19, 'Pay', 'Simple', 15, 3);
call sp_AgregarPlato(27, 'Empanadas', 'PIña', 5, 4);

-- ---------------------------------LISTAR PLATOS----------------------------
delimiter //
	create procedure sp_ListarPlatos()
    begin
		select 
			P.codigoPlato,
            P.cantidad,
            P.nombrePlato,
            P.descripcionPlato,
            P.precioPlato,
            P.codigoTipoPlato
            from Platos P;
    end//
delimiter ;

call sp_ListarPlatos();


-- ---------------------------BUSCAR PLATO----------------------
delimiter //
	create procedure sp_BuscarPlato(in codPlato int)
    begin
		select 
			P.codigoPlato,
            P.cantidad,
            P.nombrePlato,
            P.descripcionPlato,
            P.precioPlato,
            P.codigoTipoPlato
            from Platos P
				where P.codigoPlato=codPlato;	
    end//
delimiter ; 

call sp_BuscarPlato(2);


-- ------------------------EDITAR PLATO------------------------------
delimiter //
	create procedure sp_EditarPlato(in codPlato int, in cant int, in nomPlato varchar(50), 
		in descPlato varchar(150), in prePlato decimal(10,2))
	begin
		update Platos P
			set
				P.cantidad=cant,
                P.nombrePlato=nomPlato,
                P.descripcionPlato=descPlato,
                P.precioPlato=prePlato
					where P.codigoPlato=codPlato;
    end//
delimiter ;

call sp_EditarPlato(1, 3, 'Pizza', '5 carnes', 35);

-- ---------------------------ELIMINAR PLATO ---------------------
delimiter //
	create procedure sp_EliminarPlato(in codPlato int)
    begin	
		delete from Platos
			where codigoPlato=codPlato;
    end//
delimiter ;

call sp_EliminarPlato(2);


-- ---------------------------------------------PRODUCTOS --------------------------------------

-- --------------------------------AGREGAR PRODUCTO ----------------------------
delimiter //
	create procedure sp_AgregarProducto(in nombreProducto varchar(150), in cantidadProducto int)
	begin
		insert into Productos(nombreProducto, cantidadProducto)
			values (nombreProducto, cantidadProducto);
    end//
delimiter ;

call sp_AgregarProducto('Tomate', 20);
call sp_AgregarProducto('Queso', 15);
call sp_AgregarProducto('Piña', 9);
call sp_AgregarProducto('Zanahoria', 8);
call sp_AgregarProducto('Manzana', 12);
call sp_AgregarProducto('Cebolla', 5);
call sp_AgregarProducto('Banano', 13);
call sp_AgregarProducto('Pepino', 10);
call sp_AgregarProducto('Lechuga', 5);
call sp_AgregarProducto('Melón', 2);

-- -----------------------------LISTAR PRODUCTOS--------------------------
delimiter //
	create procedure sp_ListarProductos()
    begin
		select 
			P.codigoProducto,
            P.nombreProducto,
            P.cantidadProducto
            from Productos P;
    end//
delimiter ;

call sp_ListarProductos();


-- -------------------BUSCAR PRODUCTO----------------------
delimiter //
	create procedure sp_BuscarProducto(in codProducto int)
    begin
		select 
			P.codigoProducto,
            P.nombreProducto,
            P.cantidadProducto
            from Productos P
            where P.codigoProducto=codProducto;
    end//
delimiter ;

call sp_BuscarProducto(2);


-- --------------------EDITAR PRODUCTO---------------------------
delimiter //
	create procedure sp_EditarProducto(in codProducto int, in nomProducto varchar(150), 
		in cant int)
	begin
		update Productos P
			set
            P.nombreProducto=nomProducto,
            P.cantidadProducto=cant
            where P.codigoProducto=codProducto;
    end//
delimiter ;

call sp_EditarProducto(2, 'Cubiertos', 2);


-- ----------------------------ELIMINAR PRODUCTO----------------
delimiter //
	create procedure sp_EliminarProducto(in codProducto int)
    begin
		delete from Productos
			where codigoProducto=codProducto;
	end//
delimiter ;



-- ---------------------------------SERVICIOS_HAS_EMPLEADOS----------------------

-- ------------------------------AGREGAR SERVICIOS_HAS_EMPLEADOS---------------------
delimiter //
	create procedure sp_AgregarServicios_Has_Empleados(in Servicios_codigoServicio int, 
		in codigoServicio int, in codigoEmpleado int, in fechaEvento date, in horaEvento time, 
        in lugarEvento varchar(150))
	begin
		insert into Servicios_Has_Empleados(Servicios_codigoServicio, codigoServicio, codigoEmpleado, 
			fechaEvento, horaEvento, lugarEvento)
		values (Servicios_codigoServicio, codigoServicio, codigoEmpleado, fechaEvento, 
			horaEvento, lugarEvento);			
    end//
delimiter ;

call sp_AgregarServicios_Has_Empleados(1,2, 1, '2023-02-06', '12:00:00', 'Santa Rosa');
call sp_AgregarServicios_Has_Empleados(2,7, 8, '2023-07-24', '15:30:00', 'Guatemala');
call sp_AgregarServicios_Has_Empleados(3,2, 4, '2023-09-24', '14:45:00', 'Chimaltenango');
call sp_AgregarServicios_Has_Empleados(4,6, 3, '2023-12-13', '19:00:00', 'Petén');
call sp_AgregarServicios_Has_Empleados(5,3, 7, '2023-11-20', '20:30:00', 'Zaragoza');
call sp_AgregarServicios_Has_Empleados(6,4, 4, '2023-10-19', '18:00:00', 'Chiquimula');
call sp_AgregarServicios_Has_Empleados(7,5, 6, '2023-05-17', '11:45:00', 'Guatemala');


-- --------------------------------LISTAR Servicios_has_Empleados-----------------------
delimiter //
	create procedure sp_ListarServicios_has_Empleados()
    begin
		select 
			S.Servicios_codigoServicio, 
            S.codigoServicio, 
            S.codigoEmpleado, 
            S.fechaEvento, 
            S.horaEvento, 
            S.lugarEvento
            from Servicios_has_Empleados S;
    end//
delimiter ;

call sp_ListarServicios_has_Empleados();

-- ---------------------------BUSCAR Servicios_has_Empleados -----------------------
delimiter //
	create procedure sp_BuscarServicios_has_Empleados(in Servicios_codServicio int)
    begin
		select 
			S.Servicios_codigoServicio, 
            S.codigoServicio, 
            S.codigoEmpleado, 
            S.fechaEvento, 
            S.horaEvento, 
            S.lugarEvento
            from Servicios_has_Empleados S
				where S.Servicios_codigoServicio=Servicios_codServicio;
    end//
delimiter ;

call sp_BuscarServicios_has_Empleados(2);


-- ------------------------------------EDITAR Servicios_has_Empleados-----------------------
delimiter //
	create procedure sp_EditarServicios_has_Empleados(in Servicios_codServicio int, 
		in fechaEvent date, in horaEvent time, in lugarEvent varchar(150))
	begin
		update Servicios_has_Empleados S
			set
            S.fechaEvento=fechaEvent,
            S.horaEvento=horaEvent,
            S.lugarEvento=lugarEvent
            where S.Servicios_codigoServicio=Servicios_codServicio;
    end//
delimiter ;

call sp_EditarServicios_has_Empleados(2, '2023-07-24', '10:00:00', 'Chimaltenango');


-- ------------------------------------ELIMINAR Servicios_has_Empleados----------------
delimiter //
	create procedure sp_EliminarServicios_has_Empleados(in Servicios_codServicio int)
    begin
		delete from Servicios_has_Empleados
			where Servicios_codigoServicio=Servicios_codServicio;
    end//
delimiter ;

call sp_EliminarServicios_has_Empleados(2);


-- ------------------------------------Servicios_has_Platos----------------------------

-- --------------------------AGREGAR Servicios_has_Platos----------------------
delimiter //
	create procedure sp_AgregarServicios_has_Platos(in Servicios_codigoProducto int, 
		in codigoPlato int, in codigoServicio int)
	begin
		insert into Servicios_has_Platos(Servicios_codigoProducto, codigoPlato, codigoServicio)
			values (Servicios_codigoProducto, codigoPlato, codigoServicio);
    end//
delimiter ;

call sp_AgregarServicios_has_Platos(1, 1, 2);
call sp_AgregarServicios_has_Platos(2, 7, 6);
call sp_AgregarServicios_has_Platos(3, 6, 4);
call sp_AgregarServicios_has_Platos(4, 5, 6);
call sp_AgregarServicios_has_Platos(5, 3, 2);
call sp_AgregarServicios_has_Platos(6, 1, 4);
call sp_AgregarServicios_has_Platos(7, 7, 7);
call sp_AgregarServicios_has_Platos(8, 6, 2);
call sp_AgregarServicios_has_Platos(9, 3, 3);

-- ----------------------------------------LISTAR Servicios_has_Platos------------------------
delimiter //
	create procedure sp_ListarServicios_has_Platos()
	begin
		select 
			S.Servicios_codigoProducto, 
            S.codigoPlato, 
            S.codigoServicio
            from Servicios_has_Platos S;
    end//
delimiter ;

call sp_ListarServicios_has_Platos();


-- -------------------------BUSCAR Servicios_has_Platos-------------------------
delimiter //
	create procedure sp_BuscarServicios_has_Platos(in Servicios_codProducto int)
    begin
		select 
			S.Servicios_codigoProducto, 
            S.codigoPlato, 
            S.codigoServicio
            from Servicios_has_Platos S
				where S.Servicios_codigoProducto=Servicios_codProducto;
    end//
delimiter ;

call sp_BuscarServicios_has_Platos(2);


-- ---------------------------------EDITAR Servicios_has_Platos----------------------
-- ? ? ? ? ? ?


-- -------------------------------ELIMINAR Servicios_has_Platos--------------------
delimiter //
	create procedure sp_EliminarServicios_has_Platos(in Servicios_codProducto int)
    begin
		delete from Servicios_has_Platos
			where Servicios_codigoProducto=Servicios_codProducto;
    end//
delimiter ;

call sp_EliminarServicios_has_Platos(2);


-- --------------------------------------------Productos_has_Platos---------------

-- ------------------------AGREGAR Productos_has_Platos-------------------
delimiter //
	create procedure sp_AgregarProductos_has_Platos(in Productos_codigoProducto int, in codigoPlato int,
		in codigoProducto int)
    begin
		insert into Productos_has_Platos(Productos_codigoProducto, codigoPlato, codigoProducto)
			values (Productos_codigoProducto, codigoPlato, codigoProducto);
    end//
delimiter ;

call sp_AgregarProductos_has_Platos(1, 1, 1);
call sp_AgregarProductos_has_Platos(2, 9, 6);
call sp_AgregarProductos_has_Platos(3, 4, 7);
call sp_AgregarProductos_has_Platos(4, 3, 9);
call sp_AgregarProductos_has_Platos(5, 7, 6);
call sp_AgregarProductos_has_Platos(6, 6, 5);
call sp_AgregarProductos_has_Platos(7, 4, 4);
call sp_AgregarProductos_has_Platos(8, 5, 3);
call sp_AgregarProductos_has_Platos(9, 3, 7);
call sp_AgregarProductos_has_Platos(10, 8, 9);

-- ------------------------LISTAR Productos_has_Platos-------------------
delimiter //
	create procedure sp_ListarProductos_has_Platos()
    begin
		select 
			P.Productos_codigoProducto, 
            P.codigoPlato, 
            P.codigoProducto
            from Productos_has_Platos P;
    end//
delimiter ;

call sp_ListarProductos_has_Platos();


-- -----------------------BUSCAR Productos_has_Platos-------------------
delimiter //
	create procedure sp_BuscarProductos_has_Platos(in Productos_codProducto int)
    begin
		select 
			P.Productos_codigoProducto, 
            P.codigoPlato, 
            P.codigoProducto
            from Productos_has_Platos P
				where P.Productos_codigoProducto=Productos_codProducto;
	end//
delimiter ;

call sp_BuscarProductos_has_Platos(2);


-- ----------------------ELIMINAR Productos_has_Platos-----------------
delimiter //
	create procedure sp_EliminarProductos_has_Platos(in Productos_codProducto int)
    begin
		delete from Productos_has_Platos
			where Productos_codigoProducto=Productos_codProducto;
    end//
delimiter ;

call sp_EliminarProductos_has_Platos(1);

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'james';

	

-- ------------------------------INNER JOIN PARA REPORTE-----------------
select * from Empresas E
inner join Presupuesto P
on E.codigoEmpresa=P.codigoEmpresa
inner join Servicios S
on S.codigoEmpresa=E.codigoEmpresa
inner join Servicios_has_Empleados SE
on SE.codigoServicio=S.codigoServicio
inner join Empleados EM
on EM.codigoEmpleado=SE.codigoEmpleado
inner join TipoEmpleado T
on T.codigoTipoEmpleado=EM.codigoTipoEmpleado
inner join Servicios_has_Platos SP
on SP.codigoServicio=S.codigoServicio
inner join  Platos PL
on PL.codigoPlato=SP.codigoPlato
inner join TipoPlato TP
on TP.codigoTipoPlato=PL.codigoTipoPlato
inner join Productos_has_Platos PP
on PP.codigoPlato=PL.codigoPlato
inner join Productos PR
on PR.codigoProducto=PP.codigoProducto;

delimiter //
create procedure sp_ReporteFinal(in codEmpresa  int)
    begin
        select 
        E.nombreEmpresa,
        E.direccion,
        E.telefono,
        P.fechaSolicitud,
        P.cantidadPresupuesto,
        SE.fechaEvento,
        SE.horaEvento,
        SE.lugarEvento,
        S.fechaServicio,
        S.tipoServicio,
        S.horaServicio,
        S.lugarServicio,
        S.telefonoContacto,
        T.descripcion,
        EM.apellidosEmpleado,
        EM.nombresEmpleado,
        TP.descripcionTipo,
        PL.nombrePlato,
        PL.cantidad,
        PL.descripcionPlato,
        PL.precioPlato,
        PR.nombreProducto,
        PR.cantidadProducto
        from Empresas E
        inner join Presupuesto P
        on E.codigoEmpresa=P.codigoEmpresa
        inner join Servicios S
        on S.codigoEmpresa=E.codigoEmpresa
        inner join Servicios_has_Empleados SE
        on SE.codigoServicio=S.codigoServicio
        inner join Empleados EM
        on EM.codigoEmpleado=SE.codigoEmpleado
        inner join TipoEmpleado T
        on T.codigoTipoEmpleado=EM.codigoTipoEmpleado
        inner join Servicios_has_Platos SP
        on SP.codigoServicio=S.codigoServicio
        inner join  Platos PL
        on PL.codigoPlato=SP.codigoPlato
        inner join TipoPlato TP
        on TP.codigoTipoPlato=PL.codigoTipoPlato
        inner join Productos_has_Platos PP
        on PP.codigoPlato=PL.codigoPlato
        inner join Productos PR
        on PR.codigoProducto=PP.codigoProducto
        where E.codigoEmpresa=codEmpresa;
    end//
delimiter ;  

call sp_ReporteFinal(5);


