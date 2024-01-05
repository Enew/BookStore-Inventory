package com.novisoftware.application.mapper;

import com.novisoftware.domain.dto.OrderDto;
import com.novisoftware.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    public OrderDto toOrderDto(Order order) {
        return OrderDto.builder()
                .userId(order.getUserId())
                .bookIds(order.getBookIds())
                .build();
    }

    public Order toOrder(OrderDto orderDto) {
        Order order = new Order();
        order.setUserId(orderDto.getUserId());
        order.setBookIds(orderDto.getBookIds());
        return order;
    }
}