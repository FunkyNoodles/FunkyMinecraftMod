package io.github.funkynoodles;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ThermoGui extends GuiIngame{

	protected final Minecraft mc;
	public static final ResourceLocation funky_icons = new ResourceLocation("minecraft", "textures/gui/funky_icons.png");

	public ThermoGui(Minecraft mcIn) {
		super(mcIn);
		// TODO Auto-generated constructor stub
		this.mc = mcIn;
	}
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void renderThermoGui(RenderGameOverlayEvent event){
		ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		//this.mc.renderEngine.bindTexture(funky_icons);
		//this.mc.getTextureManager().bindTexture(funky_icons);
		//this.drawTexturedModalRect(scaledresolution.getScaledWidth()-25, scaledresolution.getScaledHeight()-58, 21, 0, 20, 54);

		if (event.isCancelable() || event.type != ElementType.HEALTH) {
			return;
		}
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		//this.mc.renderEngine.bindTexture(funky_icons);
		this.mc.renderEngine.bindTexture(funky_icons);
		this.drawTexturedModalRect(scaledresolution.getScaledWidth()-25, scaledresolution.getScaledHeight()-58, 21, 0, 20, 54);
		//this.mc.getTextureManager().bindTexture(funky_icons);
		this.mc.renderEngine.bindTexture(icons);


	}
}
