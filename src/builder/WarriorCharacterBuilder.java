package builder;

import model.ArmorType;
import model.Character;
import model.CharacterClass;
import model.WeaponType;

public class WarriorCharacterBuilder extends BaseCharacterBuilder {

    @Override
    public Character build() {
        validateCommonState();
        validateWarriorState();

        return new Character(
                name, CharacterClass.WARRIOR, armor, weapon,
                skills, inventory, faction, health, mana
        );
    }

    private void validateWarriorState() {
        if (weapon == null) {
            throw new IllegalStateException("Warrior cannot be created without a weapon.");
        }
        if (weapon == WeaponType.MAGIC_STAFF || weapon == WeaponType.WAND) {
            throw new IllegalStateException("Warrior cannot wield magic weapons: " + weapon);
        }
        if (armor == ArmorType.CLOTH) {
            throw new IllegalStateException("Warrior cannot wear cloth armor.");
        }
    }
}