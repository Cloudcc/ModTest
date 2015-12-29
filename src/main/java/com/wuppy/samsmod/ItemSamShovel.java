package com.wuppy.samsmod;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSpade;

public class ItemSamShovel extends ItemSpade
{
	public ItemSamShovel(ToolMaterial material, String name)
	{
		super(material);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		setTextureName(SamsMod.MODID + ":" + name);
	}

}


