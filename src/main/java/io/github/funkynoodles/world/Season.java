package io.github.funkynoodles.world;

import net.minecraft.client.Minecraft;
import net.minecraft.world.storage.WorldInfo;

public class Season {

	static Minecraft mc = Minecraft.getMinecraft();
	static WorldInfo worldInfo = mc.theWorld.getWorldInfo();

	// Total time elapsed in the world
	static long totalTime;
	// Current time in ticks 0-23999;
	static long worldTime;

	public Season(){

	}

	public static String getSeason(){
		// 30 in-game days a season
		String season = null;
		totalTime = worldInfo.getWorldTotalTime();
		worldTime = worldInfo.getWorldTime();
		short seasonNum = (short)((totalTime/24000/30) % 4);
		switch(seasonNum){
		case 0:
			season = "Spring";
			break;
		case 1:
			season = "Summer";
			break;
		case 2:
			season = "Fall";
			break;
		case 3:
			season = "Winter";
			break;
		}
		return season;
	}

	public static double getPecentOfYear(){
		double percent = 0;
		long yearTime = 24000 * 30 * 4;
		totalTime = worldInfo.getWorldTotalTime();
		worldTime = worldInfo.getWorldTime();
		percent = ((double)(totalTime % yearTime)) / yearTime;
		return percent;
	}
}
