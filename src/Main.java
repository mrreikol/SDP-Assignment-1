import builder.CharacterBuilder;
import builder.MageCharacterBuilder;
import builder.WarriorCharacterBuilder;
import director.CharacterDirector;
import model.ArmorType;
import model.Character;
import model.WeaponType;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CharacterDirector director = new CharacterDirector();

        System.out.println("=== 1. CREATING VIA DIRECTOR ===");
        CharacterBuilder warriorBuilder = new WarriorCharacterBuilder();
        Character rookie = director.createDefaultRookie(warriorBuilder);
        System.out.println(rookie);
        System.out.println();

        Character raidBoss = director.createRaidBoss(warriorBuilder);
        System.out.println(raidBoss);
        System.out.println();

        System.out.println("=== 2. CREATING VIA CUSTOM FLUENT BUILDER ===");
        CharacterBuilder mageBuilder = new MageCharacterBuilder();
        Character archMage = mageBuilder.setName("Jaina Proudmoore")
                .setStats(450, 800)
                .setArmor(ArmorType.CLOTH)
                .setWeapon(WeaponType.MAGIC_STAFF)
                .setSkills(List.of("Blizzard", "Frostbolt", "Teleport"))
                .setInventory(List.of("Mana Potion", "Spell Scroll"))
                .setFaction("Alliance")
                .build();
        System.out.println(archMage);
        System.out.println();

        System.out.println("=== 3. VALIDATION TEST: MAGE IN PLATE ARMOR ===");
        try {
            new MageCharacterBuilder()
                    .setName("Battlemage Attempt")
                    .setStats(300, 200)
                    .setArmor(ArmorType.PLATE)
                    .setWeapon(WeaponType.WAND)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }

        System.out.println("\n=== 4. VALIDATION TEST: WARRIOR WITHOUT WEAPON ===");
        try {
            new WarriorCharacterBuilder()
                    .setName("Unarmed Brawler")
                    .setStats(200, 0)
                    .setArmor(ArmorType.LEATHER)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("Caught Expected Error: " + e.getMessage());
        }
    }
}