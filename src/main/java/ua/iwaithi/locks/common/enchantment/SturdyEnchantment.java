package ua.iwaithi.locks.common.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import ua.iwaithi.locks.common.init.LocksEnchantments;

public class SturdyEnchantment extends Enchantment
{
	public SturdyEnchantment()
	{
		super(Rarity.RARE, LocksEnchantments.LOCK_TYPE, new EquipmentSlot[] { EquipmentSlot.MAINHAND });
	}

	@Override
	public int getMinCost(int level)
	{
		return 5 + (level - 1) * 15;
	}

	@Override
	public int getMaxCost(int level)
	{
		return 50;
	}

	@Override
	public int getMaxLevel()
	{
		return 3;
	}
}