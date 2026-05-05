package com.example.OrderManagement.Controller;


import com.example.OrderManagement.Model.Orders;
import com.example.OrderManagement.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    OrderService os;

   @PostMapping("/addorder")
    public Orders addOrder(@RequestBody Orders o){
       return os.addOrder(o);
   }

   @GetMapping("/showorder")
    public List<Orders> showorder(){
       return os.showorder();
   }

   @GetMapping("/findorder/{id}")
    public Optional<Orders> findorder(@PathVariable Integer id){
       return os.findorder(id);
   }

}
