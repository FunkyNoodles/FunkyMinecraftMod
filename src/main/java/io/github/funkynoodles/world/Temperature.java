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

		double percentOfYear;

		long totalTime = worldInfo.getWorldTotalTime();
		long time = worldInfo.getWorldTime(); // current time 0 - 23999
		blockPos = new BlockPos(mc.getRenderViewEntity().posX, mc.getRenderViewEntity().getEntityBoundingBox().minY, mc.getRenderViewEntity().posZ);
		chunk = mc.theWorld.getChunkFromBlockCoords(blockPos);
		biomeName = chunk.getBiome(blockPos, mc.theWorld.getWorldChunkManager()).biomeName;
		percentOfYear = Season.getPecentOfYear();
		if (biomeName == "Plains" || biomeName == "Forest" || biomeName == "River" || biomeName == "ForestHills" || biomeName == "Birch Forest" || biomeName == "Birch Forest Hills") {
			// y = 758.5732823x^4-1734.959567x^3+1119.824319x^2-147.4455886x+37.98285542
			seaLevelTemperature = 758.5732823*Math.pow(percentOfYear,4)-1734.959567*Math.pow(percentOfYear,3)+1119.824319*Math.pow(percentOfYear,2)-147.4455886*percentOfYear+37.98285542;
		}else if(biomeName == "Taiga" || biomeName == "TaigaHills" || biomeName == "Cold Beach" || biomeName == "Cold Taiga" || biomeName == "Cold Taiga Hills" || biomeName == "Mega Taiga" || biomeName == "Mega Taiga Hills"){
			// y = 1432.267152x^4-3004.56006x^3+1714.769997x^2-145.8904002x-5.958768014
			seaLevelTemperature = 1432.267152*Math.pow(percentOfYear, 4)-3004.56006*Math.pow(percentOfYear, 3)+1714.769997*Math.pow(percentOfYear, 2)-145.8904002*percentOfYear-5.958768014;
		}
		//switch to Celsius
		seaLevelTemperature = (seaLevelTemperature - 32) / 1.8;
		eyeLevelTemperature = seaLevelTemperature - 0.1f * (y - 64);
		return eyeLevelTemperature;
	}
}
