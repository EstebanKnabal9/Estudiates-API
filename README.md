🎓 Sistema de Gestión de Estudiantes

¡Hola! 👋
Este proyecto es una aplicación para gestionar estudiantes — básicamente puedes agregar, ver, editar y eliminar estudiantes desde una interfaz hecha con Angular, y un backend REST con Spring Boot.
Es simple, pero funcional y bien estructurado.

🚀 De qué va el proyecto

Este sistema tiene dos partes principales:

🧩 Backend (Spring Boot)

Una API REST que maneja todo lo relacionado con los estudiantes.
Permite:

Crear nuevos estudiantes

Consultar la lista completa

Editar y eliminar estudiantes

Usar una base de datos en memoria (H2)

Validar los datos y responder con mensajes claros en formato JSON

💻 Frontend (Angular)

Una interfaz amigable para interactuar con la API.
Incluye:

Una tabla con los estudiantes registrados

Formularios para crear o editar

Botones con confirmación para eliminar

Mensajes de éxito y error

Diseño responsive con Bootstrap

🧠 Tecnologías usadas

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
## Si
 algo no funciona

### El puerto 8081 está ocupado
```bash
# Ver qué está usando el puerto
lsof -i :8081
# Matar el proceso
kill -9 <PID>
```

O simplemente cambia el puerto en `backend/src/main/resources/application.properties`:
```properties
server.port=8082
```

Y actualiza la URL en el frontend (`frontend/src/app/services/estudiante.service.ts`):
```typescript
private apiUrl = 'http://localhost:8082/api/estudiantes';
```

### Problemas con Java
Si te dice que no encuentra Java o que la versión está mal:
```bash
java -version  # Debería decir Java 17
```

Si no tienes Java 17, instálalo:
```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

### Problemas con Node.js
Si tienes una versión vieja de Node.js:
```bash
nvm install 21
nvm use 21
```

## Qué se podría mejorar

Si quisieras seguir desarrollando esto, podrías agregar:
- Login y usuarios
- Paginación (si tienes muchos estudiantes)
- Búsqueda y filtros
- Exportar a Excel
- Tests (que siempre están bien)
- Docker para que sea más fácil de correr

## Resumen

Básicamente armamos una app completa para manejar estudiantes. El backend es una API REST con Spring Boot que guarda todo en una base de datos H2. El frontend es una interfaz en Angular que se ve bien y es fácil de usar.

Todo funciona, cumple los requisitos y hasta agregamos algunas cosas extra. No está mal para un proyecto de demostración.

---

Si tienes dudas o algo no funciona, revisa los logs de la consola o pregunta.