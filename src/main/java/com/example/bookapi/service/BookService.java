package com.example.bookapi.service;

import com.example.bookapi.model.BookModel;
import com.example.bookapi.repository.BookRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class BookService {
    private final BookRepository bookRepository;

//    public ResponseEntity<List<Book>> findAll() {
//        return bookRepository.findAll();
//    }

    public List<BookModel> getBookList() {
        return bookRepository.findAll();
    }

    public BookModel getBookFromListById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Empty"));
    }

    public void addBook(BookModel model) {
        bookRepository.save(model);
    }


    public List<BookModel> bookByYear(Integer year) {
        return (List<BookModel>) bookRepository.findByYearOfEditionBefore(year);
    }

    public List<BookModel> bookByTitle(String letter) {
        return bookRepository.findBookModelByTitleStartingWith(letter);
    }


    public List<BookModel> bookByAuthor(String author) {
        return bookRepository.findAllByAuthor(author);
    }

    public List<BookModel> greaterThen(Integer year) {
        return bookRepository.findBookModelByYearOfEditionGreaterThan(year);
    }

    public List<BookModel> beforeYear(Integer year) {
        return bookRepository.findBookModelByYearOfEditionBefore(year);
    }
}
