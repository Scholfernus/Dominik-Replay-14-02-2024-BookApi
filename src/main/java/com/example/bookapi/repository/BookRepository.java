package com.example.bookapi.repository;

import com.example.bookapi.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {
    @Query("SELECT y FROM BookModel y WHERE y.yearOfEdition = :yearOfEdition")
    BookModel findByYearOfEditionBefore(@Param("yearOfEdition") Integer year);

    @Query("SELECT a FROM BookModel a WHERE a.author = :author")
    List<BookModel> findAllByAuthor(@Param("author") String author);

//    @Query("SELECT n FROM BookModel n WHERE n.title = :title")
    List<BookModel> findBookModelByTitleStartingWith(@Param("letter") String letter);

    @Query("SELECT t FROM BookModel t where t.title = :title")
    List<BookModel> findBookModelByTitle(@Param("title") String title);

    List<BookModel> findBookModelByYearOfEditionBefore(Integer year);

    List<BookModel> findBookModelByYearOfEditionGreaterThan(Integer year);

}
