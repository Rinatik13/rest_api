package com.calisto.spring.rest_api.controller;

import com.calisto.spring.rest_api.entity.owners.Owner;
import com.calisto.spring.rest_api.service.owner.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calisto/owner")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping("/all")
    public List<Owner> getAllOwners(){
        return ownerService.getAll();
    }

    @PostMapping("/add")
    public Owner addOwner(@RequestBody Owner owner){
        return ownerService.add(owner);
    }

    @GetMapping("/get/{id}")
    public Owner getOwner(@PathVariable int id){
        return ownerService.getOwner(id);
    }

    @GetMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        ownerService.delete(id);
        return "Удалено!";
    }
}
