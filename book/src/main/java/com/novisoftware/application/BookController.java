package com.novisoftware.application;

import com.novisoftware.domain.dto.BookDto;
import com.novisoftware.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBookDetails(@PathVariable Long bookId) {
        BookDto bookDetails = bookService.getBookDetails(bookId);
        return ResponseEntity.ok(bookDetails);
    }

    @PostMapping
    public ResponseEntity<Void> createNewBook( @RequestBody BookDto bookDto) {
        bookService.createNewBook(bookDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{bookId}")
    public ResponseEntity<Void> updateBook(@PathVariable Long bookId,  @RequestBody BookDto updatedBookDto) {
        bookService.updateBook(bookId, updatedBookDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
        bookService.deleteBook(bookId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
