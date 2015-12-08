package io.github.funkynoodles.init;

import io.github.funkynoodles.FunkyMod;
import io.github.funkynoodles.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class FunkyItems {
	public static Item test_item;

	public static void init(){
		test_item = new Item().setUnlocalizedName("test_item").setCreativeTab(FunkyMod.tabFunky);
	}

	public static void register(){
		GameRegistry.registerItem(test_item, test_item.getUnlocalizedName().substring(5));
	}

	public static void registerRenders(){
		registerRender(test_item);
	}

	public static void registerRender(Item item){
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
