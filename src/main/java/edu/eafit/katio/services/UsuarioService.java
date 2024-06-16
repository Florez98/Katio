package edu.eafit.katio.services;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import edu.eafit.katio.Repository.UsuarioRepository;
import edu.eafit.katio.interfaces.BaseUsuarioService;
import edu.eafit.katio.models.Usuarios;

public class UsuarioService implements BaseUsuarioService{

    private UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Iterable<Usuarios> getAllUsuarios() {
        var  listaUsuarios = usuarioRepository.findAll();
        
        return listaUsuarios;
    }



    @Override
    public Usuarios addUsuarios(Usuarios usuarios) {
        var usuarioCreado = new Usuarios();
        
        try{
            if(usuarios.getPassword().length() > 15)
            {
                usuarios.setPassword(blake3Formatter(usuarios.getPassword()));
                usuarioCreado = usuarioRepository.saveAndFlush(usuarios);
                
            }
        }
        catch(Exception ex){
        }       
        
        return usuarioCreado;
    }
        private String blake3Formatter(String value)  throws NoSuchAlgorithmException
    {
        final MessageDigest md = MessageDigest.getInstance("SHA3-512");
        byte[] hash = md.digest(value.getBytes(StandardCharsets.UTF_8));
        String sha3Hex = bytesToHex(hash);
        return sha3Hex;
    }
      private String bytesToHex(byte[] hash){
        BigInteger number = new BigInteger(1, hash);
        StringBuilder hexString = new StringBuilder(number.toString(16));
        while(hexString.length() < 64){
            hexString.insert(0, '0');
        }
        return hexString.toString();
    }
    






    @Override
    public Optional<Usuarios> getUsuarioById(Integer id) {        
        return usuarioRepository.findById(id);
      
    }





    @Override
    public Iterable<Usuarios> getUsuarioByNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre);
    }

    @Override
    public Iterable<Usuarios> getUsuarioByIdentificacion(String identificacion){
        return usuarioRepository.findByIdentificacion(identificacion);
    }}
        

 



    
