package com.example.OrderManagement.Repository;

import com.example.OrderManagement.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Orders,Integer> {
}
