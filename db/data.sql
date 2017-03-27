USE blastfinder;
--
-- Base de datos: `blastfinder`
--

--
-- Volcado de datos para la tabla `categoria`
--


INSERT INTO `categoria` (`idCategoria`,`nombre`, `iniciales`) VALUES
(1,'Proyector', 'PROY'),
(2,'Tapete', 'TAPE'),
(3,'Mobiliario', 'MOBI');

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`,`nombre`, `Categoria_idCategoria`,`iniciales`) VALUES
(1,'TAPETE 1X1M VERDE AFELPADO', 2,'TAP-VRD-1X1'),
(2,'TAPETE 2X1M AZUL', 2,'TAP-AZL-2X1'),
(3,'EPSON 20 LUMENES 20 WATTS FULL HD', 1,'EPSN-20LUM-FHD'),
(4,'CASIO 15 LUMENES 50 WATTS HD', 1,'CSIO-15LUM-HD'),
(5,'MESABANCO CAFE CON PALETA RETRACTIL', 3,'MBCO-PLTA'),
(6,'MESABANCO NEGRO METAL CON PORTAVASOS', 3,'MBCO-PVSO');

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`idMaterial`, `Producto_idProducto`,`notas`) VALUES
(1,1,'Está desgastado de los lados'),
(2,1,'Un poco roto'),
(3,1,'En buen estado'),
(4,2,'Una mitad se ve azul y la otra blanca'),
(5,2,'Un poco dañado pero sirve bien'),
(6,2,'Hay que repararlo, está partido en 2'),
(7,3,'Aveces se apaga de la nada'),
(8,3,'No tiene cable de alimentación'),
(9,3,'Rayado y con estickers'),
(10,4,'No prende'),
(11,4,'Se traba al conectar VGA'),
(12,4,'No prende'),
(13,5,'Tiene chicles debajo'),
(14,5,'Una pata está rota'),
(15,5,'Rechina mucho'),
(16,6,'Ya no tiene paleta'),
(17,6,'El portavasos está sucio'),
(18,6,'Se robaron el portavasos');

--
-- Volcado de datos para la tabla `ubicacion`
--

INSERT INTO `ubicacion` (`idUbicacion`, `nombre`, `descripcion`) VALUES
(1, 'Salón 101', 'Se imparten clases de ingles'),
(2, 'Salón 102', 'Se imparten clases de física'),
(3, 'Salón 103', 'Se encuentra en remodelación'),
(4, 'Salón 201', 'Contiene todo el material de ensamble'),
(5, 'Salón 202', 'Contiene todas las computadoras'),
(6, 'Dirección', 'Dirección general de la institución'),
(7, 'Patio', 'Area de relajamiento'),
(8, 'Bodega', 'Se encuentran materiales dañados y almacenados');

--
-- Volcado de datos para la tabla `material_has_ubicacion`
--

insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (1, 2, 5, '2015-08-28 00:24:15');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (2, 16, 8, '2015-01-14 16:39:49');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (3, 12, 8, '2015-03-13 13:37:19');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (4, 16, 4, '2016-07-05 06:19:19');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (5, 1, 5, '2016-02-23 11:01:35');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (6, 18, 4, '2015-08-26 15:12:25');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (7, 12, 5, '2015-04-16 05:52:17');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (8, 14, 5, '2016-10-03 23:56:47');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (9, 16, 6, '2016-11-23 12:07:48');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (10, 9, 5, '2016-03-26 13:13:49');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (11, 10, 3, '2015-07-09 01:48:09');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (12, 12, 3, '2015-03-13 00:56:58');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (13, 13, 4, '2015-12-02 12:14:48');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (14, 14, 3, '2015-05-18 16:00:58');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (15, 4, 5, '2015-06-03 02:30:31');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (16, 10, 2, '2016-12-04 23:40:07');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (17, 18, 2, '2016-10-19 03:45:31');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (18, 2, 4, '2015-02-20 07:00:31');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (19, 10, 7, '2015-06-03 12:40:59');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (20, 15, 1, '2016-09-04 20:13:31');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (21, 13, 2, '2015-05-27 10:27:18');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (22, 5, 1, '2015-02-16 22:28:29');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (23, 17, 7, '2015-08-16 08:36:08');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (24, 8, 7, '2015-01-08 14:10:49');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (25, 12, 6, '2015-03-11 02:33:36');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (26, 17, 3, '2015-09-17 21:19:56');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (27, 16, 3, '2016-08-21 02:48:31');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (28, 18, 8, '2016-06-05 14:48:17');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (29, 12, 1, '2015-11-14 04:22:07');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (30, 15, 4, '2016-10-26 08:31:52');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (31, 17, 6, '2017-01-03 04:18:51');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (32, 3, 1, '2015-10-27 01:51:27');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (33, 15, 6, '2016-01-15 03:16:52');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (34, 2, 4, '2015-10-28 10:36:16');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (35, 2, 1, '2016-03-15 21:38:50');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (36, 8, 6, '2015-02-04 17:50:45');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (37, 7, 1, '2015-09-08 10:14:54');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (38, 10, 2, '2016-10-14 19:28:21');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (39, 7, 7, '2016-08-13 02:59:04');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (40, 14, 5, '2016-01-05 22:56:51');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (41, 11, 3, '2015-08-27 23:53:39');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (42, 16, 8, '2015-01-23 22:32:19');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (43, 7, 1, '2015-03-15 16:04:15');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (44, 1, 2, '2016-09-07 22:44:38');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (45, 15, 6, '2015-01-21 06:04:58');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (46, 9, 6, '2016-12-20 14:03:49');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (47, 2, 6, '2015-08-31 20:18:32');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (48, 1, 5, '2016-10-26 09:17:57');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (49, 10, 6, '2015-01-04 22:59:57');
insert into Movimiento (idMovimiento, Material_idMaterial, Ubicacion_idUbicacion, fechaHora) values (50, 18, 3, '2015-09-20 23:32:22');
