package edu.eafit.katio.Controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.Repository.AuthorsRepository;
import edu.eafit.katio.models.Authors;
import edu.eafit.katio.services.AuthorsService;



@RestController
@RequestMapping("/katio/authors")
@CrossOrigin(origins = "*")
public class AuthorsController {
    @Autowired
    private AuthorsRepository _authorRepository;


    // Traer todos
    @GetMapping("/getall")
    public ResponseEntity<List<Authors>> getAllAuthors() {
        List<Authors> authors = new ArrayList<>();
        _authorRepository.findAll().forEach(authors::add);
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }


    // Buscar por id
    @GetMapping("/getById")
    public ResponseEntity<List<Authors>> getAuthorById(@RequestParam("id") Integer id) {
        List<Authors> authorById = new AuthorsService(_authorRepository).getAuthorById(id);
        return ResponseEntity.ok(authorById);
    }

    // Buscar por nombre
    @GetMapping("/getByName")
    public ResponseEntity<List<Authors>> getAuthorByName(@RequestParam("name") String name) {
        List<Authors> authorByName = new AuthorsService(_authorRepository).getAuthorByName(name);
        return ResponseEntity.ok(authorByName);
    }

    // Buscar por pais
    @GetMapping("/getByCountry")
    public ResponseEntity<List<Authors>> getAuthorByCountry(@RequestParam("country") String country) {
        List<Authors> authorByCountry = new AuthorsService(_authorRepository).getAuthorByCountry(country);
        return ResponseEntity.ok(authorByCountry);
    }

    // Traer Autores por rango de fecha de nacimiento
    @GetMapping("/getByDate/{startDate}/{endDate}")
    public ResponseEntity<List<Authors>> getAuthorsByDate(
        @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
        @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        var response = new AuthorsService(_authorRepository).getAuthorsByDateRange(startDate, endDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Crear autor
    @PostMapping("/add")
    public ResponseEntity<Authors> addAuthors(@RequestBody Authors authors) {
        try {
            Authors createAuthor = new AuthorsService(_authorRepository) .addAuthors(authors);
            return new ResponseEntity<>(createAuthor, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Editar autor
    @PutMapping("/update/{name}")
    public ResponseEntity<Object> updateAuthors(@PathVariable("name") String name, @RequestBody Authors updateAuthors) {
        Authors updatedAuthors = new AuthorsService(_authorRepository) .updateAuthor(name, updateAuthors);
        if (updatedAuthors != null) {
            return new ResponseEntity<>(updatedAuthors, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Autor no Encontrado", HttpStatus.NOT_FOUND);
        }
    }


}