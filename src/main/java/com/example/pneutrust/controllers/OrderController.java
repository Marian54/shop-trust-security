package com.example.pneutrust.controllers;

import com.example.pneutrust.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orderPage")
    public ModelAndView getOrderPage() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/orderPage");
        return mav;
    }
}
