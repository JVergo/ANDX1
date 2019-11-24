package com.example.monsterindex.API;

public class Monster {
    private String name, size, fammily, alligment, speed, senses, language;
    private int AC, hitPoints, STR, DEX, CON, INT, WIS, CHA;
    private int index;
    private int athletics, acrobatics, sleightOfHand, stealth, arcana, history, investigation, nature, religion,
            animalHandling, insight, medicine, perception, survival, deception, intimidation, performance, persuasion;
    private float CR;


    public Monster(int index, String name, String size, String family, String alignment, String senses, String language, int AC, int hitPoints, String speed, int STR, int DEX, int CON, int INT, int WIS, int CHA, float CR) {
        this.index = index;
        this.name = name;
        this.size = size;
        this.fammily = family;
        this.alligment = alignment;
        this.senses = senses;
        this.language = language;
        this.AC = AC;
        this.hitPoints = hitPoints;
        this.speed = speed;
        this.STR = STR;
        this.DEX = DEX;
        this.CON = CON;
        this.INT = INT;
        this.WIS = WIS;
        this.CHA = CHA;
        this.CR = CR;
    }

    public int getIndex()
    {
        return index;
    }
    public String getName() {
        return name;
    }
    public String getSize() {
        return size;
    }
    public String getFammily() {
        return fammily;
    }
    public String getAlligment() {
        return alligment;
    }
    public String getspeed() {
        return speed;
    }
    public String getSenses() {
        return senses;
    }
    public String getLanguage() {
        return language;
    }
    public int getAC() {
        return AC;
    }
    public int gethitPoints() {
        return hitPoints;
    }
    public int getSTR() {
        return STR;
    }
    public int getDEX() {
        return DEX;
    }
    public int getCON() {
        return CON;
    }
    public int getINT() {
        return INT;
    }
    public int getWIS() {
        return WIS;
    }
    public int getCHA() {
        return CHA;
    }
    public float getCR() {
        return CR;
    }

    public void setSkills(int athletics, int acrobatics, int sleightOfHand, int stealth, int arcana, int history, int investigation, int nature, int religion,
                          int animalHandling, int insight, int medicine, int perception, int survival, int deception, int intimidation, int performance, int persuasion)
    {
        this.athletics = athletics;
        this.acrobatics = acrobatics;
        this.sleightOfHand = sleightOfHand;
        this.stealth = stealth;
        this.arcana = arcana;
        this.history = history;
        this.investigation = investigation;
        this.nature = nature;
        this.religion = religion;
        this.animalHandling = animalHandling;
        this.insight = insight;
        this.medicine = medicine;
        this.perception = perception;
        this.survival = survival;
        this.deception = deception;
        this.intimidation = intimidation;
        this.performance = performance;
        this.persuasion = persuasion;
    }

    public String getSkills() {
        String skills = "Skills ";
        if(athletics > 0)
        {
            skills += "Athletics +" + athletics + ", ";
        }
        if(acrobatics > 0)
        {
            skills += "Acrobatics +" + acrobatics + ", ";
        }
        if(sleightOfHand > 0)
        {
            skills += "Sleight of hand +" + sleightOfHand + ", ";
        }
        if(stealth > 0)
        {
            skills += "Stealth +" + stealth + ", ";
        }
        if(arcana > 0)
        {
            skills += "Arcana +" + arcana + ", ";
        }
        if(history > 0)
        {
            skills += "History +" + history + ", ";
        }
        if(investigation > 0)
        {
            skills += "Investigation +" + investigation + ", ";
        }
        if(nature > 0)
        {
            skills += "Nature +" + nature + ", ";
        }
        if(religion > 0)
        {
            skills += "Religion +" + religion + ", ";
        }
        if(animalHandling > 0)
        {
            skills += "Animal handling +" + animalHandling + ", ";
        }
        if(insight > 0)
        {
            skills += "Insight +" + insight + ", ";
        }
        if(medicine > 0)
        {
            skills += "Medicine +" + medicine + ", ";
        }
        if(perception > 0)
        {
            skills += "Perception +" + perception + ", ";
        }
        if(survival > 0)
        {
            skills += "Survival +" + survival + ", ";
        }
        if(deception > 0)
        {
            skills += "Deception +" + deception + ", ";
        }
        if(intimidation > 0)
        {
            skills += "Intimidation +" + intimidation + ", ";
        }
        if(performance > 0)
        {
            skills += "Performance +" + performance + ", ";
        }
        if(persuasion > 0)
        {
            skills += "Persuasion +" + persuasion + ", ";
        }

        return skills.substring(0, skills.length() - 2);
    }
}
