package io.github.funkynoodles.creativetabs;

import io.github.funkynoodles.init.FunkyItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class FunkyTab extends CreativeTabs{

	public FunkyTab(String label) {
		super(label);
		this.setBackgroundImageName("funky.png");
	}

	@Override
	public Item getTabIconItem() {
		// TODO Auto-generated method stub
		return FunkyItems.test_item;
	}

}
