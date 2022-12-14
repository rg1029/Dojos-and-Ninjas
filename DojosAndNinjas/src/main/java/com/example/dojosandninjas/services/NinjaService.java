package com.example.dojosandninjas.services;

import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public void create(Ninja ninja) {
        ninjaRepository.save(ninja);
    }

    public List<Ninja> getAll() {
        return (List<Ninja>) ninjaRepository.findAll();
    }
}