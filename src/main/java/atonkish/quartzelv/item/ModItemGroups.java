package atonkish.quartzelv.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import atonkish.quartzelv.QuartzElevatorMod;

public class ModItemGroups {
    public static final DeferredRegister<CreativeModeTab> ITEM_GROUPS = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB, QuartzElevatorMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> QUARTZ_ELEVATOR = ITEM_GROUPS.register("quartz_elevator",
            () -> CreativeModeTab
                    .builder()
                    .title(Component.translatable(
                            String.format("itemGroup.%s.%s", QuartzElevatorMod.MOD_ID, "quartz_elevator")))
                    .icon(() -> new ItemStack(ModItems.QUARTZ_ELEVATOR_BLOCK.get()))
                    .displayItems((params, content) -> {
                        content.accept(ModItems.QUARTZ_ELEVATOR_BLOCK.get());
                        content.accept(ModItems.SMOOTH_QUARTZ_ELEVATOR.get());
                    })
                    .build());
}
