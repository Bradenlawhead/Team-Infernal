package Tools;

import main.Mainclass;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemBPickaxe extends ItemPickaxe{

	public ItemBPickaxe(ToolMaterial p_i45347_1_) {
		super(p_i45347_1_);
		
	}

	@Override
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
	return par2ItemStack.isItemEqual(new ItemStack(Mainclass.BloodRock)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
}
