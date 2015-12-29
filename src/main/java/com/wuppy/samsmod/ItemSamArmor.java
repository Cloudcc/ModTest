package com.wuppy.samsmod;

import com.sun.xml.internal.stream.Entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemSamArmor extends ItemArmor
{
	public ItemSamArmor(ArmorMaterial material, int armorType, String name)
	{
		super(material, 0, armorType);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		setTextureName(SamsMod.MODID + ":" + name);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() == SamsMod.samhelmet || stack.getItem() == SamsMod.samchest || stack.getItem() == SamsMod.samboots)
		{
			return SamsMod.MODID + ":models/armor/samarmor1.png";
		}
		else if(stack.getItem() == SamsMod.samleggings)
		{
			return SamsMod.MODID + ":models/armor/samarmor2.png";
		}
		else
		{
			System.out.println("Invalid Item");
			return null;
		}
	}
	
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if(itemStack.getItem() == SamsMod.samhelmet)
		{
			if(player.isInWater())
			{
				player.setAir(20);
			}
		}
			
		
	}

}
