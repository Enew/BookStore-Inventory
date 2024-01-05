package com.novisoftware.application;

import com.novisoftware.domain.dto.BookDto;
import com.novisoftware.domain.dto.OrderDto;
import com.novisoftware.domain.model.Order;
import com.novisoftware.service.OrderService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDto> createOrder( @RequestBody OrderDto order) {
        OrderDto createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long orderId) {
        OrderDto order = orderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDto>> getOrdersByUserId(@PathVariable Long userId) {
        List<OrderDto> userOrders = orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(userOrders);
    }

    @GetMapping("/book-details")
    public ResponseEntity<List<BookDto>> getBookDetails(@RequestParam List<Long> bookIds) {
        List<BookDto> bookDetails = orderService.getBookDetails(bookIds);
        return ResponseEntity.ok(bookDetails);
    }
}
