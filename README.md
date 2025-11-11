## 🎓 Sistema de Gestión de Estudiantes

¡Hola! 👋
Este proyecto es una aplicación para gestionar estudiantes — básicamente puedes agregar, ver, editar y eliminar estudiantes desde una interfaz hecha con Angular, y un backend REST con Spring Boot.
Es simple, pero funcional y bien estructurado.

## 🚀 De qué va el proyecto

Este sistema tiene dos partes principales:

## 🧩 Backend (Spring Boot)

Una API REST que maneja todo lo relacionado con los estudiantes.
Permite:

Crear nuevos estudiantes

Consultar la lista completa

Editar y eliminar estudiantes

Usar una base de datos en memoria (H2)

Validar los datos y responder con mensajes claros en formato JSON

## 💻 Frontend (Angular)

Una interfaz amigable para interactuar con la API.
Incluye:

Una tabla con los estudiantes registrados

Formularios para crear o editar

Botones con confirmación para eliminar

Mensajes de éxito y error

Diseño responsive con Bootstrap

## 🧠 Tecnologías usadas

Backend:

Java 17

Spring Boot 3.5.7

H2 Database (en memoria, perfecta para pruebas)

Lombok (para reducir código repetitivo)

MapStruct (para mapear entidades a DTOs fácilmente)

Frontend:

Angular (versión actual)

Node.js 21

Bootstrap 5

TypeScript

## Resumen

Básicamente armamos una app completa para manejar estudiantes. El backend es una API REST con Spring Boot que guarda todo en una base de datos H2.
