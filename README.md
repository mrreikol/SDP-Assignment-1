# Game Character Creator (Builder Pattern)

A Java implementation of the Builder creational design pattern for creating RPG/NPC characters. 
The project eliminates telescoping constructors and enforces attribute and equipment validation 
during the build phase (e.g., a mage cannot equip heavy plate armor, and a warrior cannot enter battle unarmed).

## Project Structure

```text
SDP-Assignment-1/
├── src/
│   ├── builder/
│   │   ├── BaseCharacterBuilder.java    # Shared builder fields and logic
│   │   ├── CharacterBuilder.java        # Builder interface (Fluent API)
│   │   ├── MageCharacterBuilder.java    # Mage assembly and validation rules
│   │   └── WarriorCharacterBuilder.java # Warrior assembly and validation rules
│   ├── director/
│   │   └── CharacterDirector.java       # Predefined archetypes (Rookie, RaidBoss)
│   ├── model/
│   │   ├── ArmorType.java               # Armor category enum
│   │   ├── Character.java               # Product class
│   │   ├── CharacterClass.java          # Character class enum
│   │   └── WeaponType.java              # Weapon category enum
│   └── Main.java                        # Entry point and test cases
├── .gitignore
└── README.md
```
## Pattern Components

Product (model.Character): A complex character object containing attributes such as name, class, armor, weapon, stats, skills, and inventory. The object is immutable once constructed.

Builder (builder.CharacterBuilder): An interface declaring the construction steps using method chaining (fluent interface).

Abstract Builder (builder.BaseCharacterBuilder): Holds common setters and baseline validation (name, positive health) to eliminate redundant code across concrete builders.

Concrete Builders (WarriorCharacterBuilder, MageCharacterBuilder): Assemble specific character classes and enforce domain business rules inside build():
    Warrior: Must have a melee weapon, cannot equip cloth armor (CLOTH), and cannot use magic weapons (staffs or wands).
    Mage: Cannot wear plate armor (PLATE), cannot wield two-handed axes, and requires at least 50 base mana.

Director (director.CharacterDirector): Orchestrates repeatable character configurations (createDefaultRookie, createRaidBoss).

Client (Main): Demonstrates object creation via Director, manual assembly through fluent method chaining, and exception handling for invalid configurations.  

## Clean Code Principles

Validated Construction: The build() method verifies state correctness and throws an IllegalStateException with a descriptive message if constraints are violated.
No Magic Numbers: Numeric thresholds (such as MINIMUM_MAGE_MANA = 50) are defined as named constants.
DRY (Don't Repeat Yourself): Shared state fields, setters, and basic checks are encapsulated in BaseCharacterBuilder rather than duplicated in each concrete builder.
Intention-Revealing Names: Class, method, and variable names communicate their purpose clearly without unnecessary comments.
Immutability & Safe Encapsulation: All fields in Character are marked final, and collection properties are defensively copied using List.copyOf()

## How to Run

Open the project in IntelliJ IDEA

Ensure the src directory is marked as Sources Root.

Run src/Main.java
