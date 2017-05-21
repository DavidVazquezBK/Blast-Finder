
//ultimomovimiento
select `blastfinder`.`movimiento`.`idMovimiento` AS `idMovimiento`,`blastfinder`.`movimiento`.`Material_idMaterial` AS `Material_idMaterial`,`blastfinder`.`movimiento`.`Ubicacion_idUbicacion` AS `Ubicacion_idUbicacion`,`blastfinder`.`movimiento`.`fechaHora` AS `fechaHora` from `blastfinder`.`movimiento` where `blastfinder`.`movimiento`.`fechaHora` in (select max(`blastfinder`.`movimiento`.`fechaHora`) from `blastfinder`.`movimiento` group by `blastfinder`.`movimiento`.`Material_idMaterial`) order by `blastfinder`.`movimiento`.`Material_idMaterial`
//ultimomovimientonombres
SELECT ultimomovimiento.idMovimiento as 'id', material.nombre as 'material', ubicacion.nombre as 'ubicacion', ultimomovimiento.fechaHora FROM `ultimomovimiento`, ubicacion, material WHERE ubicacion.idUbicacion=ultimomovimiento.Ubicacion_idUbicacion AND material.idMaterial=ultimomovimiento.Material_idMaterial ORDER BY `ultimomovimiento`.`fechaHora` DESC
