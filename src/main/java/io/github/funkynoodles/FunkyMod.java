package io.github.funkynoodles;

import io.github.funkynoodles.creativetabs.FunkyTab;
import io.github.funkynoodles.gui.ThermoGui;
import io.github.funkynoodles.init.FunkyBlocks;
import io.github.funkynoodles.init.FunkyItems;
import io.github.funkynoodles.proxy.CommonProxy;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
public class FunkyMod {

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static final FunkyTab tabFunky = new FunkyTab("tabFunky");

	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		FunkyBlocks.init();
		FunkyBlocks.register();
		FunkyItems.init();
		FunkyItems.register();
	}
	@EventHandler
	public void Init(FMLInitializationEvent event){
		proxy.registerRenders();
	}
	@EventHandler
	public void postInit(FMLPostInitializationEvent event){
		MinecraftForge.EVENT_BUS.register(new ThermoGui(Minecraft.getMinecraft()));
	}
}
