package com.example.bookapi.controller;

import com.example.bookapi.model.BookModel;
import com.example.bookapi.service.BookService;
import lombok.Data;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookModel>> getAllBooks() {
        try {
            List<BookModel> books = bookService.getBookList();
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable Long id) {
        try {
            BookModel bookModel = bookService.getBookFromListById(id);
            return ResponseEntity.ok(bookModel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<BookModel> addBook(@RequestBody BookModel model) {
        try {
            bookService.addBook(model);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/year/(year)")
    public ResponseEntity<List<BookModel>> getBookByYear(@PathVariable Integer year) {
        try {
            List<BookModel> bookModel = bookService.bookByYear(year);
            return ResponseEntity.ok(bookModel);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/title/{letter}")
    public ResponseEntity<List<BookModel>> getBookByTitle(@PathVariable String letter){
        try {
            List<BookModel> bookTitle = bookService.bookByTitle(letter);
            return ResponseEntity.ok((List<BookModel>) bookTitle);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookModel>> getBookByAuthor(@PathVariable String author){
        try {
            List<BookModel> bookTitle = bookService.bookByAuthor(author);
            return ResponseEntity.ok((List<BookModel>) bookTitle);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/>")
    public ResponseEntity<List<BookModel>> getBookGreaterThan(@Param("year")Integer year){
        try {
            List<BookModel> booksByYear = bookService.greaterThen(year);
            return ResponseEntity.ok(booksByYear);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/<")
    public ResponseEntity<List<BookModel>> getBookBefore(@Param("year")Integer year){
        try {
            List<BookModel> booksBeforeYear = bookService.beforeYear(year);
            return ResponseEntity.ok(booksBeforeYear);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
