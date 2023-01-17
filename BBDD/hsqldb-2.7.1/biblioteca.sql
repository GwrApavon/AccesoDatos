-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 16-11-2022 a las 10:51:05
-- Versión del servidor: 5.7.11-0ubuntu6
-- Versión de PHP: 7.0.4-7ubuntu2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `biblioteca`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `Codigo` int(11) NOT NULL,
  `Titulo` varchar(30) DEFAULT NULL,
  `Autor` varchar(30) DEFAULT NULL,
  `Editorial` varchar(30) DEFAULT NULL,
  `Agno` int(11) DEFAULT NULL,
  `ISBN` varchar(30) NOT NULL,
  `NEjemplares` int(11) DEFAULT NULL,
  `Npaginas` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `libro`
--

INSERT INTO `libro` (`Codigo`, `Titulo`, `Autor`, `Editorial`, `Agno`, `ISBN`, `NEjemplares`, `Npaginas`) VALUES
(1, 'La historia interminable', 'Edwing Flin', 'Santillana', 1978, '232323', 3, 123),
(2, 'Software hoy', 'Mary Lewis', 'Garceta', 2003, '1213123', 4, 333),
(3, 'El hombre solitario', 'Richard ', 'Garceta', 2004, '23232', 2, 123),
(4, 'Siguiendo la pista', 'Galileo Galiley', 'Rama', 1678, '3984-234', 1, 344),
(5, 'IT', 'Michael', 'Suspense', 1998, '23492-3', 1, 250),
(6, 'El pesado de turno', 'Miguel Poveda', 'Santana', 1999, '739-3479', 2, 129);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

CREATE TABLE `prestamo` (
  `Clibro` int(11) NOT NULL,
  `Csocio` int(11) NOT NULL,
  `Finio` date DEFAULT NULL,
  `Ffin` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prestamo`
--

INSERT INTO `prestamo` (`Clibro`, `Csocio`, `Finio`, `Ffin`) VALUES
(2, 2, '2020-09-01', '2020-09-09'),
(2, 4, '2020-11-01', '2020-11-24'),
(3, 3, '2020-11-17', '2020-11-30'),
(4, 1, '2020-11-04', '2020-11-17'),
(5, 1, '2020-11-18', '2020-12-15'),
(6, 4, '2020-10-12', '2020-10-28');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `socio`
--

CREATE TABLE `socio` (
  `Codigo` int(11) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `Apellidos` varchar(30) DEFAULT NULL,
  `FNacimiento` date DEFAULT NULL,
  `Domicilio` varchar(30) DEFAULT NULL,
  `Telefono` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `socio`
--

INSERT INTO `socio` (`Codigo`, `Nombre`, `Apellidos`, `FNacimiento`, `Domicilio`, `Telefono`) VALUES
(1, 'Perico', 'Los Palotes', '2000-02-23', 'C- La manzana', 3344555),
(2, 'Mariana', 'Ozores', '1987-03-12', 'Plaza España', 23424),
(3, 'Ana', 'Smith', '1999-12-02', 'C/ El melon', 3434344),
(4, 'José ', 'Pérez', '2002-02-01', 'C/ Espaguetis', 34234267);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`Codigo`),
  ADD UNIQUE KEY `ISBN` (`ISBN`);

--
-- Indices de la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD PRIMARY KEY (`Clibro`,`Csocio`),
  ADD KEY `Csocio` (`Csocio`);

--
-- Indices de la tabla `socio`
--
ALTER TABLE `socio`
  ADD PRIMARY KEY (`Codigo`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `prestamo`
--
ALTER TABLE `prestamo`
  ADD CONSTRAINT `prestamo_ibfk_1` FOREIGN KEY (`Csocio`) REFERENCES `socio` (`Codigo`),
  ADD CONSTRAINT `prestamo_ibfk_2` FOREIGN KEY (`Clibro`) REFERENCES `libro` (`Codigo`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
