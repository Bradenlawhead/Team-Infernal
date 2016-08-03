package Tools;

import main.Mainclass;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;

public class ItemIAxe extends ItemAxe{

	public ItemIAxe(ToolMaterial p_i45327_1_) {
		super(p_i45327_1_);
		
	}
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return par2ItemStack.isItemEqual(new ItemStack(Mainclass.Infernium)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
}

