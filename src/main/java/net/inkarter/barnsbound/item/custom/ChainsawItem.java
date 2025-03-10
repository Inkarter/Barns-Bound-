package net.inkarter.barnsbound.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Objects;

public class ChainsawItem extends Item//ctrl + left click Item to see more
{
    public ChainsawItem(Properties pProperties)
    {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext)
    {
        Level level = pContext.getLevel();

        if(!level.isClientSide())
        {
            if(level.getBlockState(pContext.getClickedPos()).is(BlockTags.LOGS))
            {
                level.destroyBlock(pContext.getClickedPos(), true,pContext.getPlayer());
                
                pContext.getItemInHand().hurtAndBreak(1, ((ServerLevel) level), ((ServerPlayer) pContext.getPlayer()),
                        item -> Objects.requireNonNull(pContext.getPlayer()).onEquippedItemBroken(item, EquipmentSlot.MAINHAND));
                
            }
        }
        return InteractionResult.CONSUME;//ctrl + left click InteractionResult to see more
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag)
    {
        if(Screen.hasShiftDown())   {
            tooltipComponents.add(Component.translatable("tooltip.barnsbound.chainsaw.tooltip.1"));
            tooltipComponents.add(Component.translatable("tooltip.barnsbound.chainsaw.tooltip.2"));
        }   else {
            tooltipComponents.add(Component.translatable("tooltip.barnsbound.chainsaw.tooltip.shift"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
