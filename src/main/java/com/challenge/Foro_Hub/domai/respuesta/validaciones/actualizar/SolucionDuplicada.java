package com.challenge.Foro_Hub.domai.respuesta.validaciones.actualizar;

import com.challenge.Foro_Hub.domai.respuesta.ActualizarRespuestaDTO;
import com.challenge.Foro_Hub.domai.respuesta.Respuesta;
import com.challenge.Foro_Hub.domai.respuesta.RespuestaRepository;
import com.challenge.Foro_Hub.domai.topico.Estado;
import com.challenge.Foro_Hub.domai.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SolucionDuplicada implements ValidarRespuestaActualizada {

    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @Override
    public void validate(ActualizarRespuestaDTO data, Long respuestaId) {
        if (data.solucion()){
            Respuesta respuesta = respuestaRepository.getReferenceById(respuestaId);
            var topicoResuelto = topicoRepository.getReferenceById(respuesta.getTopico().getId());
            if (topicoResuelto.getEstado() == Estado.CLOSED){
                throw new ValidationException("Este topico ya esta solucionado.");
            }
        }
    }
}
