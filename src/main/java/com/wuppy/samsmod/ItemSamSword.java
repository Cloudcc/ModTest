package com.wuppy.samsmod;

import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

public class ItemSamSword extends ItemSword
{
	public ItemSamSword(ToolMaterial material, String name)
	{
		super(material);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		setTextureName(SamsMod.MODID + ":" + name);
	}

}

