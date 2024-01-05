package com.novisoftware.service;

import com.novisoftware.domain.dto.BookDto;
import com.novisoftware.domain.dto.OrderDto;
import com.novisoftware.domain.model.Order;

import java.util.List;

public interface OrderService {
    OrderDto createOrder(OrderDto order);
    OrderDto getOrderById(Long orderId);
    List<OrderDto> getOrdersByUserId(Long userId);
    List<BookDto> getBookDetails(List<Long> bookIds);
}