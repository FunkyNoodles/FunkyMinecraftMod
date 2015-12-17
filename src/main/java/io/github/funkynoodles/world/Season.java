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

	static final short monthLength = 1; // in in-game days
	static final long dayLength = 24000; // in ticks

	public Season(){

	}

	public static String getSeason(){
		// 30 in-game days a season
		String season = null;
		totalTime = worldInfo.getWorldTotalTime();
		worldTime = worldInfo.getWorldTime();
		short seasonNum = (short)((totalTime/dayLength/monthLength) % 4);
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
		long yearLength = dayLength * monthLength * 4;
		totalTime = worldInfo.getWorldTotalTime();
		worldTime = worldInfo.getWorldTime();
		percent = ((double)(totalTime % yearLength)) / yearLength;
		return percent;
	}
}
