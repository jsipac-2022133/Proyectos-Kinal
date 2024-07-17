/*
	Fecha de creación: 05-07-2023
    
    Fechas de modificación: 10-07-2023
    
    Programador: James Sipac 2022133
*/

drop database if exists DBPeliculasIN5AV;

create database DBPeliculasIN5AV;

use DBPeliculasIN5AV;

create table Usuarios(
	idUsuario int not null auto_increment,
    nombreUsuario varchar(150) not null,
    apellidoUsuario varchar(150) not null,
    usuario varchar(150) not null,
    pass varchar(150) not null,
    email varchar(150) not null,
    fotoPerfil varchar(250),
	primary key PK_idUsuario(idUsuario)
);



create table TipoTarjeta(
	idTipoTarjeta int not null auto_increment,
    tipoTarjeta varchar(30),
    primary key PK_idTipoTarjeta(idTipoTarjeta)
);

create table Pago(
	idPago int not null auto_increment,
    cantidadAPagar double not null,
    idTipoTarjeta int not null,
    fechaPago date not null,
    idUsuario int not null,
    primary key PK_idPago(idPago),
    constraint FK_Pago_Usuarios foreign key(idUsuario)
		references Usuarios(idUsuario) on delete cascade,
	constraint FK_Pago_TipoTarjeta foreign key(idTipoTarjeta)
		references TipoTarjeta(idTipoTarjeta)
);




create table Proveedores(
	idProveedor int not null auto_increment,
    nombreProveedor varchar(150) not null,
    telefonoProveedor varchar(150) not null,
    email varchar(150),
    primary key PK_idProveedor(idProveedor)
);

create table Categoria(
	idCategoria int not null auto_increment,
    nombreCategoria varchar(250) not null,
    primary key PK_idCategoria(idCategoria)
);

create table Producto(
	idProducto int not null auto_increment,
    nombreProducto varchar(150) not null,
	genero varchar(150) not null,
    idCategoria int not null,
    precio double not null,
    duracion varchar(150) not null,
    sinopsis varchar(250) not null,
    portada varchar(250),
    trailer varchar(150) not null,
    idProveedor int not null,
    primary key PK_idProducto(idProducto),
    constraint FK_Producto_Proveedores foreign key (idProveedor)
		references Proveedores(idProveedor),
	constraint FK_Producto_Categoria foreign key (idCategoria)
		references Categoria(idCategoria)
);

create table Cesta(
	idCesta int not null auto_increment,
    cantidad int not null,
    fechaProducto date not null,
    subtotal double not null,
    idUsuario int not null,
    idProducto int not null,
    primary key PK_idCesta(idCesta),
    constraint FK_Cesta_Usuarios foreign key(idUsuario)
		references Usuarios(idUsuario) on delete cascade,
	constraint FK_Cesta_Producto foreign key(idProducto)
		references Producto(idProducto)
);

create table Resena(
	idResena int not null auto_increment,
    fechaValoracion date not null,
    calificacion int,    
    resena varchar(250),
    idUsuario int not null,
    idProducto int not null,
    primary key PK_idResena(idResena),
    constraint FK_Resena_Usuarios foreign key(idUsuario)
		references Usuarios(idUsuario) on delete cascade,
	constraint FK_Resena_Producto foreign key(idProducto)
		references Producto(idProducto)
);

create table ServicioCliente(
	idServicio int not null auto_increment,
    descripcion varchar(250),
    idUsuario int not null,
    idProducto int not null,
    primary key PK_idServicio(idServicio),
    constraint FK_ServicioCliente_Usuarios foreign key(idUsuario)
		references Usuarios(idUsuario) on delete cascade,
	constraint FK_ServicioCliente_Producto foreign key(idProducto)
		references Producto(idProducto)
);

create table Promocion(
	idPromocion int not null auto_increment,
    cartelPromocion varchar(250) not null,
    idCategoria int not null,
    porcentajePromocion int not null,
    fechaInicio datetime not null,
    fechaFinal datetime not null,
    primary key PK_idPromocion(idPromocion),
    constraint FK_Promocion_Categoria foreign key(idCategoria)
		references Categoria(idCategoria)
);

create table DetallePromocion(
	idDetallePromocion int not null auto_increment,
    precioFinal double,
    idPromocion int not null,
    idProducto int not null,
    primary key PK_idDetallePromocion(idDetallePromocion),
    constraint FK_DetallePromocion_Promocion foreign key(idPromocion)
		references Promocion(idPromocion),
	constraint FK_DetallePromocion_Producto foreign key(idProducto)
		references Producto(idProducto)
);

create table DetallePago(
	idDetallePago int not null auto_increment,
    cantidad int not null,
    idPago int not null,
    idCesta int not null,
    primary key PK_idDetallePago(idDetallePago),
	constraint FK_DetallePago_Pago foreign key(idPago)
		references Pago(idPago),
	constraint FK_DetallePago_Cesta foreign key(idCesta)
		references Cesta(idCesta)
);

create table Historial (
    idHistorial int not null auto_increment,
    idUsuario int not null,
    idProducto int not null,
    fechaVisualizacion timestamp default current_timestamp,
    primary key PK_idHistorial(idHistorial),
    constraint FK_Historial_Usuarios foreign key(idUsuario)
		references Usuarios(idUsuario) on delete cascade,
	constraint FK_Historial_Producto foreign key(idProducto)
		references Producto(idProducto) on delete cascade
);

-- ------------------ Categorias de pelicula ----------------------

Insert into Categoria(nombreCategoria)
	values('Acción, ciencia Ficción');
Insert into Categoria(nombreCategoria)
	values('Acción');
Insert into Categoria(nombreCategoria)
	values('Superhéroes');
Insert into Categoria(nombreCategoria) 
	values('Drama, Ciencia Ficción');
Insert into Categoria(nombreCategoria) 
	values('Acción, Crimen');
Insert into Categoria(nombreCategoria) 
	values('Historia');
Insert into Categoria(nombreCategoria) 
	values('Comedia');
Insert into Categoria(nombreCategoria) 
	values('Aventura');
Insert into Categoria(nombreCategoria) 
	values('Fantasía');
Insert into Categoria(nombreCategoria) 
	values('Drama');
Insert into Categoria(nombreCategoria) 
	values('Suspenso');
Insert into Categoria(nombreCategoria) 
	values('Guerra');
Insert into Categoria(nombreCategoria) 
	values('Terror');
Insert into Categoria(nombreCategoria) 
	values('Crimén');
Insert into Categoria(nombreCategoria) 
	values('Suspenso');
Insert into Categoria(nombreCategoria) 
	values('Thriller, Fantasia');
Insert into Categoria(nombreCategoria) 
	values('Familiar');
Insert into Categoria(nombreCategoria) 
	values('Ciencia Ficción');
