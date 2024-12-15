package net.inkarter.barnsbound.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;

public class ModFoodProperties
{
public static final FoodProperties TOMATO = new FoodProperties.Builder().nutrition(3).saturationModifier(0.25f).effect(() -> new MobEffectInstance(MobEffects.HEALTH_BOOST, 600), 0.65f).build();


}
