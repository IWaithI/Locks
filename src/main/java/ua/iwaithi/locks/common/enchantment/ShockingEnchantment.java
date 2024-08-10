package ua.iwaithi.locks.common.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import ua.iwaithi.locks.common.init.LocksEnchantments;

public class ShockingEnchantment extends Enchantment
{
	public ShockingEnchantment()
	{
		super(Rarity.UNCOMMON, LocksEnchantments.LOCK_TYPE, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}

	@Override
	public int getMinCost(int level)
	{
		return 2 + (level - 1) * 9;
	}

	@Override
	public int getMaxCost(int level)
	{
		return this.getMinCost(level) + 30;
	}

	@Override
	public int getMaxLevel()
	{
		return 5;
	}
}