Insert into Categoria(nombreCategoria) 
	values('Deporte');
Insert into Categoria(nombreCategoria) 
	values('Romance');
Insert into Categoria(nombreCategoria) 
	values('Bélico');
Insert into Categoria(nombreCategoria) 
	values('Musical');
Insert into Categoria(nombreCategoria) 
	values('Misterio'); 


select * from Categoria;
-- ------------------ Ingreso de datos ----------------------------

Insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('James Brian', 'Sipac Sipac', 'jsipac-2022133', 'sipac', 'jsipac-2022133@kinal.edu.gt','james.jpeg');
Insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('Byron Fernando', 'Roquel Batzibal', 'broquel-2022168', 'roquel', 'broquel-2022168@kinal.edu.gt','scrum2.jpeg');
Insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('Rubén Darío', 'Paredes Flores', 'rparedes-2022088', 'paredes', 'rparedes-2022088@kinal.edu.gt','ruben.jpeg');
Insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('Miguel David', 'Yac Castro', 'myac-2022020', 'yac', 'myac-2022020@kinal.edu.gt','miguel.jpeg');
Insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('Joshua Elijhab', 'Rosselin Corzo', 'jrosselin-2022050', 'rosselin', 'jrosselin-2022050@kinal.edu.gt','joshua.jpeg');
Insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('Josué Alejandro', 'Pérez Maas', 'jperez-2022076', 'perez', 'jperez-2022076@kinal.edu.gt','josue.png');
Insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('Angel David', 'Bachac Peralta', 'abachac-2022051', 'bachac', 'abachac-2022051@kinal.edu.gt','bachac.jpeg');
Insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('Sergio Eduardo', 'Tepaz Vela', 'stepaz-2022164', 'tepaz', 'stepaz-2022164@kinal.edu.gt','sergio.jpeg');
Insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('Frederic Edmundo', 'Silvestre Ixén', 'fsilvestre-2022163', 'silvestre', 'fsilvestre-2022163@kinal.edu.gt','scrum.jpeg');
Insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('Luis Armando', 'Reyes Orón', 'luis153', '12345', 'luisito@gmail.com','luis.png');
Insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('Steven', 'Sicaján Rodriguez', 'steven153', '12345', 'steven@gmail.com','steven.png');
insert into Usuarios (nombreUsuario, apellidoUsuario, usuario, pass, email, fotoPerfil)
	values ('Miguel', 'Yac', 'MDYC', 'myac','myac6397@gmail.com','MDYC.gif');
    
    
    select * From Usuarios;
    
-- ----------------------------------------------------------------    

-- Esto es para el historial
WITH ProductosConRowNumber AS (
    SELECT 
        P.idProducto,
        P.nombreProducto,
        P.genero,
        P.idCategoria,
        P.precio,
        P.duracion,
        P.sinopsis,
        P.portada,
        P.trailer,
        P.idProveedor,
        H.fechaVisualizacion,
        ROW_NUMBER() OVER (PARTITION BY P.idProducto ORDER BY H.fechaVisualizacion DESC) AS rn
    FROM Producto P
    INNER JOIN Historial H ON H.idProducto = P.idProducto
    WHERE H.idUsuario = 1
)
SELECT 
    idProducto,
    nombreProducto,
    genero,
    idCategoria,
    precio,
    duracion,
    sinopsis,
    portada,
    trailer,
    idProveedor
FROM ProductosConRowNumber
WHERE rn = 1
ORDER BY fechaVisualizacion DESC;



-- ----------------------------------------------------------------

insert into TipoTarjeta(tipoTarjeta)
	values('Debito');
insert into TipoTarjeta(tipoTarjeta)
	values('Credito');
insert into TipoTarjeta(tipoTarjeta)
	values('Regalo');
    
-- ----------------------------------------------------------------

Insert into Pago (cantidadAPagar, idTipoTarjeta, fechaPago, idUsuario)
	values(100.55, 1, '2023-03-25', 1);
Insert into Pago (cantidadAPagar, idTipoTarjeta, fechaPago, idUsuario)
	values(250.00, 1, '2023-06-09', 2);
select * from Pago;
-- ------------------------------------------------------------------

Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 1
	values('Sony-Columbia', '87957894', 'spe_privacy@spe.sony.com'); 
