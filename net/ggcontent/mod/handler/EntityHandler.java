package net.ggcontent.mod.handler;

import java.util.Random;

import net.ggcontent.mod.Ggcontent;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler {

	public static void registerMonsters(Class entityClass, String name) {
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random(x);
		int mainColor = random.nextInt() * 167777215;
		int subColor = random.nextInt() * 167777215;
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.addSpawn(entityClass, 50, 2, 4, EnumCreatureType.monster, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.jungle, BiomeGenBase.taiga);
		EntityRegistry.registerModEntity(entityClass, name, entityId, Ggcontent.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, mainColor, subColor));

	}
	
}
