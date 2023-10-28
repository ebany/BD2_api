USE `proyecto1` ;

ALTER TABLE `proyecto1`.`videojuego_genero`
ADD CONSTRAINT fk_videojuego_genero_Videojuego1
FOREIGN KEY (`Videojuego_idVideojuego`)
    REFERENCES `proyecto1`.`Videojuego` (`id`);

ALTER TABLE `proyecto1`.`plataforma_videojuego`
ADD CONSTRAINT fk_plataforma_videojuego_Videojuego1
FOREIGN KEY (`Videojuego_idVideojuego`)
    REFERENCES `proyecto1`.`Videojuego` (`id`);

ALTER TABLE `proyecto1`.`Language_supports`
ADD CONSTRAINT fk_a_videojuego_genero_Genero1
    FOREIGN KEY (`game`)
    REFERENCES `proyecto1`.`Videojuego` (`id`);

