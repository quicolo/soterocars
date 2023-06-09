insert into empresas (cif, denominacion_social, domicilio, fecha_constitucion, direccion_web, telefono, email) values ('S4111001F', 'SoteroCars', 'C/ Santo Domingo de Guzmán, S/N', '2023-04-11', 'https://iessoterohernandez.es/', '955622674', '');
insert into sedes (nombre, domicilio, fecha_apertura, direccion_web, telefono, email, horario, empresa_id) values ('San Juan', 'C/ Santo Domingo de Guzmán, S/N', '2023-04-11', 'https://iessoterohernandez.es/', '955622674', '', 'L-V: 8:00-19:00 y S-D: 8:00-15:00', 1);

insert into perfiles_usuario (nombre, descripcion, codigo_perfil) values ('Administrador', 'Administrador del sistema', 'ROLE_ADMINISTRADOR');
insert into perfiles_usuario (nombre, descripcion, codigo_perfil) values ('Operario', 'Operario de una sede', 'ROLE_OPERARIO');
insert into perfiles_usuario (nombre, descripcion, codigo_perfil) values ('Cliente', 'Cliente particular', 'ROLE_CLIENTE');
insert into perfiles_usuario (nombre, descripcion, codigo_perfil) values ('Bot', 'Cliente automático de una empresa colaboradora', 'ROLE_BOT');

insert into usuarios (nombre, password, cuenta_expirada, cuenta_bloqueada, password_expirado, cuenta_activa, perfil_id) values ('jgallardo', 'passOperario', false, false, false, true, 2);
insert into empleados (dni, nombre, apellido1, apellido2, telefono, domicilio, salario, email, fecha_contratacion, fecha_cese, trabaja_en_sede_id, usuario_id) values ('53523597K', 'Juan', 'Gallardo', 'Parra', '654987123', '', '1200', '', '2023-04-11', null, 1, 1);

insert into usuarios (nombre, password, cuenta_expirada, cuenta_bloqueada, password_expirado, cuenta_activa, perfil_id) values ('agavilan', 'passCliente', false, false, false, true, 3);
insert into clientes (dni, nombre, apellido1, apellido2, telefono, domicilio, email, fecha_alta, fecha_baja, usuario_id) values ('29804815N', 'Ana', 'Gavilán', 'Romero', '688745157', '', 'anagavilan@gmail.com', '2023-04-11', null, 2);

insert into tipos_vehiculo (nombre, descripcion) values ('Económico', 'Vehículos de gama baja-media');
insert into tarifas_tipo_vehiculo (nombre, descripcion, fecha_inicio_aplicacion, fecha_fin_aplicacion, precio_por_dia, precio_por_hora, limite_kilometraje, tipo_vehiculo_id) values ('Económica', 'Tarifa para vehículos con categoría económica', '2023-04-11', null, 70, 3, 500, 1);
insert into tipos_caracteristica_vehiculo (nombre) values ('Número de pasajeros');
insert into tipos_caracteristica_vehiculo (nombre) values ('Número de puertas');
insert into tipos_caracteristica_vehiculo (nombre) values ('Tipo de motor');
insert into tipos_caracteristica_vehiculo (nombre) values ('Caja de cambios');
insert into vehiculos (matricula, marca, modelo, fecha_alta, fecha_baja, tipo_vehiculo_id) values ('1234-FRT', 'Fiat', '500 XL', '2023-04-11', null, 1);
insert into caracteristicas_vehiculo (vehiculo_id, tipo_caracteristica_id, valor) values (1, 1, '5');
insert into caracteristicas_vehiculo (vehiculo_id, tipo_caracteristica_id, valor) values (1, 2, '5');
insert into caracteristicas_vehiculo (vehiculo_id, tipo_caracteristica_id, valor) values (1, 3, 'Gasolina');
insert into caracteristicas_vehiculo (vehiculo_id, tipo_caracteristica_id, valor) values (1, 4, 'Manual');

insert into tipos_estado_reserva (nombre, descripcion) values ('Activa', 'Reserva activa aún no confirmada con un alquiler');
insert into tipos_estado_reserva (nombre, descripcion) values ('Anulada', 'Reserva anulada por el cliente');
insert into tipos_estado_reserva (nombre, descripcion) values ('Confirmada', 'Reserva confirmada tras firmarse el contrato de alquiler en una sede');
insert into reservas (vehiculo_id, cliente_id, estado_id, sede_recogida_id, sede_devolucion_id, fecha_hora_recogida, fecha_hora_devolucion, fecha_hora_creacion, fecha_hora_modificacion) values (1, 1, 1, 1, 1, '2023-04-14 09:00:00', '2023-04-15 09:00:00', now(), null);


insert into tipos_estado_alquiler (nombre, descripcion) values ('En curso', 'Contrato firmado y vehículo entregado al cliente');
insert into tipos_estado_alquiler (nombre, descripcion) values ('Devuelto', 'Vehículo devuelto por el cliente');
insert into tipos_estado_alquiler (nombre, descripcion) values ('Revisión superada', 'Vehículo devuelto y revisión superada sin incidencias');
insert into tipos_estado_alquiler (nombre, descripcion) values ('Revisión no superada', 'Vehículo devuelto y revisión no superada (con incidencias)');
insert into tipos_estado_alquiler (nombre, descripcion) values ('No devuelto', 'Se supera la fecha de devolución pactada y no se puede contactar con el cliente');
insert into alquileres (vehiculo_id, cliente_id, empleado_id, reserva_id, sede_recogida_id, sede_devolucion_id, fecha_hora_recogida, fecha_hora_devolucion, fecha_hora_creacion, fecha_hora_modificacion) values (1, 1, 1, 1, 1, 1, '2023-04-14 09:00:00', '2023-04-15 09:00:00', now(), null);
insert into estados_alquiler (alquiler_id, estado_id, fecha_hora) values (1, 1, '2023-04-14 09:00:00');
insert into estados_alquiler (alquiler_id, estado_id, fecha_hora) values (1, 2, '2023-04-15 09:00:00');
insert into estados_alquiler (alquiler_id, estado_id, fecha_hora) values (1, 3, '2023-04-15 09:05:00');
