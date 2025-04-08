package net.kaupenjoe.tutorialmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class BloodRushEffect extends StatusEffect {
    public BloodRushEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        // Optional: Custom behavior each tick
        // For example, you could boost speed or deal damage
        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true; // Apply effect every tick
    }
}
