package com.donjondragon.donjondragon.dao;

import com.donjondragon.donjondragon.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CharacterDao extends JpaRepository< Character, Integer > {
    public List<Character> findAll();
//    public Character findById(int id);
//    public Character save(Character character);
//    public void delete(int id);
//    public Character modify(int id, Character character);
}
