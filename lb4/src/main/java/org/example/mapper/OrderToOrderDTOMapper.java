package org.example.mapper;

import org.example.dto.OrderDTO;
import org.example.entity.Order;
import org.example.entity.User;
import org.springframework.stereotype.Component;

@Component
public class OrderToOrderDTOMapper {

    public Order toEntity(final OrderDTO orderDTO, final User user){

        final Order order = new Order();

        order.setId(orderDTO.getId());
        order.setOrderDate(orderDTO.getOrderDate());
        order.setOrderDetails(order.getOrderDetails());

        return order;
    }

    public OrderDTO toDTO(final Order order){
        final OrderDTO orderDTO = new OrderDTO();

        orderDTO.setId(order.getId());
        orderDTO.setOrderDate(order.getOrderDate());

        return orderDTO;
    }
}