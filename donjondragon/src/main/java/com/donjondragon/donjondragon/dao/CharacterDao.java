package com.donjondragon.donjondragon.dao;

import com.donjondragon.donjondragon.model.Character;

import java.util.List;

public interface CharacterDao {
    public List<Character> findAll();
    public Character findById(int id);
    public Character save(Character character);
}
