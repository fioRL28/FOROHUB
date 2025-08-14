# Foro Hub - API REST

**Foro Hub** es un proyecto backend desarrollado en **Spring Boot**, que permite gestionar tópicos de un foro, donde los estudiantes pueden crear, leer, actualizar y eliminar preguntas vinculadas a cursos y usuarios.

---

## Tecnologías utilizadas
- Java 17  
- Spring Boot 3.5  
- Spring Data JPA  
- Spring Security  
- Spring Validation  
- MySQL (base de datos)  
- Flyway (migraciones)  
- Lombok  
- OpenAPI/Swagger (documentación de la API)  

---

## Funcionalidades
La API permite:  
1. **Crear un nuevo tópico** (`POST /topicos`)  
2. **Listar todos los tópicos** (`GET /topicos`)  
3. **Ver un tópico específico** (`GET /topicos/{id}`)  
4. **Actualizar un tópico** (`PUT /topicos/{id}`)  
5. **Eliminar un tópico** (`DELETE /topicos/{id}`)  

### Reglas de negocio
- Todos los campos son obligatorios: título, contenido, autor y curso.  
- No se permiten tópicos duplicados (mismo título y contenido).  
- Eliminación lógica mediante el campo `activo`.  
