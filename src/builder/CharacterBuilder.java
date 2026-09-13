package builder;

import model.ArmorType;
import model.Character;
import model.WeaponType;
import java.util.List;

public interface CharacterBuilder {
    CharacterBuilder setName(String name);
    CharacterBuilder setArmor(ArmorType armor);
    CharacterBuilder setWeapon(WeaponType weapon);
    CharacterBuilder setSkills(List<String> skills);
    CharacterBuilder setInventory(List<String> inventory);
    CharacterBuilder setFaction(String faction);
    CharacterBuilder setStats(int health, int mana);
    Character build();
}