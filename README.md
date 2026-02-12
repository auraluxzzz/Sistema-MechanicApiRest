📋 Resumen del Proyecto: MechanicApiRest
Este es un API REST desarrollado con Spring Boot para gestionar un catálogo de productos de 
repuestos automotrices o taller mecánico.

🎯 Propósito Principal:
El proyecto permite administrar un inventario de productos automotrices organizados por:

-Marcas (Brands) - ej: Toyota, Honda, Ford
-Modelos de vehículos (CarModels) - ej: Corolla, Civic, Mustang
-Líneas de vehículos (LineCars) - ej: Sedán, SUV, Pickup

🏗️ Arquitectura:

-Tecnología: Spring Boot 3.5.5 con Java 21
-Base de datos: MySQL (dbmechanic2024043)
-Patrón: MVC con arquitectura por capas
-Puerto: 8000

📦 Entidades Principales:

-Brand (Marcas de vehículos)
-CarModel (Modelos de vehículos)
-LineCar (Líneas/tipos de vehículos)
-Product (Productos/repuestos) - con precios por unidad, docena y flota

🔌 Funcionalidades (CRUD completo):
Cada entidad tiene endpoints REST para:

-GET / - Listar todos
-GET /{id} - Buscar por ID
-POST / - Crear nuevo
-PUT /{id} - Actualizar
-DELETE /{id} - Eliminar

💡 Casos de Uso:

-Gestión de inventario de repuestos
-Catálogo de productos por marca/modelo de vehículo
-Control de precios diferenciados (unidad/docena/flota)
-Sistema de consulta para talleres mecánicos

Este proyecto serviría perfectamente para un taller mecánico, distribuidora de repuestos,
o plataforma de e-commerce de autopartes que necesite organizar sus productos por compatibilidad 
con diferentes vehículos.
