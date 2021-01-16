package org.example.service.impl;

import org.example.dto.OrderDTO;
import org.example.entity.Journal;
import org.example.entity.Order;
import org.example.mapper.OrderToOrderDTOMapper;
import org.example.repository.JournalRepository;
import org.example.repository.OrderRepository;
import org.example.repository.UserRepository;
import org.example.service.CartService;
//import org.thoughtworks.qdox.model.expression.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JournalRepository journalRepository;
    @Autowired
    private OrderToOrderDTOMapper orderMapper;

    @Override
    public OrderDTO getCartByUserId(final Long userId) {
        return null;
    }

    @Override
    public OrderDTO addJournalToCart(final Long userId, final Long journalId) {
        final List<Order> orders = orderRepository.getOrdersByUserId(userId);

        Order order = orders.stream()
                .filter(e -> !e.wasPaid())
                .findFirst()
                .orElse(null);

        if(order == null){
            //тут ми створюємо нове замовлення
            order = new Order();

            order.setOrderDate(LocalDate.now());
            order.setUser(userRepository.getUserById(userId));

        }

        final Journal journal = journalRepository.getJournalById(journalId);

        if(order.getOrderDetails().containsKey(journal)){
            int value = order.getOrderDetails().get(journal);
            order.getOrderDetails().put(journal, ++value);
        } else {
            order.getOrderDetails().put(journal, 1);
        }

        orderRepository.createOrder(order);


        return orderMapper.toDTO(order);
    }

    @Override
    public OrderDTO removeJournalFromCart(final Long userId, final Long journalId) {
        return null;
    }
}