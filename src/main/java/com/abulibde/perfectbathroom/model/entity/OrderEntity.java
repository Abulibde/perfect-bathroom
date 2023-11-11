package com.abulibde.perfectbathroom.model.entity;

import com.abulibde.perfectbathroom.model.enums.PaymentMethodEnum;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseEntity{

    @ManyToOne
    private UserEntity user;

    @Column(nullable = false)
    private LocalDateTime placeDate;

    @OneToMany
    private List<ProductEntity> products;

    @Enumerated(EnumType.STRING)
    private PaymentMethodEnum paymentMethod;

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public LocalDateTime getPlaceDate() {
        return placeDate;
    }

    public void setPlaceDate(LocalDateTime placeDate) {
        this.placeDate = placeDate;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

    public PaymentMethodEnum getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethodEnum paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
