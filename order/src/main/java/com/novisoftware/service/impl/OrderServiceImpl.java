package com.novisoftware.service.impl;

import com.novisoftware.application.mapper.OrderMapper;
import com.novisoftware.domain.dto.BookDto;
import com.novisoftware.domain.dto.OrderDto;
import com.novisoftware.domain.model.Order;
import com.novisoftware.domain.repository.OrderRepository;
import com.novisoftware.exception.OrderNotFoundException;
import com.novisoftware.infrastructure.client.BookClient;
import com.novisoftware.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final BookClient bookClient;
    private final OrderMapper orderMapper;

    @Override
    public OrderDto createOrder(OrderDto orderDto) {
        Order order = orderMapper.toOrder(orderDto);
        Order savedOrder = orderRepository.save(order);
        return orderMapper.toOrderDto(savedOrder);
    }

    @Override
    public OrderDto getOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderNotFoundException("Order not found with id: " + orderId));
        return orderMapper.toOrderDto(order);
    }

    @Override
    public List<OrderDto> getOrdersByUserId(Long userId) {
        List<Order> userOrders = orderRepository.findByUserId(userId);
        return userOrders.stream()
                .map(orderMapper::toOrderDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> getBookDetails(List<Long> bookIds) {
        return bookIds.stream()
                .map(bookClient::getBookById)
                .collect(Collectors.toList());
    }
}
