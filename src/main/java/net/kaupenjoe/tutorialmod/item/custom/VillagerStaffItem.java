package net.kaupenjoe.tutorialmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.particle.ParticleTypes;

public class VillagerStaffItem extends Item {
    public VillagerStaffItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        if (!world.isClient) {
            Vec3d targetPos = getLookingAt(player, world, 20); // Get the block the player is looking at

            for (int i = 0; i < 5; i++) { // Summon 5 TNT
                TntEntity tnt = new TntEntity(world, targetPos.x, targetPos.y, targetPos.z, player);
                tnt.setFuse(0); // Instant explosion
                world.spawnEntity(tnt);
            }

            // Add explosion particles for better visual effect
            world.addParticle(ParticleTypes.EXPLOSION, targetPos.x, targetPos.y, targetPos.z, 0, 0, 0);
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }

    private Vec3d getLookingAt(PlayerEntity player, World world, double maxDistance) {
        Vec3d start = player.getEyePos();
        Vec3d look = player.getRotationVec(1.0F);
        Vec3d end = start.add(look.x * maxDistance, look.y * maxDistance, look.z * maxDistance);

        HitResult hitResult = world.raycast(new RaycastContext(
            start, end, RaycastContext.ShapeType.OUTLINE, RaycastContext.FluidHandling.NONE, player));

        return hitResult.getType() == HitResult.Type.MISS ? end : ((BlockHitResult) hitResult).getPos();
    }
}