Insert into Proveedores (nombreProveedor, telefonoProveedor, email)  -- 2
	values('Disney', '9394357', 'disneyworld.com/dine');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 3
	values('Marvel Entertainment', '79865432', 'Marvel@marvel.org');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email)  -- 4
	values('DC Comics', '57822789', 'DCComics@comics.org');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email)  -- 5
	values('Screen Arcade', '69137895', 'ScreenArcade@arcade.sa');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 6
	values('Walt Disney Studios Motion Pictures', '49137865', 'waltdisney@pelis.org');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 7
	values('Paramount Pictures', '19782997', 'Studio_Operations@paramount.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 8
	values('lightstorm entertainment', '424652231', 'Studio_Lightstorm@lightstorm.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 9
	values('Lucasfilm', '55967418', 'Lucasfilm@lucasfilm.com');  
Insert into Proveedores (nombreProveedor, telefonoProveedor, email)  -- 10
	values('New Line Cinema', '79845123', 'NewLineCinema@newline.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email)  -- 11
	values('Orion Pictures', '68794213', 'OrionPictures@orionpictures.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 12
	values('DreamWorks', '59786458', 'DreamWorks@dreamworks.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 13
	values('Miramax', '48699812', 'Miramax@miramax.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 14
	values('Warner Bros', '46747984', 'Warner@warner.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 15
	values('Amblin Entertainment', '82449418', 'Amblin@amblinentertainment.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 16
	values('Universal Studios', '17911978', 'UniversalStudios@universal.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 17
	values('Pixar', '16373454', 'Pixar@pixar.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 18
	values('United Artists', '98755496', 'UnitedArtists@united.gmail');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 19
	values('PolyGram Filmed Entertainment', '48537985', 'PolyGram@polygram.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 20
	values('Summit Entertainment', '67963387', 'SummitEntertaiment@summit.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 21
	values('Anonymous Content', '55669933', 'AnonymousContent@anonymous.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 22
	values('Studio Babelsberg', '48479852', 'StudioBabelsberg@babelsberg.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 23
	values('Lionsgate Films', '88001551', 'LionsgateFilms@lionsgate.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 24
	values('20th Century Studios', '79471497', '20thCentury@century.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 25
	values('Castle Rock Entertainment', '56859121', 'CastleRock@claste.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 26
	values('Village Roadshow Pictures', '97877461', 'VillageRoadshow@village.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 27
	values('Spyglass Media Group', '79847684', 'SpyglassMediaGroup@spyglass.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 28
	values('Columbia Pictures', '87914887', 'ColumbiaPictures@columbia.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 29
	values('Universal Pictures', '17911978', 'UniversalPictures@universal.com');
Insert into Proveedores (nombreProveedor, telefonoProveedor, email) -- 30
	values('Queja', '', '');
    select * from Proveedores;
-- -------------------------------------------------------------------

Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value('Spider-Man: Across the Spider-Verse', 'Animación, Superhéroe',1, 100.50, '2h 16m',
    'Spider-Man: Into the Spider-Verse presenta a Miles Morales, un adolescente de Brooklyn, y las ilimitadas posibilidades 
    del Universo Spider-Man, donde más de uno puede llevar la máscara.','spiderman.jpg','https://www.youtube.com/watch?v=ApXoWvfEYVU',  1);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value("Venom", "SuperHéroes",2,100.00,"2h 14min","Eddie Brock está investigando a Carlton Drake, el célebre fundador de Life Foundation. Brock establece una simbiosis con un ente alienígena que le ofrece superpoderes.",
		"venom.jpg","https://www.youtube.com/watch?v=u9Mv98Gr5pY", 3);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value("Avengers Endgame", "Aventura, Acción, Fantasía",3,140.50,"3h 2min",
    "El universo está en ruinas debido a las acciones de Thanos, el Titán Loco. Con la ayuda de los aliados que quedaron, los Vengadores deberán reunirse una vez más para intentar detenerlo",
    "avengers.jpg","https://www.youtube.com/watch?v=znk2OICHbjY",  3);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value("Black Adam","Aventura, Suspenso",4,125.00,"2h 5min", 
    "Unos arqueólogos liberan de su tumba a Black Adam, quien llevaba 5000 años preso tras haber recibido los poderes de los dioses.",
    "adam.jpg","https://www.youtube.com/watch?v=a1mcS4tKGNg",  4);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value("Project Power", "Superheroe",5, 175.00, "1h 53min", 
    "Las vidas de un exsoldado, una adolescente y un policía se cruzan en Nueva Orleans mientras buscan al suministrador de una pastilla que otorga superpoderes temporales.",
    "project.jpg","https://www.youtube.com/watch?v=fg6eDTYDKNg",5);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Oppenheimer','Drama',6,500,'3 horas','La historia del científico estadounidense J. Robert Oppenheimer y su papel en el desarrollo de la bomba atómica.',
    'oppenheimer.jpg','https://www.youtube.com/watch?v=MVvGSBKV504',16);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Barbie','Fantasía',7,500,'1 hora 54 minutos','Vivir en Barbie Land es ser un ser perfecto en un lugar perfecto. A menos que tengas una crisis existencial completa. O seas Ken.',
    'barbie.jpg','https://www.youtube.com/watch?v=pBk4NYhWNMM',14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Super Mario Bros.: La película','Animación',8,400,'1 hora 32 minutos','Un plomero llamado Mario navega por un laberinto subterráneo con su hermano, Luigi, tratando de salvar a una princesa capturada.',
    'mario.jpg','https://www.youtube.com/watch?v=TnGl01FkMMo',16);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El gato con botas: El último deseo','Animación',8,300,'1 hora 42 minutos','El Gato con Botas descubre que su pasión por la aventura le ha pasado factura: Ha agotado ocho de sus nueve vidas. El Gato con Botas se embarca en un viaje épico para encontrar al mítico Último Deseo y recuperar sus nueve vidas.',
    'gato.jpg','https://www.youtube.com/watch?v=18v5EPO5ySs',12);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Guardianes De La Galaxia Vol. 3','Acción',7,500,'2 horas 30 minutos','Tercer entrega de Guardianes de la Galaxia.',
    'guardianes3.jpg','https://www.youtube.com/watch?v=u3V5KDHRQvk',3);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Flash','Acción',8,500,'2 horas 24 minutos','Flash, el hombre más rápido, viaja a una línea temporal en que la Tierra está en crisis y el resto de héroes están perdidos o dispersados.',
    'flash.jpg','https://www.youtube.com/watch?v=-FsCwGj9aDw',4);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Blue Beetle','Acción',8,500,'2 horas 7 minutos','Un recién graduado universitario encuentra un escarabajo alienígena que le otorga una armadura con superpoderes.',
    'blue.jpg','https://www.youtube.com/watch?v=Shmvk5M-NV8',4);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('La Sirenita','Aventura',9,500,'2 horas 15 minutos','Una joven sirena hace un trato con una bruja marina para intercambiar su hermosa voz por piernas humanas para así poder descubrir el mundo de la superficie e impresionar a un príncipe.',
    'sirenita.jpg','https://www.youtube.com/watch?v=Z3ye3kkwiO4',6);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Top Gun: Maverick','Acción',10,400,'2 horas 10 minutos','Después de más de treinta años de servicio como uno de los mejores aviadores de la Armada, Pete Mitchell vuelve donde pertenece, siendo un valiente piloto de pruebas y esquivando un avance de rango que lo castigaría.',
    'topgun.jpg','https://www.youtube.com/watch?v=zzBIzYmxatU',7);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Batman','Acción',10,300,'2 horas 56 minutos','Cuando Riddler, un sádico asesino en serie, comienza a asesinar a figuras políticas clave en Gotham, Batman se ve obligado a investigar la corrupción oculta de la ciudad y cuestionar la participación de su familia.',
    'batman22.jpg','https://www.youtube.com/watch?v=fWQrd6cwJ0A',4);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('John Wick 4','Acción',11,500,'2 horas 49 minutos','John Wick descubre un camino para derrotar a La Mesa, pero, antes de que pueda ganarse su libertad, Wick debe enfrentar a un nuevo enemigo con poderosas alianzas en todo el mundo y fuerzas que convierten a viejos amigos en enemigos.',
    'jw4.jpg','https://www.youtube.com/watch?v=yjRHZEUamCc',23);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Joker','Crimen',10,200,'2 horas 2 minutos','En Ciudad Gótica, Arthur Fleck, un comediante con problemas mentales, marginado y maltratado por la sociedad. Esto lo lleva a descender a un espiral de revolución, sangre y crimen donde conoce a su alter-ego: El Joker.',
    'joker.jpg','https://www.youtube.com/watch?v=zAGVQLHvwOY',4);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Transformers: El Despertar De Las Bestias','Acción',8,500,'2 horas 7 minutos','Sigue nuevamente a un grupo de Decepticons y Autobots que se enfrentan en una guerra entre aquellos que desean controlar el planeta y los que quieren vivir en comunión.',
    'transformersbestias.jpg','https://www.youtube.com/watch?v=itnqEauWQZM',7);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Rápidos Y Furiosos X','Acción',8,450,'2 horas 21 minutos','Dom Toretto y su familia son atacados por el hijo vengativo del capo narco Hernan Reyes.',
    'rapidosx.jpg','https://www.youtube.com/watch?v=O5BOxn8Go8U',16);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Iron Man 3','Acción',8,100,'2 horas 10 minutos','Cuando el mundo de Tony Stark se desgarra a causa de un terrorista llamado Mandarin, este atraviesa una odisea para iniciar su reconstrucción.',
    'i3.jpg','https://www.youtube.com/watch?v=Ga817lEqAoI',3);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Avengers: Infinity War','Acción',8,150,'2 horas 29 minutos','Los Avengers y sus aliados deberán estar dispuestos a sacrificarlo todo con el fin de derrotar a Thanos antes de que él ponga fin al universo.',
    'iw.jpg','https://www.youtube.com/watch?v=823iAZOEKt8',3);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Venom: Carnage liberado','Acción',11,200,'1 hora 37 minutos','Eddie Brock intenta relanzar su carrera entrevistando al asesino en serie Cletus Kasady, que se convierte en el huésped del simbionte Carnage y escapa de la cárcel tras una ejecución fallida.',
    'venom2.jpg','https://www.youtube.com/watch?v=-FmWuCgJmxo',1);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Thor: Love and Thunder','Acción',7,250,'1 hora 58 minutos','Thor solicita la ayuda de Valkyrie, Korg y su ex novia Jane Foster para luchar contra Gorr the God Butcher, que tiene la intención de extinguir a los dioses.',
    'thorlv.jpg','https://www.youtube.com/watch?v=Go8nTmfrQd8',3);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Mad Max: Fury Road','Acción',8,100,'2 horas','En un lugar post-apocalíptico, una mujer se rebela contra un gobernante tiránico en busca de su tierra natal con la ayuda de un grupo de mujeres prisioneras, un devoto psicótico y un vagabundo llamado Max.',
    'mad.jpg','https://www.youtube.com/watch?v=hEJnMQG9ev8',14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('300: el nacimiento de un imperio','Acción',12,100,'1 hora 42 minutos','Un general griego lidera la carga contra las fuerzas invasoras persas, a su vez lideradas por mortales comandantes de la marina persa con sed de venganza.',
    '300-2.jpg','https://www.youtube.com/watch?v=C_naqE6OyH8',14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Guerra mundial Z','Acción',13,75,'1 hora 56 minutos','El ex empleado de las Naciones Unidas, Gerry Lane, atraviesa el mundo en una carrera contra reloj para detener la pandemia Zombie que está derrocando ejércitos y gobiernos, y amenazando con destruir a la humanidad.',
    'guerraz.jpg','https://www.youtube.com/watch?v=b9sQkgCc7UE',7);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Godzilla II: El rey de los monstruos','Acción',9,150,'2 horas 12 minutos','La agencia de criptografía zoológica Monarch, se enfrenta a una serie de monstros de tamaño exponencial, incluyendo a Rodilla quien confronta a Mothra, Rodan y su archienemigo, el Rey Guidorah de tres cabezas.',
    'godzilla2.jpg','https://www.youtube.com/watch?v=QFxN2oDKk0E',14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Titanes del Pacífico','Acción',8,75,'2 horas 11 minutos','Mientras la guerra entre la humanidad y las criaturas marinas monstruosas avanza, un antiguo piloto y un aprendiz se unen para conducir un arma aparentemente obsoleta en un esfuerzo desesperado por salvar al mundo del apocalipsis.',
    'titanes.jpg','https://www.youtube.com/watch?v=5guMumPFBag',14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Hasta el último hombre','Biografía',6,80,'2 horas 19 minutos','El médico del ejército estadounidense Desmond T. Doss, se niega a matar personas y se convierte en el primer hombre en la historia de Estados Unidos en recibir la Medalla de Honor sin disparar un tiro.',
    'ultimo.jpg','https://www.youtube.com/watch?v=s2-1hz1juBI',23);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Rogue One. Una historia de Star Wars','Ciencia Ficción',8,100,'2 horas 13 minutos','La hija de un científico se une a la Alianza Rebelde en un movimiento arriesgado para robar los planes de la Estrella de la Muerte.',
    'rogue.jpg','https://www.youtube.com/watch?v=frdj1zb9sMY',9);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Bumblebee','Acción',8,90,'1 hora 54 minutos','En 1987 Charlie Watson de 18 años encuentra a Bumblebee que ha encontrado refugio en un patio de chatarra en un pequeño pueblo en California.',
    'bum.jpg','https://www.youtube.com/watch?v=lcwmDAYt22k',7);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Kong. La Isla Calavera','Acción',9,100,'1 hora 58 minutos','Después de la guerra de Vietnam, un grupo de científicos exploran el desconocido territorio de una isla en el Pacífico, aventurándose en los dominios del poderoso Kong y deberán luchar para escapar de la isla.',
    'kong.jpg','https://www.youtube.com/watch?v=44LdLqgOpjo',14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Batman: El caballero de la noche','Acción',10,75,'2 horas 32 minutos','Cuando el Joker emerge causando caos y violencia en Gotham, el caballero de la noches deberá aceptar una de las pruebas psicológicas y físicas más difíciles para poder luchar con las injusticias del enemigo.',
    'batmandk.jpg','https://www.youtube.com/watch?v=LDG9bisJEaI',4);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('John Wick','Acción',14,85,'1 hora 41 minutos','Un ex asesino sale del retiro para buscar a los pandilleros que mataron a su perro y tomaron todas su posesiones.',
    'john1.jpg','https://www.youtube.com/watch?v=2AUmvWm5ZDQ',23);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('It (Eso)','Terror',10,70,'2 horas 15 minutos','En el verano de 1989 un grupo de niños deciden unirse para destruir a un monstruo que cambia de forma y se disfraza de payaso atacando los niños de Derry, un pequeño pueblo de Maine.',
    'it.jpg','https://www.youtube.com/watch?v=FnCdOQsX5kc',14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('La noche del demonio','Terror',11,50,'1 hora 43 minutos','Una familia busca evitar que los espíritus malignos atrapen a su hijo que cayó en estado de coma.',
    'noche.jpg','https://www.youtube.com/watch?v=62rpZcMYa0A',14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Godzilla vs. Kong','Acción',9,150,'1 hora 53 minutos','Cuando el gigante Kong se enfrenta al imparable Godzilla, el mundo espera cual de ellos se convertirá en el Rey de los monstros.',
    'godzillavskong.jpg','https://www.youtube.com/watch?v=Kqg8zLgESyQ',14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El hombre araña 2','Acción',8,50,'2 horas 7 minutos','Peter Parker está plagado de problemas en su fallida vida personal mientras lucha contra un científico brillante llamado Doctor Otto Octavius.',
    'spiderman2.jpg','https://www.youtube.com/watch?v=enmFqm_N_ZE',1);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Transformers: El lado oscuro de la luna','Acción',8,75,'2 horas 34 minutos','Los Autobots aprenden de una nave espacial escondida en la luna, y compiten contra los Decepticons para alcanzarla y aprender sus secretos.',
    'transformers3.jpg','https://www.youtube.com/watch?v=Rf3OcxIFbRE',7);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Avengers: Era de Ultrón','Acción',8,65,'2 horas 21 minutos','Cuando Tony Stark y Bruce Banner tratan de lanzar el programa, Ultron, las cosas terminan mal y ahora está en manos de los héroes del planeta de detener a los villanos de Ultron de llevar a cabo su terrorífico plan.',
    'avengers2.jpg','https://www.youtube.com/watch?v=DMFBm_lp4rU',3);    
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value('Avatar: the way of water', 'Accion, drama, aventura, ciencia ficción', 16, 250.00, '3h 12m', 
    'Jake Sully y Ney tiri han formado una familia y hacen todo lo posible por permanecer juntos. 
    Sin embargo, deben abandonar su hogar y explorar las regiones de Pandora cuando una antigua amenaza reaparece.','avatar.jpg','https://www.youtube.com/watch?v=FSyWAxUg3Go', 6);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Padrino', 'Drama', 14, 150.99, '2 horas 55 minutos', 'Una adaptación ganadora del Premio de la Academia, de la novela de Mario Puzo acerca de la familia Corleone.', 'ElPadrino.jpg', 'https://www.youtube.com/watch?v=iOyQx7MXaz0&t=5s',  7);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Titanic', 'Romance', 10, 250.99, '3 horas 15 minutos', 'Una joven de la alta sociedad abandona a su arrogante 
    pretendiente por un artista humilde en el trasatlántico que se hundió durante su viaje inaugural.', 'Titanic.jpg', 'https://www.youtube.com/watch?v=tA_qMdzvCvk&t=3s',  8);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Star Wars: Episodio IV - Una Nueva Esperanza', 'Ciencia ficción', 8, 300.99, '2 horas 1 minuto', 'La nave en la que viaja la princesa Leia es capturada por las tropas imperiales 
    al mando del temible Darth Vader.', 'StarWars.jpg', 'https://www.youtube.com/watch?v=beAH5vea99k', 9);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Transformers','Ciencia ficción',8,110,'2 horas 24 minutos','Una antigua guerra entre Autobots y Decepticons toma la Tierra como escenario, donde un adolescente tiene la clave para el poder definitivo.',
    'transformers.jpg','https://www.youtube.com/watch?v=CbX_SIz_9fk',7);    
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Forrest Gump', 'Drama', 7, 100.99, '2 horas 22 minutos', 'Forrest Gump, un joven sureño, tenaz e inocente, es protagonista de 
    acontecimientos cruciales en la historia de los Estados Unidos.', 'ForrestGump.jpg', 'https://www.youtube.com/watch?v=Cyh1LpxnaxI', 7);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Transformers: La Venganza de los Caídos','Ciencia ficción',8,110,'2 horas 29 minutos','Sam Witwicky deja atrás a los Autobots para llevar una vida normal. Pero cuando su mente está llena de símbolos crípticos, los Decepticons lo atacan y es arrastrado de nuevo a la guerra de los Transformers.'
    ,'transformers2.jpg','https://www.youtube.com/watch?v=fnXzKwUgDhg',7);    
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Señor de los Anillos: La Comunidad del Anillo', 'Fantasía', 8, 1000.00, '2 horas 58 minutos', 'Frodo, Sam y Gollum se acercan al monte del Destino, donde
    destruirán el anillo o perecerán en el intento. Mientras, Aragorn y sus compañeros se enfrentan
    a las monstruosas tropas de Sauron.', 'LaComunidadDelAnillo.jpg', 'https://www.youtube.com/watch?v=3GJp6p_mgPo', 10);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Indiana Jones y la Última Cruzada', 'Aventura', 2, 299.99, '2 horas 7 minutos', 'El padre del intrépido arqueólogo Indiana Jones es secuestrado cuando busca
    el Santo Grial. Indiana tendrá que ir a rescatarlo e intenta recuperar la preciada
    reliquia, que también ambicionan los nazis.', 'LaUltimaCruzada.jpg', 'https://www.youtube.com/watch?v=OSYMxkLznPs&t=14s', 7);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Silencio de los Corderos', 'Crimen', 10, 50.99, '1 hora 58 minutos', 'Una agente en entrenamiento del FBI busca la ayuda y consejo de un brillante asesino para
    poder capturar a otro asesino, el doctor Hannibal Lecter, un psiquiatra
    que también es un psicópata violento y antropófago', 'SilencioDeLosCorderos.jpg', 'https://www.youtube.com/watch?v=gvLHOcHQeMM', 11);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Gladiador', 'Acción', 10, 56.99, '2 horas 35 minutos', 'Máximo, general romano, desea volver a casa, pero el emperador Marco Aurelio quiere que herede el imperio.
    Esto hace que Cómodo ordene matar a su familia.', 'Gladiador.jpg', 'https://www.youtube.com/watch?v=P5ieIbInFpg&t=1s', 12);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Pulp Fiction', 'Crimen', 10, 89.99, '2 horas 34 minutos', 'La vida de un boxeador, dos sicarios, la esposa de un gánster y dos bandidos se entrelaza en una historia 
    de violencia y redención.', 'PulpFiction.jpg', 'https://www.youtube.com/watch?v=ZFYCXAG6fdo', 13);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Matrix', 'Ciencia ficción', 2, 74.99, '2 horas 16 minutos', 'Un experto en computadoras descubre que su mundo es una simulación total creada con maliciosas intenciones
    por parte de la ciberinteligencia.', 'Matrix.jpg', 'https://www.youtube.com/watch?v=vN_Hx_It3r0',  14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('E.T. el Extraterrestre', 'Ciencia ficción', 17, 98.99, '1 hora 55 minutos', 'Elliott es un niño de nueve años que se encuentra con un extraterrestre y decide esconderlo en
    su casa para protegerlo.', 'ET.jpg', 'https://www.youtube.com/watch?v=p4vSher2e3A', 15);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Los Vengadores', 'Acción', 8, 65.99, '2 horas 23 minutos', 'El director de la Agencia SHIELD decide reclutar a un equipo para salvar al mundo de un desastre casi seguro cuando
    un enemigo inesperado surge como una gran amenaza para la seguridad mundial.', 'Vengadores.jpg', 'https://www.youtube.com/watch?v=yNXfOOL8824', 3);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Jurassic Park', 'Ciencia ficción', 8, 89.99, '2 horas 6 minutos', 'Tres expertos y otras personas son invitados a un parque de diversiones, donde se encuentran dinosaurios creados 
    en base al ADN.', 'JurassicPark.jpg', 'https://www.youtube.com/watch?v=dLDkNge_AhE', 16);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Resplandor', 'Terror', 10, 150.99, '2 horas 26 minutos', 'Jack Torrance se convierte en cuidador de invierno en el Hotel Overlook, en Colorado, con la esperanza de vencer su bloqueo
    con la escritura.', 'ElResplandor.jpg', 'https://www.youtube.com/watch?v=IiSjPcRWjYA',  14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Piratas del Caribe: La Maldición del Perla Negra', 'Aventura', 9, 149.99, '2 horas 23 minutos', 'Piratas del Caribe es el título de una franquicia cinematográfica de aventura fantástica
    y piratas, La saga Piratas del Caribe cuenta con cinco películas estrenadas y una sexta en producción.', 'PiratasDelCaribe.jpg', 'https://www.youtube.com/watch?v=4s67PU-s1kc',  2);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Los Increíbles', 'Animación', 2, 100.99, '1 hora 55 minutos', 'Un superhéroe retirado lucha contra el aburrimiento y, junto a su familia, tiene la oportunidad de salvar al mundo.
