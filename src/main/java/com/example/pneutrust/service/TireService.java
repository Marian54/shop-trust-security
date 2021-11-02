package com.example.pneutrust.service;

import com.example.pneutrust.entities.Tire;
import com.example.pneutrust.repositories.TireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TireService {

    private final TireRepository tireRepository;
    private final List<Tire> cart = new ArrayList<>();

    @Autowired
    public TireService(TireRepository tireRepository) {
        this.tireRepository = tireRepository;
    }

    public List<Tire> getTires() {
        return tireRepository.findAll();
    }

    public void addToCart(Tire tire) {
        cart.add(tire);
    }

    public List<Tire> getShoppingCart() {
        return cart;
    }
}
