package com.novisoftware.application.mapper;

import com.novisoftware.domain.dto.BookDto;
import com.novisoftware.domain.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDto toBookDto(Book book) {
        return BookDto.builder()
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

    public Book toBook(BookDto bookDto) {
        Book book = new Book();
        book.setTitle(bookDto.getTitle());
        book.setAuthor(bookDto.getAuthor());
        return book;
    }
}