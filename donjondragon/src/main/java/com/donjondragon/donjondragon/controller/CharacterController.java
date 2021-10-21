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
    public List<Character> listCharacter() {
        List<Character> characters = characterDao.findAll();
        return characters;
    }

    //Personnages/{id}
    @GetMapping(value = "Personnages/{id}")
    public Character showCharacter(@PathVariable int id){
        return characterDao.getById(id);

    }    //Personnage/{id}
    @PutMapping(value = "Personnage/{id}")
    public Character modifyCharacter(@PathVariable int id, @RequestBody Character character){
        character.setId(id);
        return characterDao.save(character);
    }
    //Personnage(POST)
    @PostMapping(value = "/Personnage")
    public void addCharacter(@RequestBody Character character){
        characterDao.save(character);
    }
    //Delete
    @DeleteMapping(value = "/Personnage/{id}")
    public void deleteCharacter(@PathVariable int id){
        characterDao.deleteById(id);
    }


}
