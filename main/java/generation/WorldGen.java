package generation;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import main.Mainclass;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

public class WorldGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator,
			IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case 1:
	        generateEnd(world, random, chunkX, chunkZ); {}
		      break;
		case 0:
	         generateOverworld(world, random, chunkX, chunkZ); {}
		         break;
	    case -1:
	          generateNether(world, random, chunkX, chunkZ); {}
	         break;
	         }
	}
	
	
	
	public void generateNether(World world, Random rand, int x, int z) {
		generateOre(Mainclass.BloodRockOre, world, rand, x, z, 2, 5, 20, 0, 100, Blocks.netherrack);
		generateOre(Mainclass.InferniumOre, world, rand, x, z, 2, 5, 10, 0, 100, Blocks.netherrack);
		generateOre(Mainclass.StarcilliumOre, world, rand, x, z, 2, 5, 20, 0, 100, Blocks.netherrack);
		
		                                
	} 

	public void generateOverworld(World world, Random rand, int x, int z) {
		generateOre(Mainclass.BasaltRock, world, rand, x, z, 2, 10, 50, 0, 10, Blocks.stone);
		
		}

	public void generateEnd(World world, Random rand, int x, int z) {
	}
	
	
	
	public void generateOre(Block block, World world, Random random, int chunkX, int chunkZ, int minVeinSize,
			int maxVeinSize, int chances, int minY, int maxY, Block generateIn) {
		int veinSize = minVeinSize + random.nextInt(maxVeinSize - minVeinSize);
		int heightRange = maxY - minY;
		WorldGenMinable gen = new WorldGenMinable(block, veinSize, generateIn);
		for (int i = 0; i < chances; i++) {
			int xRand = chunkX * 16 + random.nextInt(16);
			int yRand = random.nextInt(heightRange) + minY;
			int zRand = chunkZ * 16 + random.nextInt(16);
			gen.generate(world, random, xRand, yRand, zRand);
		}
	}
}
