/*package edu.eafit.katio.Controller;

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
import org.springframework.web.bind.annotation.RestController;

import edu.eafit.katio.Repository.BookRepository;
import edu.eafit.katio.Repository.BooksByAuthorRepository;
import edu.eafit.katio.dtos.BooksByAuthor;
import edu.eafit.katio.models.Books;
import edu.eafit.katio.services.BookService;


@RestController
@RequestMapping("/katio/books")
@CrossOrigin(origins = "*")
public class BookController {
    
    @Autowired
    private BookRepository _bookRepository;

    @Autowired
    private BooksByAuthorRepository _BooksByAuthorRepository;


    //Metodos de model Book
    // Crear un Libro
    @PostMapping("/add")
    public ResponseEntity<Books> addBooks(@RequestBody Books books) {
        try {
            Books creatBook = new BookService(_bookRepository) .addBooks(books);
            return new ResponseEntity<>(creatBook, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    // Editar un libro
    @PutMapping("/update/{name}")
    public ResponseEntity<Object> updateBooks(@PathVariable("name") String name, @RequestBody Books updateBooks) {
        Books updatedBook = new BookService(_bookRepository) .updateBook(name, updateBooks);
        if (updatedBook != null) {
            return new ResponseEntity<>(updatedBook, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Libro no Encontrado", HttpStatus.NOT_FOUND);
        }
    }

    // Traer Todos los Libros
    @GetMapping("/getall")
    public ResponseEntity<Iterable<Books>> getAllBooks()
    {
        var books = new BookService(_bookRepository) .getAllBooks();
        return new ResponseEntity<Iterable<Books>>(books, HttpStatus.OK);
    }

    // Traer Libros por Id del Libro
    @GetMapping("/getById/{Id}")
    public ResponseEntity<Iterable<Books>> getBooksById(@PathVariable ("Id") Integer Id)
    {
        var response = new BookService(_bookRepository).getBooksById(Id);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }

    // Traer Libros por Nombre del Libro
    @GetMapping("/getByName/{Name}")
    public ResponseEntity<Iterable<Books>> getBookByName(@PathVariable ("Name") String Name)
    {
        var response = new BookService(_bookRepository).getBooksByName(Name);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }

    // Traer Libros por Editorial
    @GetMapping("/getByEdition/{Edition}")
    public ResponseEntity<Iterable<Books>> getBooksByEdition(@PathVariable ("Edition") String Edition)
    {
        var response = new BookService(_bookRepository).getBooksByEdition(Edition);
        return new ResponseEntity<Iterable<Books>>(response, HttpStatus.OK);
    }


    // Traer libros por rango de fechas de publicación
    @GetMapping("/getByDate/{startDate}/{endDate}")
    public ResponseEntity<List<Books>> getBooksByDate(
            @PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        var response = new BookService(_bookRepository).getBooksByDateRange(startDate, endDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //Todo Metodos de Dtos

    // BooksByAuthor
    // Traer libros por Id del Autor
    @GetMapping("/getByAuthorId/{Id}")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthorId(@PathVariable("Id") Integer idAuthor)
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthorId(idAuthor);
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }

    // Traer libros por Nombre del Autor
    @GetMapping("/getByAuthorName/{Name}")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthorName(@PathVariable("Name") String nameAuthor)
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthorName(nameAuthor);
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }

    // Traer Libros por Nombre y Apellido del Autor
    @GetMapping("/getByAuthor/{Name}/{LastName}")
    public ResponseEntity<Iterable<BooksByAuthor>> getAllBooksByAuthor(@PathVariable("Name") String nameAuthor, @PathVariable("LastName") String lastNameAuthor)
    {
        var response = new BookService(_BooksByAuthorRepository).getAllBooksByAuthor(nameAuthor, lastNameAuthor);
        return new ResponseEntity<Iterable<BooksByAuthor>>(response, HttpStatus.OK);
    }


}

*/