', 'LosIncreibles.jpg', 'https://www.youtube.com/watch?v=c_9J6YRIUuw', 17);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('La Lista de Schindler', 'Drama', 6, 75.99, '3 horas 15 minutos', 'El empresario alemán Oskar Schindler, miembro del Partido Nazi, pone en marcha un elaborado, costoso y arriesgado plan para salvar a más de mil judíos del Holocausto.
', 'Schindler.jpg', 'https://www.youtube.com/watch?v=BmkchuRJ82w', 15);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Mad Max: Fury Road', 'Acción', 18, 90.00, '2 horas', 'Aunque está decidido a vagar solo por el páramo post-apocalíptico, Mad Max se une a Furiosa, una comandante fugitiva, y su banda, quienes están tratando de escapar
    de un señor de la guerra.', 'MadMax.jpg', 'https://www.youtube.com/watch?v=GvsFoGIuRX4',  16);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Up', 'Animación', 8, 25.99, '1 hora 36 minutos', 'Carl Fredricksen es un vendedor de globos de 78 años de edad dispuesto a cumplir su sueño: atar miles de globos a su casa y 
    volar a Sudamérica.
', 'Up.jpg', 'https://www.youtube.com/watch?v=qoZo9MiICo0',  17);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Rey León', 'Animación', 17, 5.00, '1 hora 28 minutos', 'Tras la muerte de su padre, Simba vuelve a enfrentar a su malvado tío, Scar, y reclamar el trono de rey.
', 'ElReyLeon.jpg', 'https://www.youtube.com/watch?v=bjJvvrKl83M', 2);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Rocky', 'Drama', 19, 84.00, '2 horas', 'Un humilde boxeador de Filadelfia, en el que nadie cree, tiene la oportunidad de cambiar su vida por completo si lucha por el título mundial contra el temible Apollo Creed.
', 'Rocky.jpg', 'https://www.youtube.com/watch?v=Vb-Bx2YkIPA', 18);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Exorcista', 'Terror', 10, 99.25, '2 horas 2 minutos', 'Una actriz llama a unos sacerdotes jesuitas para que intenten terminar con la posesión demoníaca de su hija de 12 años.
', 'Exorcista.jpg', 'https://www.youtube.com/watch?v=7iCJssW8XiI', 14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Gran Lebowski', 'Comedia', 14, 300.20, '1 hora 59 minutos', 'Un desempleado es confundido por unos matones con el millonario Jeff Lebowski, quien se llama igual que él y a cuya esposa han secuestrado.
', 'Lebowski.jpg', 'https://www.youtube.com/watch?v=AkA69XT7Lq0.',  19);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('La La Land', 'Musical', 20, 300.00, '2 horas 8 minutos', 'Sebastian, un pianista de jazz, y Mia, una aspirante a actriz, se enamoran locamente.
', 'LaLaLand.jpg', 'https://www.youtube.com/watch?v=IHbHn5SLhZo', 20);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Eterno Resplandor de una Mente Sin Recuerdos', 'Drama', 18, 72.99, '1 hora 48 minutos', 'Parecían la pareja ideal, su primer encuentro fue mágico, pero con el paso del tiempo ella deseó nunca haberlo conocido. Su anhelo se hace realidad gracias a un polémico y radical invento. Sin embargo descubrirán que el destino no se puede controlar.
', 'EternoResplandor.jpg', 'https://www.youtube.com/watch?v=KqCg3tkUcdE', 21);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Gran Hotel Budapest', 'Comedia', 8, 75.00, '1 hora 39 minutos', 'El conserje de un elegante hotel europeo inicia una interesante amistad con un joven compañero de trabajo.',
    'ElGranHotelBudapest.jpg', 'https://www.youtube.com/watch?v=IImKsmIZ1VY',  22);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Laberinto del Fauno', 'Fantasía', 10, 75.00, '1 hora 58 minutos', 'España, 1944, la joven Ofelia y su madre enferma llegan al sitio en el que se encuentra el nuevo esposo de su madre, un sádico 
    oficial del ejército que intenta calmar el levantamiento de una guerrilla.
