package com.donjondragon.donjondragon.controller;

import com.donjondragon.donjondragon.dao.CharacterDao;
import com.donjondragon.donjondragon.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CharacterController {

    @Autowired
    private CharacterDao characterDao;

    //Personnages
    @GetMapping(value = "/Personnages")
    public List<Character>listePersonnage(){ return characterDao.findAll();}

    //Personnage/{id}
    @GetMapping(value = "Personnages/{id}")
    public Character voirPersonnage(@PathVariable int id){
        return characterDao.findById(id);
    }

    @PostMapping(value = "/Personnage")
    public void addCharacter(@RequestBody Character character){

        characterDao.save(character);

    }

}
