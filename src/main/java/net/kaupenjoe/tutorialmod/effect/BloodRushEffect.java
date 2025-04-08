package net.kaupenjoe.tutorialmod.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.LivingEntity;

import java.util.UUID;

public class BloodRushEffect extends StatusEffect {
    public BloodRushEffect(StatusEffectCategory category, int color) {
        super(category, color);

        // Add a Strength effect by modifying the attack damage attribute
        this.addAttributeModifier(
                EntityAttributes.GENERIC_ATTACK_DAMAGE,
                UUID.randomUUID().toString(), // Unique ID per modifier
                4.0D, // Amount of extra damage
                EntityAttributeModifier.Operation.ADD // <- CORRECT OPERATION ENUM
        );
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        // This returns true so the effect continues to apply each tick (optional)
        return false;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        // You can apply custom logic here too if needed
    }
}
