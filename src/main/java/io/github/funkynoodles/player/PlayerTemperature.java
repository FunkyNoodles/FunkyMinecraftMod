package io.github.funkynoodles.player;

import io.github.funkynoodles.world.Temperature;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.storage.WorldInfo;

public class PlayerTemperature {
	static Minecraft mc = Minecraft.getMinecraft();
	static EntityPlayer player = mc.thePlayer;

	float footTemperature;
	static Chunk chunk;
	static BlockPos blockPos = new BlockPos(mc.getRenderViewEntity().posX, mc.getRenderViewEntity().getEntityBoundingBox().minY, mc.getRenderViewEntity().posZ);
	static String biomeName;
	static WorldInfo worldInfo = mc.theWorld.getWorldInfo();

	static final float SKIN_THERMAL_CONDUCTIVITY = 0.209f; //source: http://users.ece.utexas.edu/~valvano/research/Thermal.pdf
	static final double STEPHAN_BOLTZMANN = 5.67 * Math.pow(10, -8);
	static final float SKIN_EMISSIVITY = 0.99f; // source: http://www.optotherm.com/emiss-table.htm

	static final float CHILLY_BOUNDARY = -0.4f;
	static final float COLD_BOUNDARY = -0.6f;
	static final float VERY_COLD_BOUNDARY = -0.8f;
	static final float WARM_BOUNDARY = 0.4f;
	static final float HOT_BOUNDARY = 0.6f;
	static final float VERY_HOT_BOUNDARY = 0.8f;


	//Temperature at which human feel best when naked is around 27C, source: http://www.ncbi.nlm.nih.gov/pubmed/17929604
	//So heat generation by body is roughly 2.09W, considering skin is 1 unit area
	static double bodyHeadGeneration = 2.09;

	static double bodyTemperature = 37; // in C
	static double bodyHeatLoss = 0; // in Watts
	static double totalThermalConductivity;

	//@SubscribeEvent
	public static void updateTemperature(){
		blockPos = new BlockPos(mc.getRenderViewEntity().posX, mc.getRenderViewEntity().getEntityBoundingBox().minY, mc.getRenderViewEntity().posZ);
		chunk = mc.theWorld.getChunkFromBlockCoords(blockPos);
		biomeName = chunk.getBiome(blockPos, mc.theWorld.getWorldChunkManager()).biomeName;
		worldInfo.getWorldTime();

		totalThermalConductivity = SKIN_THERMAL_CONDUCTIVITY;

		bodyHeatLoss = bodyHeadGeneration + totalThermalConductivity * (Temperature.getTemperature(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ()) - bodyTemperature);
		if(player.isInWater()){
		}
	}

	public static double getBodyHeatLoss(){
		return bodyHeatLoss;
	}

	public static String getHeatFeeling(){
		String heatFeeling = null;
		if (bodyHeatLoss < WARM_BOUNDARY && bodyHeatLoss > CHILLY_BOUNDARY) {
			heatFeeling  = "Normal";
		}else if(bodyHeatLoss <= CHILLY_BOUNDARY && bodyHeatLoss > COLD_BOUNDARY){
			heatFeeling = "Chilly";
		}else if(bodyHeatLoss <= COLD_BOUNDARY && bodyHeatLoss > VERY_COLD_BOUNDARY){
			heatFeeling = "Cold";
		}else if(bodyHeatLoss <= VERY_COLD_BOUNDARY){
			heatFeeling = "Very Cold";
		}else if(bodyHeatLoss >= WARM_BOUNDARY && bodyHeatLoss < HOT_BOUNDARY){
			heatFeeling = "Warm";
		}else if(bodyHeatLoss >= HOT_BOUNDARY && bodyHeatLoss < VERY_HOT_BOUNDARY){
			heatFeeling = "Hot";
		}else if(bodyHeatLoss >= VERY_HOT_BOUNDARY){
			heatFeeling = "Very Hot";
		}
		return heatFeeling;
	}
}
