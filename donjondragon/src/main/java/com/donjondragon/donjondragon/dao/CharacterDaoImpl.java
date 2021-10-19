package com.donjondragon.donjondragon.dao;

import com.donjondragon.donjondragon.model.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterDaoImpl implements CharacterDao{

    public static List<Character> characters = new ArrayList<>();

    static {
        characters.add(new Character(1,new String("George"),"Guerrier"));
        characters.add(new Character(2,new String("Mulan"),"Guerrier"));
        characters.add(new Character(3,new String("Jack"),"Guerrier"));
        characters.add(new Character(4,new String("José"),"Guerrier"));
        characters.add(new Character(5,new String("Fanfoué"),"Guerrier"));
        characters.add(new Character(6,new String("Geraldine"),"Mager"));
        characters.add(new Character(7,new String("Josette"),"Guerrier"));
        characters.add(new Character(8,new String("Magalie"),"Mage"));
        characters.add(new Character(9,new String("Thor"),"Guerrier"));
    }

    @Override
    public List<Character> findAll(){ return characters; }

    @Override
    public Character findById(int id) {

        for (Character character : characters) {
            if (character.getId() == id)
                return character;
        }
        return null;}

    @Override
    public Character save(Character character) {

        characters.add(character);
        return character;}

    @Override
    public Character delete(int id) { return null;}

    @Override
    public  Character modify(int id){
        return null;
    }

}
