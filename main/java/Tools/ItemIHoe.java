package Tools;

import main.Mainclass;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;

public class ItemIHoe extends ItemHoe{

	public ItemIHoe(ToolMaterial p_i45343_1_) {
		super(p_i45343_1_);
		
	}
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return par2ItemStack.isItemEqual(new ItemStack(Mainclass.Infernium)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
}
