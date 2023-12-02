package net.jonathan.jonathansbatsuits.item.custom;

import net.jonathan.jonathansbatsuits.entity.client.projectiles.SmokePelletEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class SmokePelletItem extends Item {
    public SmokePelletItem(Settings settings) {super(settings);}

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        super.use(world, user, hand);
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 20);
        if (!world.isClient) {
            SmokePelletEntity smokePelletEntity = new SmokePelletEntity(world, user);
            smokePelletEntity.setOwner(user);
            smokePelletEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 1.0F);
            world.playSound((PlayerEntity) null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F,
                    0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
            world.spawnEntity(smokePelletEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
