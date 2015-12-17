package io.github.funkynoodles.gui;

import org.lwjgl.opengl.GL11;

import io.github.funkynoodles.player.PlayerTemperature;
import io.github.funkynoodles.world.Season;
import io.github.funkynoodles.world.Temperature;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ThermoGui extends GuiIngame{

	protected final Minecraft mc;
	protected final FontRenderer fontRenderer;
	public static final ResourceLocation funky_icons = new ResourceLocation("minecraft", "textures/gui/funky_icons.png");
	WorldInfo worldInfo;

	public ThermoGui(Minecraft mcIn) {
		super(mcIn);
		this.fontRenderer = mcIn.fontRendererObj;
		// TODO Auto-generated constructor stub
		this.mc = mcIn;
	}

	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void renderThermoGui(RenderGameOverlayEvent event){
		ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		worldInfo = mc.theWorld.getWorldInfo();
		if (event.isCancelable() || event.type != ElementType.HEALTH) {
			return;
		}
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.mc.renderEngine.bindTexture(funky_icons);
		this.drawTexturedModalRect(scaledresolution.getScaledWidth()-25, scaledresolution.getScaledHeight()-58, 21, 0, 20, 54);
		PlayerTemperature.updateTemperature();
		this.drawCenteredString(fontRenderer, PlayerTemperature.getHeatFeeling(), scaledresolution.getScaledWidth()-50, scaledresolution.getScaledHeight()-70, 0xFFFFFF);
		this.drawCenteredString(fontRenderer, Double.toString(Temperature.getTemperature(mc.thePlayer.getPosition().getX(),mc.thePlayer.getPosition().getY(),mc.thePlayer.getPosition().getZ())), scaledresolution.getScaledWidth()-50, scaledresolution.getScaledHeight()-60, 0xFFFFFF);
		this.drawCenteredString(fontRenderer, Season.getSeason(), scaledresolution.getScaledWidth()-50, scaledresolution.getScaledHeight()-50, 0xFFFFFF);
		this.drawCenteredString(fontRenderer, Double.toString(PlayerTemperature.getBodyHeatLoss()), scaledresolution.getScaledWidth()-50, scaledresolution.getScaledHeight()-40, 0xFFFFFF);
		this.mc.renderEngine.bindTexture(icons);
	}
}
