package atonkish.quartzelv.item;

import java.util.function.Supplier;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import atonkish.quartzelv.QuartzElevatorMod;
import atonkish.quartzelv.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            QuartzElevatorMod.MOD_ID);

    public static final RegistryObject<Item> QUARTZ_ELEVATOR_BLOCK = register(ModBlocks.QUARTZ_ELEVATOR_BLOCK);
    public static final RegistryObject<Item> SMOOTH_QUARTZ_ELEVATOR = register(ModBlocks.SMOOTH_QUARTZ_ELEVATOR);

    private static RegistryObject<Item> register(RegistryObject<Block> block) {
        Supplier<Item> item = () -> new BlockItem(block.get(), new Item.Properties());
        return ITEMS.register(block.getId().getPath(), item);
    }
}
