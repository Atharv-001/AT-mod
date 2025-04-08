package net.kaupenjoe.tutorialmod.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.util.math.Vec3d;

import java.util.UUID;

public class SlimeyEffect extends StatusEffect {
    public SlimeyEffect(StatusEffectCategory category, int color) {
        super(category, color);

        // 💡 OPTIONAL: Add attribute modifier (e.g., increase movement speed)
        // Uncomment if needed
        /*
        this.addAttributeModifier(EntityAttributes.GENERIC_MOVEMENT_SPEED,
                "91AEAA56-376B-4498-935B-2F7F68070635", // Use a unique UUID!
                0.1, // 10% speed increase
                EntityAttributeModifier.Operation.MULTIPLY_TOTAL);
        */
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity.horizontalCollision) {
            Vec3d initialVec = entity.getVelocity();
            Vec3d climbVec = new Vec3d(initialVec.x, 0.2D, initialVec.z);
            entity.setVelocity(climbVec.multiply(0.96D));
            return true;
        }

        return super.applyUpdateEffect(entity, amplifier);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
