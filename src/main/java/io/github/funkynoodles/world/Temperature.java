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

	public static double getTemperature(int x, int y, int z){
		double seaLevelTemperature = 27.0f; //temperature at y = 64
		double eyeLevelTemperature = 20.0f;

		long totalTime = worldInfo.getWorldTotalTime();
		long time = worldInfo.getWorldTime(); // current time 0 - 23999
		blockPos = new BlockPos(mc.getRenderViewEntity().posX, mc.getRenderViewEntity().getEntityBoundingBox().minY, mc.getRenderViewEntity().posZ);
		chunk = mc.theWorld.getChunkFromBlockCoords(blockPos);
		biomeName = chunk.getBiome(blockPos, mc.theWorld.getWorldChunkManager()).biomeName;
		if (biomeName == "Plains" || biomeName == "Forest" || biomeName == "River" || biomeName == "ForestHills" || biomeName == "Birch Forest" || biomeName == "Birch Forest Hills") {
			// y = 758.5732823x^4-1734.959567x^3+1119.824319x^2-147.4455886x+37.98285542
			seaLevelTemperature = 758.5732823*Math.pow(Season.getPecentOfYear(),4)-1734.959567*Math.pow(Season.getPecentOfYear(),3)+1119.824319*Math.pow(Season.getPecentOfYear(),2)-147.4455886*Season.getPecentOfYear()+37.98285542;
		}
		eyeLevelTemperature = seaLevelTemperature - 0.1f * (y - 64);
		return eyeLevelTemperature;
	}
}
