package com.challenge.Foro_Hub.domai.usuario;

public record ActualizarUsuarioDTO(

        String password,
        Role role,
        String nombre,
        String apellido,
        String email,
        Boolean enabled
) {

}
