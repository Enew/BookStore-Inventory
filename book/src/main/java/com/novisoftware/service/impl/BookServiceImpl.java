package com.novisoftware.service.impl;

import com.novisoftware.application.mapper.BookMapper;
import com.novisoftware.domain.dto.BookCreateDto;
import com.novisoftware.domain.dto.BookDto;
import com.novisoftware.domain.model.Book;
import com.novisoftware.domain.repository.BookRepository;
import com.novisoftware.exception.BookNotFoundException;
import com.novisoftware.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto getBookDetails(Long bookId) {

        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + bookId));

        return bookMapper.toBookDto(book);
    }

    @Override
    public void createNewBook(BookCreateDto bookDTO) {
        var newBook = bookMapper.toBook(bookDTO);
        bookRepository.save(newBook);
    }

    @Override
    public void updateBook(Long bookId, BookDto updatedBookDto) {
        Book existingBook = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + bookId));

        existingBook.setTitle(updatedBookDto.getTitle());
        existingBook.setAuthor(updatedBookDto.getAuthor());

        bookRepository.save(existingBook);
    }

    @Override
    public void deleteBook(Long bookId) {
        Book bookToDelete = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + bookId));
        bookRepository.delete(bookToDelete);
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(bookMapper::toBookDto)
                .collect(Collectors.toList());
    }
}
