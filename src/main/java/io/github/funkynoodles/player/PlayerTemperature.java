package io.github.funkynoodles.player;

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

	//@SubscribeEvent
	public static void updateTemperature(){
		blockPos = new BlockPos(mc.getRenderViewEntity().posX, mc.getRenderViewEntity().getEntityBoundingBox().minY, mc.getRenderViewEntity().posZ);
		chunk = mc.theWorld.getChunkFromBlockCoords(blockPos);
		biomeName = chunk.getBiome(blockPos, mc.theWorld.getWorldChunkManager()).biomeName;
		worldInfo.getWorldTime();
	}
}
