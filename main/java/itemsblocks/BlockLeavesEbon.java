package itemsblocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class BlockLeavesEbon extends Block{

	public BlockLeavesEbon(Material material) {
		super(material);
		this.setStepSound(soundTypeGrass);
	}

	public String[] func_150125_e() {
		// TODO Auto-generated method stub
		return null;
	}
	public IIcon Side0;
	public IIcon Side1;
	public IIcon Side2;
	public IIcon Side3;
	public IIcon Side4;
	public IIcon Side5;

	public void registerBlockIcons(IIconRegister icon) {
		Side0 = icon.registerIcon("ai:leaves_ebon");
		Side1 = icon.registerIcon("ai:leaves_ebon");
		Side2 = icon.registerIcon("ai:leaves_ebon");
		Side3 = icon.registerIcon("ai:leaves_ebon");
		Side4 = icon.registerIcon("ai:leaves_ebon");
		Side5 = icon.registerIcon("ai:leaves_ebon");
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
	 public boolean isOpaqueCube()
	    {
	        return false;
}}

