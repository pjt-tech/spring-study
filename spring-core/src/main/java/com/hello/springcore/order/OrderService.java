package com.hello.springcore.order;

public interface OrderService {

    Order createOrder(Long id, String itemName, int price);
}
