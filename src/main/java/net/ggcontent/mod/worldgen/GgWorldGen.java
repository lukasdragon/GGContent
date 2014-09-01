package net.ggcontent.mod.worldgen;

import java.util.Random;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;



public  class GgWorldGen implements IWorldGenerator {

	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkgenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId){
		case 0 :
			//Generate Our Surface World
				generateSurface(world, random, chunkX*16,chunkZ*16);
				
		case -1 :
			//Generate Our Nether World
				generateNether(world, random, chunkX*16,chunkZ*16);
				
		case 1 :
			//Generate Our End World
				generateEnd(world, random, chunkX*16,chunkZ*16);
			
		}
		
	}

	
	
	
	
	
	private void generateSurface(World world, Random random, int x, int z) {
		//this.addOreSpawn(Ggcontent.orename, world, random, x=blockXpos, z=blockzpos, maxX, maxZ, maxVeinSize, chancetospawn, minY, maxY
		this.addOreSpawn(Ggcontent.oreLukasOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 16, 38, 100);
		this.addOreSpawn(Ggcontent.oreAkermaniteOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 16, 38, 100);
		this.addOreSpawn(Ggcontent.oreNiobiumOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 16, 38, 100);
		this.addOreSpawn(Ggcontent.oreSpheneOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 16, 38, 100);
		this.addOreSpawn(Ggcontent.oreStibniteOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 16, 38, 100);
		this.addOreSpawn(Ggcontent.oreGodOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 14, 10, 100);		
		this.addOreSpawn(Ggcontent.blockSoftObsidianBlock, world, random, x, z, 16, 16, 2+random.nextInt(4), 15, 10, 60);
		
			}






		private void generateNether(World world, Random random, int x, int z) {
		// TODO Auto-generated method stub
			this.addNetherOreSpawn(Ggcontent.oreAlabasterOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 13, 38, 100);
			this.addNetherOreSpawn(Ggcontent.oreNiobiumNetherOre, world, random, x, z, 16, 16, 4+random.nextInt(6), 16, 38, 100);
	}

	private void generateEnd(World world, Random random, int x, int z) {
		// TODO Auto-generated method stub
	
	}


	
	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int BlockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
		for(int i = 0; i < chanceToSpawn; i++ ) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = BlockZPos + random.nextInt(maxZ);
			(new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
			
		}
		
		
		
	}
	
	private void addNetherOreSpawn(Block block, World world, Random random, int blockXPos, int BlockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY) {
		for(int i = 0; i < chanceToSpawn; i++ ) {
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = BlockZPos + random.nextInt(maxZ);
			(new WorldGenNetherMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
			
		}
		
		
		
	}
	
}

	
	

		
	
	
		
		
	


