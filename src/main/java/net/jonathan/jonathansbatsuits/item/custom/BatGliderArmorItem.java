package net.jonathan.jonathansbatsuits.item.custom;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.jonathan.jonathansbatsuits.entity.client.armor.renderers.BatGliderRenderer;
import net.jonathan.jonathansbatsuits.entity.client.armor.renderers.JonathansBatsuitRenderer;
import net.jonathan.jonathansbatsuits.item.ModArmorMaterials;
import net.jonathan.jonathansbatsuits.item.ModItems;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.RenderProvider;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.Animation;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class BatGliderArmorItem extends ArmorItem implements GeoItem {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);
    public BatGliderArmorItem(Type type, Settings settings) {
        super(ModArmorMaterials.BAT_GLIDER, type, settings);
    }
    @Override
    public void createRenderer(Consumer<Object> consumer) {

        consumer.accept(new RenderProvider() {
            private GeoArmorRenderer<?> renderer;

            @Override
            public BipedEntityModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot,
                                                                        BipedEntityModel<LivingEntity> original) {
                if(this.renderer == null)
                    this.renderer = new BatGliderRenderer();

                // This prepares our GeoArmorRenderer for the current render frame.
                // These parameters may be null however, so we don't do anything further with them
                this.renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);

                return this.renderer;
            }
        });
    }

    // Let's add our animation controller
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, 20, state -> {
            // Apply our generic idle animation.
            // Whether it plays or not is decided down below.
            state.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));

            // Let's gather some data from the state to use below
            // This is the entity that is currently wearing/holding the item
            Entity entity = state.getData(DataTickets.ENTITY);

            // We'll just have ArmorStands always animate, so we can return here
            if (entity instanceof ArmorStandEntity)
                return PlayState.CONTINUE;

            // For this example, we only want the animation to play if the entity is wearing all pieces of the armor
            // Let's collect the armor pieces the entity is currently wearing
            Set<Item> wornArmor = new ObjectOpenHashSet<>();

            for (ItemStack stack : entity.getArmorItems()) {
                // We can stop immediately if any of the slots are empty
                if (stack.isEmpty())
                    return PlayState.STOP;

                wornArmor.add(stack.getItem());
            }

            // Check each of the pieces match our set
            boolean isFullSet = wornArmor.containsAll(ObjectArrayList.of(ModItems.BAT_GLIDER));
            return isFullSet ? PlayState.CONTINUE : PlayState.STOP;
        }));

        controllers.add(new AnimationController<>(this, 0, state -> {
            state.getController().setAnimation(RawAnimation.begin().then("wing_spread", Animation.LoopType.HOLD_ON_LAST_FRAME));
            Entity entity = state.getData(DataTickets.ENTITY);

            if (entity instanceof LivingEntity livingEntity) {
                if (isWearingAll(livingEntity) && livingEntity.isFallFlying()) {
                    return PlayState.CONTINUE;
                }
            }
            return PlayState.STOP;
        }));
    }

    public static Boolean isWearingAll(LivingEntity entity) {
        return entity.getEquippedStack(EquipmentSlot.CHEST).isOf(ModItems.BAT_GLIDER);
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return this.renderProvider;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.literal("Use in the chest slot to glide without the use of rockets.").formatted(Formatting.GRAY));
        tooltip.add(Text.literal("Use in the cape slot to glide with a select batsuit.").formatted(Formatting.GRAY));
    }
}
