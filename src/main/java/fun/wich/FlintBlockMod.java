package fun.wich;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MapColor;

import java.util.function.Function;

public class FlintBlockMod implements ModInitializer {
	public static final String MOD_ID = "wich";

	public static final TagKey<Item> LIGHTS_FLINT = TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, "lights_flint"));

	public static final Block FLINT_BLOCK = register("flint_block", FlintBlock::new, Block.Properties.ofFullCopy(Blocks.STONE).mapColor(MapColor.COLOR_BLACK));
	public static Block register(String name, Function<Block.Properties, Block> blockFactory, Block.Properties properties) {
		return Registry.register(BuiltInRegistries.BLOCK, ResourceKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath(MOD_ID, name)), blockFactory.apply(properties));
	}
	public static final Item FLINT_BLOCK_ITEM = register("flint_block", properties -> new BlockItem(FLINT_BLOCK, properties), new Item.Properties());
	public static Item register(String name, Function<Item.Properties, Item> itemFactory, Item.Properties properties) {
		return Registry.register(BuiltInRegistries.ITEM, ResourceKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(MOD_ID, name)), itemFactory.apply(properties));
	}

	@Override
	public void onInitialize() {
		ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(tab -> tab.accept(FLINT_BLOCK_ITEM));
	}
}
