package atonkish.quartzelv.block;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import atonkish.quartzelv.QuartzElevatorMod;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            QuartzElevatorMod.MOD_ID);

    public static final ResourceLocation QUARTZ_ELEVATOR_BLOCK_IDENTIFIER = new ResourceLocation(
            QuartzElevatorMod.MOD_ID, "quartz_elevator");
    public static final ResourceLocation SMOOTH_QUARTZ_ELEVATOR_IDENTIFIER = new ResourceLocation(
            QuartzElevatorMod.MOD_ID, "smooth_quartz_elevator");

    public static final RegistryObject<Block> QUARTZ_ELEVATOR_BLOCK = BLOCKS.register(
            QUARTZ_ELEVATOR_BLOCK_IDENTIFIER.getPath(),
            () -> new QuartzElevatorBlock(BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.QUARTZ)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(0.8f)));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_ELEVATOR = BLOCKS.register(
            SMOOTH_QUARTZ_ELEVATOR_IDENTIFIER.getPath(),
            () -> new QuartzElevatorBlock(BlockBehaviour.Properties
                    .of()
                    .mapColor(MapColor.QUARTZ)
                    .instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops()
                    .strength(2.0f, 6.0f)));
}
