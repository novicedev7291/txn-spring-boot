package com.coding.saga;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class OrderService {
    private final OrderRepository repo;

    public OrderService(OrderRepository repo) {
        this.repo = repo;
    }

    @Transactional(rollbackFor = TxnException.class)
    public void add(RawOrder data) throws TxnException {
        Order order = new Order();
        repo.save(order);

        try {
            // Setting values later so that error can occur and the transaction rollbacks
            order.setOrderId(data.orderId());
            order.setCreatedBy(data.createdBy());
            order.setQty(Integer.parseInt(data.qty()));
            order.setCreationDate(LocalDateTime.now());
            order.setVersion(1);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
            throw new TxnException(ex.getMessage());
        }
    }
}