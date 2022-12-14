package com.example.dojosandninjas.repositories;


import com.example.dojosandninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
//    List<Dojo> findAll();
//    List<Dojo> findByDescriptionContaining(String search);
}