package Tools;

import main.Mainclass;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemIPickaxe extends ItemPickaxe{

	public ItemIPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
	
	}

	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return par2ItemStack.isItemEqual(new ItemStack(Mainclass.Infernium)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
}

