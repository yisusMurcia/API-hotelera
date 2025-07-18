﻿# API-hotelera
Jesús Antonio Murcia 20241020016
Didier Stiveen Torres Gil 20241020023


## Administrator /admins
Ruta que permite acceder a los datos de todos administradores de la API.

- /getAll: Retorna todos los administradores de la API.
- /get/{id}: Retorna un administrador por su id.
- /delete/{id}: Elimina un administrador por su id, se establece como nulo su id en usuarios.
- /update/{id}: Actualiza un administrador por su id.
- /create: Crea un nuevo administrador.

## Bill /bills
Ruta que permite acceder a los datos de todas las facturas de la API.
- /getAll: Retorna todas las facturas de la API.
- /get/{id}: Retorna una factura por su id.
- /delete/{id}: Elimina una factura por su id.
- /update/{id}: Actualiza una factura por su id.
- /create: Crea una nueva factura.

## Client /clients
Ruta que permite acceder a los datos de todos los clientes de la API.
- /getAll: Retorna todos los clientes de la API.
- /get/{id}: Retorna un cliente por su id.
- /delete/{id}: Elimina un cliente por su id, se establece como nulo su id en usuario.
- /update/{id}: Actualiza un cliente por su id.
- /create: Crea un nuevo cliente.

## Employee /employees
Ruta que permite acceder a los datos de todos los empleados de la API.
- /getAll: Retorna todos los empleados de la API.
- /get/{id}: Retorna un empleado por su id.
- /delete/{id}: Elimina un empleado por su id, se establece como nulo su id en usuario.
- /update/{id}: Actualiza un empleado por su id.
- /create: Crea un nuevo empleado.

## General Administrator /generalAdmins
Ruta que permite acceder a los datos de todos los administradores generales de la API.
- /getAll: Retorna todos los administradores generales de la API.
- /get/{id}: Retorna un administrador general por su id.
- /delete/{id}: Elimina un administrador por su id.
- /update/{id}: Actualiza un administrador general por su id.
- /create: Crea un nuevo administrador general.

## Hotel /hotels
Ruta que permite acceder a los datos de todos los hoteles de la API.
- /getAll: Retorna todos los hoteles de la API.
- /get/{id}: Retorna un hotel por su id.
- /delete/{id}: Elimina un hotel por su id.
- /update/{id}: Actualiza un hotel por su id.
- /create: Crea un nuevo hotel.

## Payment /payments
Ruta que permite acceder a los datos de todos los pagos de la API.
- /getAll: Retorna todos los pagos de la API.
- /get/{id}: Retorna un pago por su id.
- /delete/{id}: Elimina un pago por su id.
- /update/{id}: Actualiza un pago por su id.
- /create: Crea un nuevo pago.

## Reservation /reservations
Ruta que permite acceder a los datos de todas las reservas de la API.
- /getAll: Retorna todas las reservas de la API.
- /get/{id}: Retorna una reserva por su id.
- /delete/{id}: Elimina una reserva por su id.
- /update/{id}: Actualiza una reserva por su id.
- /create: Crea una nueva reserva.
- /getByUser/{id}: retorna las reservas asociadas a un usuario
## Room /rooms
Ruta que permite acceder a los datos de todas las habitaciones de la API.
- /getAll: Retorna todas las habitaciones de la API.
- /get/{id}: Retorna una habitación por su id.
- /delete/{id}: Elimina una habitación por su id.
- /update/{id}: Actualiza una habitación por su id.
- /create: Crea una nueva habitación.

## RoomType /roomTypes
Ruta que permite acceder a los datos de todos los tipos de habitaciones de la API.
- /getAll: Retorna todos los tipos de habitaciones de la API.
- /get/{id}: Retorna un tipo de habitación por su id.
- /delete/{id}: Elimina un tipo de habitación por su id.
- /update/{id}: Actualiza un tipo de habitación por su id.
- /create: Crea un nuevo tipo de habitación.

## User /users
Ruta que permite acceder a los datos de todos los usuarios de la API.
- /getAll: Retorna todos los usuarios de la API.
- /get/{id}: Retorna un usuario por su id.
- /delete/{id}: Elimina un usuario por su id.
- /update/{id}: Actualiza un usuario por su id.
- /create: Crea un nuevo usuario.

