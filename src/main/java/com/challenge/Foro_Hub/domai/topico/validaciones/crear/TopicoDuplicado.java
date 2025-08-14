package com.challenge.Foro_Hub.domai.topico.validaciones.crear;

import com.challenge.Foro_Hub.domai.topico.CrearTopicoDTO;
import com.challenge.Foro_Hub.domai.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicoDuplicado implements ValidarTopicoCreado {

    @Autowired
    private TopicoRepository topicoRepository;


    @Override
    public void validate(CrearTopicoDTO data) {
        var topicoDuplicado = topicoRepository.existsByTituloAndMensaje(data.titulo(), data.mensaje());
        if(topicoDuplicado){
            throw new ValidationException("Este topico ya existe. Revisa /topicos/" + topicoRepository.findByTitulo(data.titulo()).getId());

        }
    }
}
