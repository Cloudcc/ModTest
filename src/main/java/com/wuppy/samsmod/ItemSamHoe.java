package com.wuppy.samsmod;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemHoe;

public class ItemSamHoe extends ItemHoe
{
	public ItemSamHoe(ToolMaterial material, String name)
	{
		super(material);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		setTextureName(SamsMod.MODID + ":" + name);
	}

}


