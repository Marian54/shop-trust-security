package com.example.pneutrust.repositories;

import com.example.pneutrust.entities.Tire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TireRepository extends JpaRepository<Tire, Long> {
}
