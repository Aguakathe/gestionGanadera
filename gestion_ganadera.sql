-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS `gestion_ganadera` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `gestion_ganadera`;

-- Tabla: rol
CREATE TABLE IF NOT EXISTS `rol` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NOT NULL,
  `descripcion` VARCHAR(255) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC)
) ENGINE = InnoDB;

-- Tabla: usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `rol_id` INT NOT NULL,
  `nombre` VARCHAR(70) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `clave` VARCHAR(128) NOT NULL,
  `activo` BIT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`rol_id`) REFERENCES `rol`(`id`)
) ENGINE = InnoDB;

-- Tabla: ganadero
CREATE TABLE IF NOT EXISTS `ganadero` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(70) NOT NULL,
  `tipo_documento` VARCHAR(20) NOT NULL,
  `num_documento` VARCHAR(20) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `activo` BIT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`)
) ENGINE = InnoDB;

-- Tabla: ganado
CREATE TABLE IF NOT EXISTS `ganado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ganadero_id` INT NOT NULL,
  `numero_identificacion` VARCHAR(50) NOT NULL,
  `raza` VARCHAR(50) NOT NULL,
  `edad` INT NOT NULL,
  `peso` DECIMAL(10,2) NOT NULL,
  `vacunado` BIT(1) NOT NULL DEFAULT 0,
  `fecha_registro` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`ganadero_id`) REFERENCES `ganadero`(`id`)
) ENGINE = InnoDB;

-- Tabla: transaccion
CREATE TABLE IF NOT EXISTS `transaccion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ganadero_id` INT NOT NULL,
  `tipo_transaccion` ENUM('compra', 'venta') NOT NULL,
  `fecha` DATETIME NOT NULL,
  `total` DECIMAL(10,2) NOT NULL,
  `estado` VARCHAR(20) NOT NULL DEFAULT 'completada',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`ganadero_id`) REFERENCES `ganadero`(`id`)
) ENGINE = InnoDB;

-- Tabla: detalle_transaccion
CREATE TABLE IF NOT EXISTS `detalle_transaccion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `transaccion_id` INT NOT NULL,
  `ganado_id` INT NOT NULL,
  `precio_unitario` DECIMAL(10,2) NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`transaccion_id`) REFERENCES `transaccion`(`id`),
  FOREIGN KEY (`ganado_id`) REFERENCES `ganado`(`id`)
) ENGINE = InnoDB;
 