package player;

import com.mojang.authlib.GameProfile;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class PlayerTemperature{

	Minecraft mc = Minecraft.getMinecraft();
	EntityPlayer player = mc.thePlayer;

	float playerTemperature = 37; // Default normal temperature

}
