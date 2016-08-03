package Tools;

import java.util.List;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import main.Mainclass;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class InfernalArmor extends ItemArmor {

	public InfernalArmor(ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (this.armorType == 2) {

			{
				return "ai:textures/models/armor/infernal_layer_2.png";
			}
		}
		return "ai:textures/models/armor/infernal_layer_1.png";
	}
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return par2ItemStack.isItemEqual(new ItemStack(Mainclass.Infernium)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
}

