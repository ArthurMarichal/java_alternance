package com.thymleaf.thymleaf.controller;

import com.thymleaf.thymleaf.form.characterForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.thymleaf.thymleaf.model.Character;

import java.util.ArrayList;
import java.util.List;

@Controller
public class characterController {


    public static List<Character> characters = new ArrayList<>();

   static  {
        characters.add(new Character(1,"Jean","Mage"));
        characters.add(new Character(2,"Thor","Guerrier"));
        characters.add(new Character(3,"Glandoulf","Mage"));
    }
    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    //Personnages
    @GetMapping(value = "/characterList")
    public String characterList(Model model){
        model.addAttribute("characters", characters);
        return "characterList";
    }

    @RequestMapping(value = { "/addCharacter" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        characterForm characterForm = new characterForm();
        model.addAttribute("characterForm", characterForm);

        return "addCharacter";
    }

    @RequestMapping(value = { "/addCharacter" }, method = RequestMethod.POST)
    public String savePerson(Model model, //
                             @ModelAttribute("characterForm") characterForm characterForm) {

        String name = characterForm.getName();
        String type = characterForm.getType();

        if (name != null && name.length() > 0 //
                && type != null && type.length() > 0) {
            Character character = new Character(characterForm.getId(), name, type);
            characters.add(character);

            return "redirect:/characterList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCharacter";
    }
}
