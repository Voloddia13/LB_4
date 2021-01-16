package org.example.service;

import org.example.dto.OrderDTO;

public interface CartService {

    OrderDTO getCartByUserId(Long userId);
    OrderDTO addJournalToCart(Long userId, Long bookId);
    OrderDTO removeJournalFromCart(Long userId, Long bookId);

}