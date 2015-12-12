package io.github.funkynoodles.world;

import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.WorldInfo;

public class Temperature {
	static Minecraft mc = Minecraft.getMinecraft();

	float footTemperature;

	static Chunk chunk;
	static BlockPos blockPos = new BlockPos(mc.getRenderViewEntity().posX, mc.getRenderViewEntity().getEntityBoundingBox().minY, mc.getRenderViewEntity().posZ);
	static String biomeName;
	static WorldInfo worldInfo = mc.theWorld.getWorldInfo();

	public static float getTemperature(int x, int y, int z){
		float seaLevelTemperature = 27.0f;
		float eyeLevelTemperature = 20.0f;
		eyeLevelTemperature = seaLevelTemperature - 0.1f * (y - 64);
		return eyeLevelTemperature;
	}
}
