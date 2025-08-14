
CREATE TABLE usuarios (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          nombre VARCHAR(100) NOT NULL,
                          correo VARCHAR(100) NOT NULL UNIQUE,
                          contrasena VARCHAR(255) NOT NULL
);


CREATE TABLE cursos (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(100) NOT NULL,
                        categoria VARCHAR(100)
);


CREATE TABLE topicos (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         titulo VARCHAR(200) NOT NULL,
                         mensaje TEXT NOT NULL,
                         fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         status VARCHAR(20) DEFAULT 'ACTIVO',
                         autor_id BIGINT NOT NULL,
                         curso_id BIGINT NOT NULL,
                         FOREIGN KEY (autor_id) REFERENCES usuarios(id),
                         FOREIGN KEY (curso_id) REFERENCES cursos(id)
);


CREATE TABLE respuestas (
                            id BIGINT AUTO_INCREMENT PRIMARY KEY,
                            mensaje TEXT NOT NULL,
                            fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                            solucion BOOLEAN DEFAULT FALSE,
                            topico_id BIGINT NOT NULL,
                            autor_id BIGINT NOT NULL,
                            FOREIGN KEY (topico_id) REFERENCES topicos(id),
                            FOREIGN KEY (autor_id) REFERENCES usuarios(id)
);
