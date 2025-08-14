package com.challenge.Foro_Hub.domai.topico.validaciones.crear;

import com.challenge.Foro_Hub.domai.topico.CrearTopicoDTO;
import com.challenge.Foro_Hub.domai.usuario.UsuarioRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarTopicoUsuario implements ValidarTopicoCreado{

    @Autowired
    private UsuarioRepository repository;

    @Override
    public void validate(CrearTopicoDTO data) {
        var existeUsuario = repository.existsById(data.usuarioId());
        if(!existeUsuario){
            throw new ValidationException("Este usuario no existe");
        }

        var usuarioHabilitado = repository.findById(data.usuarioId()).get().getEnabled();
        if(!usuarioHabilitado){
            throw new ValidationException("Este usuario fue deshabiliado.");
        }

    }
}
