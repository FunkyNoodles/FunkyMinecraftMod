package io.github.funkynoodles.player;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;

public class PlayerMethods {
	static Minecraft mc = Minecraft.getMinecraft();
	static EntityPlayer player = mc.thePlayer;
	static BlockPos blockPos = new BlockPos(mc.getRenderViewEntity().posX, mc.getRenderViewEntity().getEntityBoundingBox().minY, mc.getRenderViewEntity().posZ);

	public short findBlockInRadius(){

		short distance = -1;
		return distance;
	}
}
