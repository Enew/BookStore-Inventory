package com.novisoftware.infrastructure.client;

import com.novisoftware.domain.dto.BookDto;
import com.novisoftware.infrastructure.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "book-service", url = "${books.url}", configuration = FeignConfig.class)
public interface BookClient {

    @GetMapping(value ="/books/{bookId}")
    BookDto getBookById(@PathVariable Long bookId);
}