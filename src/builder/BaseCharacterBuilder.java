package builder;

import model.ArmorType;
import model.WeaponType;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseCharacterBuilder implements CharacterBuilder {
    protected String name;
    protected ArmorType armor;
    protected WeaponType weapon;
    protected List<String> skills = new ArrayList<>();
    protected List<String> inventory = new ArrayList<>();
    protected String faction = "Neutral";
    protected int health;
    protected int mana;

    @Override
    public CharacterBuilder setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public CharacterBuilder setArmor(ArmorType armor) {
        this.armor = armor;
        return this;
    }

    @Override
    public CharacterBuilder setWeapon(WeaponType weapon) {
        this.weapon = weapon;
        return this;
    }

    @Override
    public CharacterBuilder setSkills(List<String> skills) {
        this.skills = skills != null ? new ArrayList<>(skills) : new ArrayList<>();
        return this;
    }

    @Override
    public CharacterBuilder setInventory(List<String> inventory) {
        this.inventory = inventory != null ? new ArrayList<>(inventory) : new ArrayList<>();
        return this;
    }

    @Override
    public CharacterBuilder setFaction(String faction) {
        this.faction = faction;
        return this;
    }

    @Override
    public CharacterBuilder setStats(int health, int mana) {
        this.health = health;
        this.mana = mana;
        return this;
    }

    protected void validateCommonState() {
        if (name == null || name.isBlank()) {
            throw new IllegalStateException("Character must have a non-empty name.");
        }
        if (health <= 0) {
            throw new IllegalStateException("Character must have positive health.");
        }
    }
}