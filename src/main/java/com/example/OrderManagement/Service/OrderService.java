package com.example.OrderManagement.Service;

import com.example.OrderManagement.Model.Orders;
import com.example.OrderManagement.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepo repo;

    public Orders addOrder(Orders o){
        if(o.getQuantity()<=0 || o.getPrice()<=0){
            System.out.println("Please inter valid price or quantity.");
        }

        else{
            double v=o.getPrice() * o.getQuantity();
            o.setTotal(v);
            double discount;
            double fAmount;
            if(v>=10000){
                 discount=v*0.20;
                 fAmount=v-discount;
                 o.setFinalAmount(fAmount);
            }
            else if(v>=5000){
                discount=v*0.15;
                fAmount=v-discount;
                o.setFinalAmount(fAmount);
            }
            else if(v>=2000){
                discount=v*0.10;
                fAmount=v-discount;
                o.setFinalAmount(fAmount);
            }
            else{
                o.setFinalAmount(v);
            }
            o.setOrderDate(LocalDateTime.now());
        }
        repo.save(o);
        return o;
    }

    public List<Orders> showorder(){
        return repo.findAll();
    }

    public Optional<Orders> findorder(Integer id){
        return repo.findById(id);
    }
}
