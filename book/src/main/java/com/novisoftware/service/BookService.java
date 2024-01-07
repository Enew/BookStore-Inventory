package com.novisoftware.service;

import com.novisoftware.domain.dto.BookCreateDto;
import com.novisoftware.domain.dto.BookDto;

import java.util.List;

public interface BookService {
    BookDto getBookDetails(Long bookId);
    void createNewBook(BookCreateDto bookDTO);

    void updateBook(Long bookId, BookDto updatedBookDto);

    void deleteBook(Long bookId);

    List<BookDto> getAllBooks();
}
