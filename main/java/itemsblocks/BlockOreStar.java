package itemsblocks;

import java.util.Random;

import main.Mainclass;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

public class BlockOreStar extends Block{

	public BlockOreStar(Material p_i45394_1_) {
		super(p_i45394_1_);
		this.setHardness(6.0f);
		this.setHarvestLevel("pickaxe", 3);
	}

	@Override
	public Item getItemDropped(int metadata, Random rand, int fortune) {
		return Mainclass.Starcillium;
	}
}

