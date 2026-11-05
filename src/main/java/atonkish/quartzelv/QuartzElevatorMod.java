package atonkish.quartzelv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import atonkish.quartzelv.block.ModBlocks;
import atonkish.quartzelv.item.ModItemGroups;
import atonkish.quartzelv.item.ModItems;

@Mod(QuartzElevatorMod.MOD_ID)
public class QuartzElevatorMod {
	public static final String MOD_ID = "quartzelv";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public QuartzElevatorMod() {
		IEventBus modBus = FMLJavaModLoadingContext.get().getModEventBus();

		// Blocks
		ModBlocks.BLOCKS.register(modBus);

		// Items
		ModItems.ITEMS.register(modBus);
		ModItemGroups.ITEM_GROUPS.register(modBus);

		// Config (config/quartzelv-common.toml; the Fabric original used Auto Config)
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, QuartzElevatorConfig.SPEC);
	}
}
