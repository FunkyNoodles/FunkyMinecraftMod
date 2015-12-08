package io.github.funkynoodles.proxy;

import io.github.funkynoodles.init.FunkyBlocks;
import io.github.funkynoodles.init.FunkyItems;

public class ClientProxy extends CommonProxy{
	@Override
	public void registerRenders(){
		FunkyItems.registerRenders();
		FunkyBlocks.registerRenders();
	}
}
