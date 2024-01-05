package com.novisoftware.service;

import com.novisoftware.domain.dto.BookDto;

public interface BookService {
    BookDto getBookDetails(Long bookId);
    void createNewBook(BookDto bookDTO);

    void updateBook(Long bookId, BookDto updatedBookDto);

    void deleteBook(Long bookId);
}