', 'LaberintoDelFauno.jpg', 'https://www.youtube.com/watch?v=gpEh4O8Hb5Y',14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Scarface', 'Crimen', 10, 250.00, '2 horas 50 minutos', 'Un inmigrante cubano de las cárceles de Fidel Castro provoca un camino de destrucción en su ascenso en el mundo de las drogas de Miami.
', 'Scarface.jpg', 'https://www.youtube.com/watch?v=vSp_kLkNdnE',  16);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Los Juegos del Hambre', 'Ciencia ficción', 8, 125.99, '2 horas 22 minutos', 'En lo que alguna vez fue Norteamérica, la capital de Panem mantiene sus 12 distritos obligándolos a seleccionar a un niño y a una niña, llamados Tributos, a competir en un evento televisado nacionalmente llamado los Juegos del Hambre.',
    'JuegosDelHambre.jpg', 'https://www.youtube.com/watch?v=_8Ktfs2mBDY', 23);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Club de la Pelea', 'Drama', 14, 50.99, '2 horas 19 minutos', 'Un empleado de oficina insomne, harto de su vida, se cruza con un vendedor peculiar. Ambos crean un club de lucha clandestino como forma de terapia y, poco a poco, la organización crece y sus objetivos toman otro rumbo.
', 'ElClubDeLaPelea.jpg', 'https://www.youtube.com/watch?v=r5KDiUNZv4w',  24);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Cadena Perpetua', 'Drama', 14, 75.99, '2 horas 22 minutos', 'Un hombre inocente es enviado a una corrupta penitenciaria de Maine en 1947 y sentenciado a dos cadenas perpetuas por un doble asesinato.
', 'CadenaPerpetua.jpg', 'https://www.youtube.com/watch?v=4u87tmlj4oE', 25);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Apocalypse Now', 'Drama', 21, 100.99, '2 horas 33 minutos', 'Controvertida historia sobre la misión de un capitán del ejército de encontrar y matar a un oficial renegado en Camboya.
', 'ApocalypseNow.jpg', 'https://www.youtube.com/watch?v=9l-ViOOFH-s', 7);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Interestelar', 'Ciencia ficción', 8, 125.00, '2 horas 49 minutos', 'Gracias a un descubrimiento, un grupo de científicos y exploradores, encabezados por Cooper, se embarcan en un viaje espacial para encontrar un lugar con las condiciones necesarias para reemplazar a la Tierra y comenzar una nueva vida allí.
', 'Interestelar.jpg', 'https://www.youtube.com/watch?v=UoSSbmD9vqc', 7);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Gran Gatsby', 'Drama', 20, 150.00, '2 horas 23 minutos', 'Nick Carraway (Tobey Maguire), nativo del Medio Oeste, llega a Nueva York en 1922 en busca del sueño americano. Nick se involucra en un mundo cautivador de riqueza.', 
    'GranGatsby.jpg', 'https://www.youtube.com/watch?v=tgx3mpSUwBA', 26);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Volver al Futuro', 'Ciencia ficción', 8, 89.00, '1 hora 56 minutos', 'Una máquina del tiempo transporta a un adolescente a los años 50, cuando sus padres todavía estudiaban en la secundaria.
