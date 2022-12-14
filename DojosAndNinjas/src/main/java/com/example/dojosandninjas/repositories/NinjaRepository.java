package com.example.dojosandninjas.repositories;

import com.example.dojosandninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
//    List<Ninja> findAll();
//    List<Ninja> findByDescriptionContaining(String search);
}
