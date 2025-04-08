package net.kaupenjoe.tutorialmod.effect;

import net.kaupenjoe.tutorialmod.TutorialMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> BLOOD_RUSH = registerStatusEffect("blood_rush",
            new BloodRushEffect(StatusEffectCategory.BENEFICIAL, 0xFF0000) // Red color
                    .addAttributeModifier(
                            EntityAttributes.GENERIC_ATTACK_DAMAGE,
                            "91aeaa56-376b-4498-935b-2f7f68070635", // Random UUID
                            4.0, // +4 Attack Damage
                            EntityAttributeModifier.Operation.ADDITION));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(
                Registries.STATUS_EFFECT,
                new Identifier(TutorialMod.MOD_ID, name),
                statusEffect
        );
    }

    public static void registerEffects() {
        TutorialMod.LOGGER.info("Registering Mod Effects for " + TutorialMod.MOD_ID);
    }
}