', 'VolverAlFuturo.jpg', 'https://www.youtube.com/watch?v=GM6_MHRc4Xo', 16);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Memento', 'Misterio', 10, 90.00, '1 hora 53 minutos', 'Leonard, cuya memoria está dañada por culpa de un golpe en la cabeza al intentar evitar el asesinato de su mujer, tiene que recurrir a la ayuda de una cámara instantánea y a las notas tatuadas en su cuerpo para investigar el crimen y vengarla.
', 'Memento.jpg', 'https://www.youtube.com/watch?v=mV9l1enMqvk', 20);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Sexto Sentido', 'Drama', 13, 100.99, '1 hora 47 minutos', 'Malcolm Crowe es un psicólogo infantil que vive obsesionado por el recuerdo de un joven al que fue incapaz de ayudar.
', 'SextoSentido.jpg', 'https://www.youtube.com/watch?v=zfOdk9JDzSw', 27);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Casablanca', 'Drama', 20, 150.00, '1 hora 42 minutos', 'En Marruecos, el dueño (Humphrey Bogart) de un café ayuda a su ex novia (Ingrid Bergman) y a su marido (Paul Henreid) a escapar de los nazis.
', 'CasaBlanca.jpg', 'https://www.youtube.com/watch?v=nqlROp1TIgo',  14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Los Miserables', 'Drama', 22, 250.00, '2 horas 38 minutos', 'Después de 19 años como prisionero, Jean Valjean es liberado por Javert, el oficial a cargo de la fuerza de trabajo de la prisión.',
    'LosMiserables.jpg', 'https://www.youtube.com/watch?v=EZngbEj3W1Y', 16);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Harry Potter y la Piedra Filosofal', 'Fantasía', 8, 150.00, '2 horas 32 minutos', 'El día de su cumpleaños, Harry Potter descubre que es hijo de dos conocidos hechiceros, de los que ha heredado poderes mágicos.
