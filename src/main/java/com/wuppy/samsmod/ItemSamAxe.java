package com.wuppy.samsmod;

import net.minecraft.item.ItemAxe;

public class ItemSamAxe extends ItemAxe 
{
	public ItemSamAxe(ToolMaterial material, String name)
	{
		super(material);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		setTextureName(SamsMod.MODID + ":" + name);
	}

}

