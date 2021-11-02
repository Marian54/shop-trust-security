package com.example.pneutrust.controllers;

import com.example.pneutrust.entities.User;
import com.example.pneutrust.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/loginPage")
    public ModelAndView loginPage() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/loginPage");
        return mav;
    }

    @GetMapping(value = "/registerPage")
    public ModelAndView getRegister(Model model) {
        ModelAndView mav = new ModelAndView();

        User user = User.builder().build();
        model.addAttribute("user", user);

        mav.setViewName("/registerPage");
        return mav;
    }
/*
    @PostMapping(value = "/login")
    public ModelAndView login(@ModelAttribute User user) {
        ModelAndView mav = new ModelAndView();


        if (userService.userSaved(user)) {
            mav.setViewName("redirect:/tiresPage");
        }
        else {
            mav.setViewName("/loginPage");
        }


        return mav;
    }*/

    @PostMapping(value = "/register")
    public ModelAndView register(@ModelAttribute User user) {
        ModelAndView mav = new ModelAndView();


        if (!userService.userRegistered(user)) {
            userService.save(user);
            mav.setViewName("redirect:/loginPage");
        }
        else {
            mav.setViewName("/registerPage");
        }


        return mav;
    }
    @GetMapping(value = "/accessDenied")
    public ModelAndView accessDenied() {
        ModelAndView mav = new ModelAndView();

        mav.setViewName("/accessDenied");
        return mav;
    }


}


