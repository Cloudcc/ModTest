package com.wuppy.samsmod;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;

public class ItemSamSpax extends ItemTool
{
	private static Set blocks = Sets.newHashSet(new Block[] {Blocks.planks, Blocks.bookshelf, Blocks.log, 
			Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.grass, Blocks.dirt, 
			Blocks.sand, Blocks.gravel, Blocks.snow_layer, Blocks.snow, Blocks.clay, Blocks.farmland, 
			Blocks.soul_sand, Blocks.mycelium});
	
	public ItemSamSpax(ToolMaterial material, String name)
	{
		super(3, material, blocks);
		setUnlocalizedName(SamsMod.MODID + "_" + name);
		setTextureName(SamsMod.MODID + ":" + name);
		
	}
	
    public boolean func_150897_b(Block block)
    {
        return block == Blocks.snow_layer ? true : block == Blocks.snow;
    }
    


    public float func_150893_a(ItemStack itemStack, Block block)
    {
        return 	block.getMaterial() != Material.wood && block.getMaterial() != Material.plants &&
        		block.getMaterial() != Material.vine ? 
        		super.func_150893_a(itemStack, block) : this.efficiencyOnProperMaterial;
    }
    
	   public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase,
			   EntityLivingBase par3EntityLivingBase)
	   {
		   par1ItemStack.damageItem(1, par3EntityLivingBase);
		   return true;
	   }
	  

}
