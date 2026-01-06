package fun.wich;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.TagFactory;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Function;

public class FlintBlockMod implements ModInitializer {
	public static final String MOD_ID = "wich";

	public static final Tag<Item> LIGHTS_FLINT = TagFactory.ITEM.create(new ResourceLocation(MOD_ID, "lights_flint"));

	public static final Block FLINT_BLOCK = register("flint_block", FlintBlock::new, Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(1.5F, 6.0F));
	public static Block register(String name, Function<Block.Properties, Block> blockFactory, Block.Properties properties) {
		return Registry.register(Registry.BLOCK, new ResourceLocation(MOD_ID, name), blockFactory.apply(properties));
	}
	public static final Item FLINT_BLOCK_ITEM = register("flint_block", properties -> new BlockItem(FLINT_BLOCK, properties), new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS));
	public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
		return Registry.register(Registry.ITEM, new ResourceLocation(MOD_ID, name), itemFactory.apply(properties));
	}

	@Override
	public void onInitialize() { }
}
