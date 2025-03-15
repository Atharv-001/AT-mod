package net.kaupenjoe.tutorialmod.item.custom;

import net.minecraft.entity.TntEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.sound.SoundEvents;

public class VillagerStaffItem extends Item {
    public VillagerStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            Vec3d targetPos = getTargetPosition(player);

            for (int i = 0; i < 5; i++) {
                summonExplodingTNT(world, targetPos);
            }

            // Play a villager sound when used
            world.playSound(null, player.getBlockPos(), SoundEvents.ENTITY_VILLAGER_YES, player.getSoundCategory(), 1.0F, 1.0F);
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }

    private Vec3d getTargetPosition(PlayerEntity player) {
        Vec3d eyePos = player.getEyePos();
        Vec3d lookVec = player.getRotationVec(1.0F);
        return eyePos.add(lookVec.multiply(5)); // Adjust if needed
    }

    private void summonExplodingTNT(World world, Vec3d pos) {
        TntEntity tnt = new TntEntity(world, pos.x, pos.y, pos.z, null);
        tnt.setFuse(0); // Instant explosion
        world.spawnEntity(tnt);
    }
}