', 'PiedraFilosofal.jpg', 'https://www.youtube.com/watch?v=ZgrCZVjPg9g', 14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Harry Potter y la Cámara de los secretos', 'Fantasía', 8, 150.00, '2 horas 41 minutos', 'Terminado el verano, Harry no ve la hora de abandonar la casa de sus odiosos tíos. Inesperadamente se presenta en su dormitorio Dobby, un elfo doméstico, que le anuncia que correrá un gran peligro si vuelve a Hogwarts.
', 'LaCamaraSecreta.jpg', 'https://www.youtube.com/watch?v=C8CL5TbiFwY', 14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Harry Potter y el Prisionero de Azkaban', 'Fantasía', 8, 150.00, '2 horas 22 minutos', 'El tercer año de estudios de Harry en Hogwarts se ve amenazado por la fuga de Sirius Black de la prisión de Azkaban. Al parecer, se trata de un peligroso mago que fue cómplice de Lord Voldemort y que intentará vengarse de Harry Potter.
', 'PrisioneroDeAzkaban.jpg', 'https://www.youtube.com/watch?v=cUtaBkW1MKo',  14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Harry Potter y el Cáliz de Fuego', 'Fantasía', 8, 150.00, '2 horas 37 minutos', 'Hogwarts se prepara para el Torneo de los Tres Magos, en el que competirán tres escuelas de hechicería.
', 'CalizDeFuego.jpg', 'https://www.youtube.com/watch?v=wX5dWfUKGPg',  14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Harry Potter y la Orden del Fénix', 'Fantasía', 8, 150.00, '2 horas 18 minutos', 'En su quinto año en Hogwarts, Harry descubre que muchos integrantes de la comunidad de magos no conocen la verdad acerca de su encuentro con Lord Voldemort.
    ', 'OrdenDelFenix.jpg', 'https://www.youtube.com/watch?v=jdEulcjAvQI', 14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Harry Potter y el Misterio del Príncipe', 'Fantasía', 8, 150.00, '2 horas 33 minutos', 'Harry descubre un poderoso libro y, mientras trata de descubrir sus orígenes, colabora con Dumbledore en la búsqueda de una serie de objetos mágicos que ayudarán en la destrucción de Lord Voldemort.
