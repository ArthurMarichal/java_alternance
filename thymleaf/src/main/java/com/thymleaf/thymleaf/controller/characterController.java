package com.thymleaf.thymleaf.controller;

import com.thymleaf.thymleaf.form.characterForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.thymleaf.thymleaf.model.Character;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class characterController {

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    //Personnages
    @GetMapping(value = "/characterList")
    public String characterList(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        List<Character> characters = restTemplate.getForObject(
                "http://localhost:8081/Personnages", List.class);
        model.addAttribute("characters", characters);
        return "characterList";
    }

    @RequestMapping(value = {"/addCharacter"}, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {

        characterForm characterForm = new characterForm();
        model.addAttribute("characterForm", characterForm);

        return "addCharacter";
    }

    @RequestMapping(value = {"/addCharacter"}, method = RequestMethod.POST)
    public String savePerson(Model model, //
                             @ModelAttribute("characterForm") characterForm characterForm) {
        int id = characterForm.getId();
        String name = characterForm.getName();
        String type = characterForm.getType();

        if (name != null && name.length() > 0 //
                && type != null && type.length() > 0) {
            RestTemplate restTemplate = new RestTemplate();
            Character character = new Character(id, name, type);
            restTemplate.postForObject("http://localhost:8081/Personnage",character,Character.class);

            return "redirect:/characterList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCharacter";
    }
    @RequestMapping(value = {"/editCharacter/{id}"}, method = RequestMethod.GET)
    public String showEditPersonPage(Model model, @PathVariable int id) {

        characterForm characterForm = new characterForm();
        model.addAttribute("characterForm", characterForm);
        model.addAttribute("id", id);

        return "editCharacter";
    }

    @RequestMapping(value = {"/editCharacter/{id}"}, method = RequestMethod.POST)
    public String editPerson(Model model, //
                             @ModelAttribute("characterForm") characterForm characterForm) {
        int id = characterForm.getId();
        String name = characterForm.getName();
        String type = characterForm.getType();

        if (name != null && name.length() > 0 //
                && type != null && type.length() > 0) {
            int size = characterForm.getId()-1;
            RestTemplate restTemplate = new RestTemplate();
            Character character = new Character(id, name, type);
            restTemplate.put("http://localhost:8081/Personnage/"+size,character,Character.class);

            return "redirect:/characterList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "editCharacter";
    }
   @PostMapping("/characterList/{id}")
    public String deletePerson(Model model, @PathVariable int id) {
       RestTemplate restTemplate = new RestTemplate();
       model.addAttribute("id",id);
       restTemplate.delete("http://localhost:8081/Personnage/" + id);
       return "redirect:/characterList";

    }
}
