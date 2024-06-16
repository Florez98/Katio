package edu.eafit.katio.interfaces;

import java.util.Optional;

import edu.eafit.katio.models.Usuarios;

public interface BaseUsuarioService {
    Iterable<Usuarios> getAllUsuarios();
    Usuarios addUsuarios(Usuarios usuarios);
    Optional<Usuarios> getUsuarioById(Integer id);
    Iterable<Usuarios>getUsuarioByNombre(String nombre);
    Iterable<Usuarios>getUsuarioByIdentificacion(String identificacion);
    Iterable<Usuarios>getbyLoguin(String email, String password);

  
    
   
}
