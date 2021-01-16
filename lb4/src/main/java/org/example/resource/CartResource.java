package org.example.resource;

import org.example.dto.OrderDTO;
import org.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartResource {

    @Autowired
    public CartService cartService;

    @GetMapping("/cart/{id}")
    public OrderDTO getCartByUserId(final @PathVariable Long userId){
        return cartService.getCartByUserId(userId);
    }

    @PostMapping("/cart/{id}/{journalId}")
    public OrderDTO addJournalToCart(final @PathVariable Long id,
                                  final @PathVariable Long journalId){
        return cartService.addJournalToCart(id, journalId);
    }


    @DeleteMapping("/cart/{id}/{journalId}")
    public OrderDTO removeJournalFromCart(final @PathVariable Long userId,
                                       final @PathVariable Long journalId){
        return cartService.removeJournalFromCart(userId, journalId);
    }
}