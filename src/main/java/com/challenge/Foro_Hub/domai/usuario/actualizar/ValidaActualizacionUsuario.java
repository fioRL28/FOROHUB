package com.challenge.Foro_Hub.domai.usuario.actualizar;

import com.challenge.Foro_Hub.controller.ValidarActualizarUsuario;
import com.challenge.Foro_Hub.domai.usuario.ActualizarUsuarioDTO;
import com.challenge.Foro_Hub.domai.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaActualizacionUsuario implements ValidarActualizarUsuario {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(ActualizarUsuarioDTO data) {
        if(data.email() != null){
            var emailDuplicado = repository.findByEmail(data.email());
            if(emailDuplicado != null){
                throw new ValidationException("Este email ya esta en uso");
            }
        }
    }
}