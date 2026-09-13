package builder;

import model.ArmorType;
import model.Character;
import model.CharacterClass;
import model.WeaponType;

public class MageCharacterBuilder extends BaseCharacterBuilder {

    private static final int MINIMUM_MAGE_MANA = 50;

    @Override
    public Character build() {
        validateCommonState();
        validateMageState();

        return new Character(
                name, CharacterClass.MAGE, armor, weapon,
                skills, inventory, faction, health, mana
        );
    }

    private void validateMageState() {
        if (armor == ArmorType.PLATE) {
            throw new IllegalStateException("Mages cannot cast spells while wearing heavy plate armor.");
        }
        if (mana < MINIMUM_MAGE_MANA) {
            throw new IllegalStateException(
                    "Mage must have at least " + MINIMUM_MAGE_MANA + " mana. Current: " + mana
            );
        }
        if (weapon == WeaponType.TWO_HANDED_AXE) {
            throw new IllegalStateException("Mages cannot equip heavy physical weapons: " + weapon);
        }
    }
}
