package itemsblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockEbonLog extends BlockLog{

	public BlockEbonLog(Material p_i45394_1_) {
		super();
		this.setHardness(2f);
		this.setStepSound(soundTypeWood);
	}

public IIcon Side0;
public IIcon Side1;
public IIcon Side2;
public IIcon Side3;
public IIcon Side4;
public IIcon Side5;

public void registerBlockIcons(IIconRegister icon) {
	Side0 = icon.registerIcon("ai:log_ebon_top");
	Side1 = icon.registerIcon("ai:log_ebon_top");
	Side2 = icon.registerIcon("ai:log_ebon");
	Side3 = icon.registerIcon("ai:log_ebon");
	Side4 = icon.registerIcon("ai:log_ebon");
	Side5 = icon.registerIcon("ai:log_ebon");
}

public IIcon getIcon(int side, int meta) {
	if (side == 0) {
		return Side0;
	} else if (side == 1) {
		return Side1;
	} else if (side == 2) {
		return Side2;
	} else if (side == 3) {
		return Side3;
	} else if (side == 4) {
		return Side4;
	} else if (side == 5) {
		return Side5;

	}
	return null;
}
}

