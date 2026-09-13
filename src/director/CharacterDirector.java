package director;

import builder.CharacterBuilder;
import model.ArmorType;
import model.Character;
import model.WeaponType;
import java.util.List;

public class CharacterDirector {

    public Character createDefaultRookie(CharacterBuilder builder) {
        return builder.setName("Recruit")
                .setStats(100, 50)
                .setArmor(ArmorType.LEATHER)
                .setWeapon(WeaponType.SWORD_SHIELD)
                .setSkills(List.of("Basic Attack", "Defend"))
                .setInventory(List.of("Minor Health Potion", "Torch"))
                .setFaction("Kingdom Guards")
                .build();
    }

    public Character createRaidBoss(CharacterBuilder builder) {
        return builder.setName("Malakor the Undying")
                .setStats(5000, 1500)
                .setArmor(ArmorType.PLATE)
                .setWeapon(WeaponType.SWORD_SHIELD)
                .setSkills(List.of("Earthquake Slam", "Berserk Rage", "Summon Minions"))
                .setInventory(List.of("Legendary Chest Key", "Corrupted Soul Shard"))
                .setFaction("Dungeon Overseers")
                .build();
    }
}