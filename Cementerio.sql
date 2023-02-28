-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 28-02-2023 a las 08:04:01
-- Versión del servidor: 5.7.11-0ubuntu6
-- Versión de PHP: 7.0.4-7ubuntu2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `Cementerio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `difunto`
--

CREATE TABLE `difunto` (
  `id_difunto` int(4) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido1` varchar(30) NOT NULL,
  `apellido2` varchar(30) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `fecha_defuncion` date DEFAULT NULL,
  `fecha_enterramiento` date DEFAULT NULL,
  `id_sepultura` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `difunto`
--

INSERT INTO `difunto` (`id_difunto`, `nombre`, `apellido1`, `apellido2`, `fecha_nacimiento`, `fecha_defuncion`, `fecha_enterramiento`, `id_sepultura`) VALUES
(1, 'José', 'Perez', 'Palomares', NULL, '2023-02-16', NULL, 1),
(4, 'Pepito', 'Sierra', NULL, NULL, NULL, NULL, 2),
(5, 'Anton', 'Pirulero', NULL, NULL, NULL, NULL, 3),
(6, 'Martin', 'Lopez', NULL, NULL, NULL, NULL, 4),
(7, 'Leonor', 'Pans', NULL, NULL, NULL, NULL, 5),
(8, 'Martin', 'Lopez', NULL, NULL, NULL, NULL, 6),
(9, 'Leonor', 'Pans', NULL, NULL, NULL, NULL, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `responsable`
--

CREATE TABLE `responsable` (
  `id_responsable` int(4) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido1` varchar(30) NOT NULL,
  `apellido2` varchar(30) DEFAULT NULL,
  `cuenta_domiciliacion` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `responsable`
--

INSERT INTO `responsable` (`id_responsable`, `nombre`, `apellido1`, `apellido2`, `cuenta_domiciliacion`) VALUES
(4, 'Adolfo', 'Pérez', 'Antolín', 'ES852086101020203030'),
(5, 'Genaro', 'Martín', 'Pescador', 'ES852087101020203030'),
(6, 'Pepe', 'Pòtamo', 'Pótamo', 'ES852087101020203030'),
(7, 'Luís', 'Alto', 'Llano', 'ES852088101020203030'),
(8, 'Juanillo', 'Pardo', 'Oscuro', 'ES852089101020203030'),
(9, 'Antón', 'Pirulero', 'Fresco', 'ES852090101020203030'),
(10, 'Perico', 'Delos', 'Palotes', 'ES852092101020203030'),
(11, 'Manolo', 'Eldel', 'Bombo', 'ES852093101020203030'),
(12, 'Paco', 'León', 'Fierro', 'ES852089401020203030'),
(13, 'Juan', 'Martín', 'Pescador', 'ES852095101020203030');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sepultura`
--

CREATE TABLE `sepultura` (
  `id_sepultura` int(4) NOT NULL,
  `codigo_contable` varchar(10) NOT NULL,
  `calle` varchar(2) NOT NULL,
  `num_sepultura` int(4) NOT NULL,
  `nombre_titular` varchar(30) NOT NULL,
  `apellido1_titular` varchar(30) NOT NULL,
  `apellido2_titular` varchar(30) DEFAULT NULL,
  `tipo_contrato` varchar(20) NOT NULL,
  `observaciones` varchar(200) DEFAULT NULL,
  `id_responsable` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sepultura`
--

INSERT INTO `sepultura` (`id_sepultura`, `codigo_contable`, `calle`, `num_sepultura`, `nombre_titular`, `apellido1_titular`, `apellido2_titular`, `tipo_contrato`, `observaciones`, `id_responsable`) VALUES
(1, '1234567890', '1b', 5, 'Manuel', 'Blasco', 'López', 'Temporal', NULL, 4),
(2, '2345678901', '1b', 6, 'Tono', 'Agudo', 'Simple', 'Perpetua', NULL, 5),
(3, '3456789012', '1b', 4, 'Loco', 'Mía', 'Sebastián', 'Temporal', NULL, 6),
(4, '4567890123', '1b', 1, 'Lirio', 'Del', 'Campo', 'Perpetua', NULL, 13),
(5, '5678901234', '1b', 2, 'Jazmín', 'Bueno', 'Olorosa', 'Temporal', NULL, 7),
(6, '6789012345', '1b', 1, 'Lirio', 'Del', 'Campo', 'Perpetua', NULL, 8),
(7, '7890123456', '1b', 10, 'Julián', 'Jolín', 'Saco', 'Temporal', NULL, 10);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `difunto`
--
ALTER TABLE `difunto`
  ADD PRIMARY KEY (`id_difunto`),
  ADD UNIQUE KEY `id_difunto` (`id_difunto`),
  ADD UNIQUE KEY `id_sepultura` (`id_sepultura`);

--
-- Indices de la tabla `responsable`
--
ALTER TABLE `responsable`
  ADD PRIMARY KEY (`id_responsable`),
  ADD UNIQUE KEY `id_responsable` (`id_responsable`),
  ADD UNIQUE KEY `id_responsable_2` (`id_responsable`);

--
-- Indices de la tabla `sepultura`
--
ALTER TABLE `sepultura`
  ADD PRIMARY KEY (`id_sepultura`),
  ADD UNIQUE KEY `id_sepultura` (`id_sepultura`),
  ADD UNIQUE KEY `id_responsable` (`id_responsable`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `difunto`
--
ALTER TABLE `difunto`
  MODIFY `id_difunto` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `responsable`
--
ALTER TABLE `responsable`
  MODIFY `id_responsable` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT de la tabla `sepultura`
--
ALTER TABLE `sepultura`
  MODIFY `id_sepultura` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `difunto`
--
ALTER TABLE `difunto`
  ADD CONSTRAINT `difunto_ibfk_1` FOREIGN KEY (`id_sepultura`) REFERENCES `sepultura` (`id_sepultura`);

--
-- Filtros para la tabla `sepultura`
--
ALTER TABLE `sepultura`
  ADD CONSTRAINT `sepultura_ibfk_1` FOREIGN KEY (`id_responsable`) REFERENCES `responsable` (`id_responsable`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
