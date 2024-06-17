package edu.eafit.katio.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import edu.eafit.katio.Repository.AuthorsRepository;
import edu.eafit.katio.interfaces.BaseAuthorService;
import edu.eafit.katio.models.Authors;

public class AuthorsService implements BaseAuthorService {

    private AuthorsRepository _AuthorRepository;

    public AuthorsService(AuthorsRepository _AuthorRepository) {
        this._AuthorRepository = _AuthorRepository;
    }


    // Crear autor
    @Override
    public Authors addAuthors(Authors authors) {

        Optional<Authors> existingAuthor = _AuthorRepository.findByNameOpt(authors.getName());
        if (existingAuthor.isPresent()) {
            throw new RuntimeException("El Autor ya existe");
        }
        return _AuthorRepository.saveAndFlush(authors);
    }

    // Buscar por id
    @Override
    public List<Authors> getAuthorById(Integer id) {
        var authorList =  _AuthorRepository.findById(id);
        return authorList;
    }

    // Buscar por nombre
    @Override
    public List<Authors> getAuthorByName(String name) {
        var authorList = _AuthorRepository.findByName(name);
        return authorList;
    }

    // Buscar por pais
    @Override
    public List<Authors> getAuthorByCountry(String country) {
        var authorList = _AuthorRepository.findByCountry(country);
        return authorList;
    }

    // Traer autores por rango de fechas de nacimiento
    public List<Authors> getAuthorsByDateRange(Date startDate, Date endDate) {
        var authorList = _AuthorRepository.findByPublishedDateBetween(startDate, endDate);
        return authorList;
    }

    // Actualizar autors
    @Override
    public Authors updateAuthor(String name, Authors authors) {
        Optional<Authors> oldAuthor = _AuthorRepository.findByNameOpt(name);
        if(oldAuthor.isPresent() && !oldAuthor.get().getName().isBlank()) 
        {
            oldAuthor.get().setName(authors.getName());
            oldAuthor.get().setLastname(authors.getLastname());
            oldAuthor.get().setCountry(authors.getCountry());
            oldAuthor.get().setBirthdate(authors.getBirthdate());

            return _AuthorRepository.saveAndFlush(oldAuthor.get());
        } else {
            return null;
        }
    }

}

    
