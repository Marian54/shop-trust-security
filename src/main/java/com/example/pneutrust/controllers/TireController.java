package com.example.pneutrust.controllers;

import com.example.pneutrust.entities.Tire;
import com.example.pneutrust.service.TireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TireController {

    private final TireService tireService;

    @Autowired
    public TireController(TireService tireService) {
        this.tireService = tireService;
    }

    @GetMapping(value = "/tiresPage")
    public ModelAndView getTires() {
        ModelAndView mav = new ModelAndView();

        mav.addObject("tires", tireService.getTires());
        mav.addObject("tiresSize", tireService.getShoppingCart().size());

        Tire tire = Tire.builder().build();
        mav.addObject("tire", tire);

        mav.setViewName("tiresPage");
        return mav;
    }

    @GetMapping(value = "/tirePage")
    public ModelAndView getTire() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/tirePage");
        return mav;
    }

    @GetMapping(value = "/shoppingCartPage")
    public ModelAndView getShoppingCart() {
        ModelAndView mav = new ModelAndView();

        mav.addObject("shoppingCart", tireService.getShoppingCart());

        mav.setViewName("/shoppingCartPage");
        return mav;
    }

    @PostMapping(value = "/addToCart")
    public ModelAndView addToCart(@ModelAttribute Tire tire) {
        ModelAndView mav = new ModelAndView();

        tireService.addToCart(tire);

        mav.setViewName("redirect:/tiresPage");

        return mav;
    }
}