', 'MisterioDelPrincipe.jpg', 'https://www.youtube.com/watch?v=CHiGk9bEht8', 14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Harry Potter y las Reliquias de la Muerte - Parte 1', 'Fantasía', 8, 150.00, '2 horas 26 minutos', 'Harry, Ron y Hermione se marchan de Hogwarts para iniciar su misión más importante: tienen que destruir los horrocruxes, el secreto del poder y la inmortalidad de Voldemort, en los que el temido mago oscuro guarda los fragmentos de su alma.
', 'ReliquiasDeLaMuerte.jpg', 'https://www.youtube.com/watch?v=GdNvFDzSNHQ', 14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Harry Potter y las Reliquias de la Muerte - Parte 2', 'Fantasía', 8, 150.00, '2 horas 10 minutos', 'Un enfrentamiento entre el bien y el mal espera cuando el joven Harry, Ron y Hermione se preparan para una última batalla en contra de Lord Voldemort, Harry se ha convertido en un joven fuerte que tiene la misión de librar al mundo del mal.
', 'ReliquiasDeLaMuerte2.jpg', 'https://www.youtube.com/watch?v=HguSMW8XveQ&t=3s',  14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Rescatando al Soldado Ryan', 'Drama', 21, 150.00, '2 horas 49 minutos', 'Después de desembarcar en Normandía, en plena Segunda Guerra Mundial, unos soldados norteamericanos deben arriesgar sus vidas para salvar al soldado James Ryan, cuyos tres hermanos han muerto en la guerra.
', 'SalvarAlSoladoRyan.jpg', 'https://www.youtube.com/watch?v=TAyhMtyup3o',  7);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Conjuro', 'Terror', 23, 250.00, '1 hora 52 minutos', 'A principios de los años 70, Ed y Lorrain Warren, reputados investigadores de fenómenos paranormales, se enfrentan a una entidad demoníaca al intentar ayudar a una familia que está siendo aterrorizada por una presencia oscura en su aislada granja.
', 'ElConjuro.jpg', 'https://www.youtube.com/watch?v=oUyHULb7xDI',  10);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Los Cazafantasmas', 'Comedia', 9, 30.00, '1 hora 45 minutos', 'Cuatro investigadores de sucesos paranormales desempleados crean una empresa en Nueva York con el propósito de limpiar la ciudad de fantasmas.
', 'Cazafantasmas.jpg', 'https://www.youtube.com/watch?v=nr3rshIFA_0',  28);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Club de los Cinco', 'Drama', 7, 300.00, '1 hora 37 minutos', 'Cinco adolescentes aprenden sobre respeto y entendimiento mutuo cuando tienen que pasar un sábado en detención.
', 'ClubDeLosCinco.jpg', 'https://www.youtube.com/watch?v=qtyZCg61INs',  16);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Bueno, el Malo y el Feo', 'Western', 8, 250.00, '2 horas 41 minutos', 'Tres hombres violentos pelean por una caja que alberga 200 000 dólares, la cual fue escondida durante la Guerra Civil. Dado que ninguno puede encontrar la tumba donde está el botín sin la ayuda de los otros dos, deben colaborar, pese a odiarse.
', 'ElBuenoElMalo.jpg', 'https://www.youtube.com/watch?v=exJOy6uTkek', 18);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Planeta de los Simios', 'Ciencia ficción', 8, 225.00, '1 hora 52 minutos', 'Un astronauta llega a un planeta del futuro, donde los simios son muy inteligentes y dominan a los humanos.
', 'PlanetaDeLosSimios.jpg', 'https://www.youtube.com/watch?v=hCXexl0Dlr0', 24);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('El Gran Torino', 'Drama', 14, 275.00, '1 hora 56 minutos', 'Walt Kowalski es un veterano de guerra duro e inflexible apasionado por su auto, un Gran Torino del 72. La llegada de unos inmigrantes asiáticos al barrio ablanda su carácter, pero unos pandilleros generan problemas y Walt se ve envuelto en ellos.
', 'GranTorino.jpg', 'https://www.youtube.com/watch?v=U_bZWFLTp-c', 14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Blade Runner', 'Ciencia ficción', 10, 300.00, '1 hora 57 minutos', 'En un futuro sombrío y lluvioso, un expolicía vuelve al servicio para buscar y destruir a un grupo de androides que fingen ser humanos para, integrados en la sociedad, encontrar a su creador y matarlo.
', 'BladeRunner.jpg', 'https://www.youtube.com/watch?v=OL5dD-EwcaU', 14);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Tiburón', 'Aventura', 13, 175.00, '2 horas 4 minutos', 'Un gigantesco tiburón blanco amenaza a los habitantes y turistas de un pueblo costero. El alcalde encomienda la caza del escualo al jefe de la policía, un pescador y un científico. El grupo se da cuenta de que es un animal inteligente y violento.
', 'Tiburon.jpg', 'https://www.youtube.com/watch?v=rqTjkKHh7xM',  29);
Insert into Producto (nombreProducto, genero, idCategoria, precio, duracion, sinopsis, portada, trailer,  idProveedor)
	value ('Queja', '', 15, 0.00, '0hora 0minutos', '', '', '', 30);

Select * from Producto;

-- ---------------------------------------------------------------------

Insert into Cesta (cantidad, fechaProducto, subtotal, idUsuario, idProducto)
	values(1, '2023-03-25', 100.55, 1, 1);
Insert into Cesta (cantidad, fechaProducto, subtotal, idUsuario, idProducto)
	values(1, '2023-05-09', 250.00, 2, 1);
    
-- ---------------------------------------------------------------------

Insert into Resena (fechaValoracion, calificacion, resena, idUsuario, idProducto)
	values('2020-07-15', 5, 'Una pelicula que realmente trata de manera inteligente a su audiencia, su historia es genial sin dejar de lado
     la animación y el arte que tiene, es una pelicula que vale totalmente la pena', 1, 1);
Insert into Resena (fechaValoracion, calificacion, resena, idUsuario, idProducto)
	values('2023-01-20', 4, 'Una pelicula que es buena aunque no supera a su antesesora, aunque con mayor presupuesto, el CGI de está
    entrega deja mucho que desear, llegando a parecer un videojuego en muchos momento, pero es muy disfrutable', 2, 2);

-- ---------------------------------------------------------------------

Insert into ServicioCliente (descripcion, idUsuario, idProducto)
	values('La pelicula no se me fue entregada en el plazo que establecio la plataforma', 1, 1);
Insert into ServicioCliente (descripcion, idUsuario, idProducto)
	values('El paquete en el que venía la pelicula llego dañado', 2, 2);

-- -------------------------------------------------------------------


Insert into Promocion (cartelPromocion,idCategoria,porcentajePromocion, fechaInicio, fechaFinal)
	values('Promocion1.gif','2',20, '2023-12-11', '2023-12-12');
Insert into Promocion (cartelPromocion,idCategoria,porcentajePromocion, fechaInicio, fechaFinal)
	values('Promocion3.png','8',50, '2023-12-27', '2023-12-31');
Insert into Promocion (cartelPromocion,idCategoria,porcentajePromocion, fechaInicio, fechaFinal)
	values('Promocion3.png','8',50, '2023-12-25', '2023-12-31');
  
-- La consulta verifica que la promocion que se muestre no este vencida
    
select * from Promocion where fechaInicio <= CURDATE() and CURDATE() <= fechaFinal;

-- -------- Borra toda promocion que este vencida ------------------

select idPromocion from Promocion where fechaFinal <= curdate();

-- -------------------------------------------------------------------

Insert into DetallePromocion (precioFinal, idPromocion, idProducto)
	values(75.41, 1, 1);
Insert into DetallePromocion (precioFinal, idPromocion, idProducto)
	values(225.00, 2, 2);

select * from Producto where idProducto = 12;

select * from Categoria where idCategoria = 8;

-- ---------------------------------------------------------------------

Insert into DetallePago(cantidad, idPago, idCesta)
	values(1, 1, 1);
Insert into DetallePago(cantidad, idPago, idCesta)
	values(1, 2, 2);

select * from Producto;
select * from Usuarios;
