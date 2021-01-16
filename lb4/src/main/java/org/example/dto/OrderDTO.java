package org.example.dto;

import org.example.entity.Journal;
import org.example.entity.User;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Map;

public class OrderDTO {

    private User user;
    private Long id;
    private LocalDate orderDate;
    private Long userId;

    @Size(min = 5, max = 8)
    private String some;

    public OrderDTO() {
    }

    public OrderDTO(User user, Long id, LocalDate orderDate, Long userId, @Size(min = 5, max = 8) String some) {
        this.user = user;
        this.id = id;
        this.orderDate = orderDate;
        this.userId = userId;
        this.some = some;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getSome() {
        return some;
    }

    public void setSome(String some) {
        this.some = some;
    }
}