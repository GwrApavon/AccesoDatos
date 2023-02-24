-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-02-2023 a las 11:45:27
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
  MODIFY `id_difunto` int(4) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `responsable`
--
ALTER TABLE `responsable`
  MODIFY `id_responsable` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `sepultura`
--
ALTER TABLE `sepultura`
  MODIFY `id_sepultura` int(4) NOT NULL AUTO_INCREMENT;
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
