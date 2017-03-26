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
(1,'TAPETE 1X1M ROSA AFELPADO', 2,`TAP-ROS-1X1`),
(2,'TAPETE 1X1M VERDE AFELPADO', 2,`TAP-VRD-1X1`),
(3,'TAPETE 2X1M AZUL', 2,`TAP-AZL-2X1`),
(4,'EPSON 20 LUMENES 20 WATTS FULL HD', 1,`EPSN-20LUM-FHD`),
(5,'CASIO 15 LUMENES 50 WATTS HD', 1,`CSIO-15LUM-HD`),
(6,'MESABANCO CAFE CON PALETA RETRACTIL', 3,`MBCO-PLTA`),
(7,'MESABANCO NEGRO METAL CON PORTAVASOS', 4,`MBCO-PVSOS`);

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `material` (`idMaterial`, `notas`,`Categoria_idCategoria`,`iniciales`) VALUES

('MESABANCO CAFE CON PALETA RETRACTIL', 3,`MBCO-PLTA`),
('MESABANCO NEGRO METAL CON PORTAVASOS', 4,`MBCO-PVSOS`);
