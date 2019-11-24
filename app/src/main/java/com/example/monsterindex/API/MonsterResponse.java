package com.example.monsterindex.API;

public class MonsterResponse {
    private int id;
    private String name, size, type, alignment, speed, senses, languages;
    private int armor_class, hit_points, strength, dexterity, constitution, intelligence, wisdom, charisma;
    private int index;
    private int athletics, acrobatics, sleightOfHand, stealth, arcana, history, investigation, nature, religion,
            animalHandling, insight, medicine, perception, survival, deception, intimidation, performance, persuasion;
    private float challenge_rating;
    private String main;

    public Monster getMonster(){
        Monster monster = new Monster(index, name, size, type, alignment, senses, languages, armor_class, hit_points, speed, strength, dexterity, constitution, intelligence, wisdom, charisma, challenge_rating);
        monster.setSkills(athletics, acrobatics, sleightOfHand, stealth, arcana, history, investigation, nature, religion,
                animalHandling, insight, medicine, perception, survival, deception, intimidation, performance, persuasion);
        return monster;
    }

}
