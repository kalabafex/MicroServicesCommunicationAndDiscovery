package io.kai.bookinfoservice.resources;

import io.kai.bookinfoservice.models.Book;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookResource {
    @RequestMapping("/{bookId}")
    public Book getBookInfo(@PathVariable("bookId") String bookId){
        return new Book(bookId, "Test Book");
    }
}
