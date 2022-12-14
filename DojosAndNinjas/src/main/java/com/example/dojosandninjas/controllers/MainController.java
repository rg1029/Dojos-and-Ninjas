package com.example.dojosandninjas.controllers;
import javax.validation.Valid;
import com.example.dojosandninjas.models.Dojo;
import com.example.dojosandninjas.models.Ninja;
import com.example.dojosandninjas.services.DojoService;
import com.example.dojosandninjas.services.NinjaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MainController {



    private final DojoService dojoService;
    public MainController(DojoService dojoService, NinjaService ninjaService) {
        this.dojoService = dojoService;
        this.ninjaService = ninjaService;
    }

    private final NinjaService ninjaService;



    //home


    @GetMapping("/")
    public String index() {
        return "redirect:/dojos";
    }

    //! CREATE AND SHOW ALL
    @GetMapping("/dojos")
    public String newDojo(@ModelAttribute(value = "dojo") Dojo dojo, Model model){
        model.addAttribute("dojos", dojoService.getAll());
        return "/dojos/new.jsp";
    }

    @PostMapping("/dojos")
    public String createDojo(@Valid @ModelAttribute(value = "dojo") Dojo dojo, BindingResult result){
        if(result.hasErrors()){
            return "/dojos/new.jsp";
        } else {
            dojoService.create(dojo);
            return "redirect:/dojos";
        }
    }

    //! READ SHOW ONE DOJO

    @GetMapping("/dojos/{id}")
    public String showDojo(Model model, @PathVariable("id") Long id){
        Dojo dojo = dojoService.getOne(id);
        model.addAttribute("dojo", dojo);
        System.out.println(dojo.getNinjas());
        List<Ninja> ninjas = ninjaService.getAll();
//        System.out.println(ninjas);
//        model.addAttribute("ninjas",ninjas);
        return "/dojos/show.jsp";
    }

    //! CREATE NINJA

    @GetMapping("/ninjas")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model){
        model.addAttribute("dojos", dojoService.getAll());
        return "/ninjas/new.jsp";
    }

    @PostMapping("/ninjas")
    public String createNinja(@ModelAttribute("ninja") Ninja ninja, BindingResult result){
        System.out.println(ninja);
        String id = String.valueOf(ninja.getDojo().getId());
        System.out.println(id);
        if(result.hasErrors()){
            return "/ninjas/new.jsp";
        } else {
            ninjaService.create(ninja);
            return String.format("redirect:/dojos/%s", id);///wouldnt this  want be return to corresponding  Show ninjas route
            // Dojo id to dispay ninjas
        }


        ////show Ninjas at Location

        //@Getmapping(/show)
        //Public string showNinjas(


    }
}