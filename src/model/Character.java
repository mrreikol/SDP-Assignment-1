package model;

import java.util.Collections;
import java.util.List;

public class Character {
    private final String name;
    private final CharacterClass characterClass;
    private final ArmorType armor;
    private final WeaponType weapon;
    private final List<String> skills;
    private final List<String> inventory;
    private final String faction;
    private final int health;
    private final int mana;

    public Character(String name, CharacterClass characterClass, ArmorType armor,
                     WeaponType weapon, List<String> skills, List<String> inventory,
                     String faction, int health, int mana) {
        this.name = name;
        this.characterClass = characterClass;
        this.armor = armor;
        this.weapon = weapon;
        this.skills = skills != null ? List.copyOf(skills) : Collections.emptyList();
        this.inventory = inventory != null ? List.copyOf(inventory) : Collections.emptyList();
        this.faction = faction;
        this.health = health;
        this.mana = mana;
    }

    public String getName() { return name; }
    public CharacterClass getCharacterClass() { return characterClass; }
    public ArmorType getArmor() { return armor; }
    public WeaponType getWeapon() { return weapon; }
    public List<String> getSkills() { return skills; }
    public List<String> getInventory() { return inventory; }
    public String getFaction() { return faction; }
    public int getHealth() { return health; }
    public int getMana() { return mana; }

    @Override
    public String toString() {
        return String.format(
                "Character: %s [%s]\n" +
                        "  Stats: HP=%d, MP=%d | Faction: %s\n" +
                        "  Equipment: Armor=%s, Weapon=%s\n" +
                        "  Skills: %s\n" +
                        "  Inventory: %s",
                name, characterClass, health, mana, faction, armor, weapon, skills, inventory
        );
    }
}