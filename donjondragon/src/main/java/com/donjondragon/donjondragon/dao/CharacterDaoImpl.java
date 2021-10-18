package com.donjondragon.donjondragon.dao;

import com.donjondragon.donjondragon.model.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CharacterDaoImpl implements CharacterDao{

    public static List<Character> characters = new ArrayList<>();

    static {
        characters.add(new Character(1,new String("George"),1));
        characters.add(new Character(2,new String("Mulan"),2));
        characters.add(new Character(3,new String("Jack"),2));
        characters.add(new Character(4,new String("José"),1));
        characters.add(new Character(5,new String("Fanfoué"),2));
        characters.add(new Character(6,new String("Geraldine"),1));
        characters.add(new Character(7,new String("Josette"),1));
        characters.add(new Character(8,new String("Magalie"),2));
        characters.add(new Character(9,new String("Thor"),1));
    }

    @Override
    public List<Character> findAll(){ return characters; }

    @Override
    public Character findById(int id) { return null;}

    @Override
    public Character save(Character character) { return null;}
}
