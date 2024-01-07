package com.novisoftware.application.mapper;

import com.novisoftware.domain.dto.BookCreateDto;
import com.novisoftware.domain.dto.BookDto;
import com.novisoftware.domain.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public BookDto toBookDto(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .title(book.getTitle())
                .author(book.getAuthor())
                .build();
    }

    public Book toBook(BookCreateDto bookCreateDto) {
        Book book = new Book();
        book.setTitle(bookCreateDto.getTitle());
        book.setAuthor(bookCreateDto.getAuthor());
        return book;
    }
}