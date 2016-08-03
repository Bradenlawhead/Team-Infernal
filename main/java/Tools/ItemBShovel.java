package Tools;

import main.Mainclass;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class ItemBShovel extends ItemSpade{

	public ItemBShovel(ToolMaterial p_i45353_1_) {
		super(p_i45353_1_);
		
	}
	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return par2ItemStack.isItemEqual(new ItemStack(Mainclass.BloodRock)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
}
