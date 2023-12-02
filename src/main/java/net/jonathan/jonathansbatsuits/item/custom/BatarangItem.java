package net.jonathan.jonathansbatsuits.item.custom;

import net.jonathan.jonathansbatsuits.entity.client.projectiles.BatarangEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BatarangItem extends Item {
    public BatarangItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        user.getItemCooldownManager().set(this, 20);
        world.playSound(user, user.getBlockPos(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F,
                0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        if (!world.isClient) {
            BatarangEntity  batarangEntity = new BatarangEntity(world, user, itemStack);
            batarangEntity.setOwner(user);
            batarangEntity.initFromStack(itemStack);
            batarangEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 3.0F, 1.0F);
            world.spawnEntity(batarangEntity);
        }

        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }
}
