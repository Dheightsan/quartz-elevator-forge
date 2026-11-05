package atonkish.quartzelv.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;

import atonkish.quartzelv.QuartzElevatorConfig;
import atonkish.quartzelv.util.Teleport;
import atonkish.quartzelv.util.VerticalTeleporter;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Inject(at = @At("HEAD"), method = "setShiftKeyDown", cancellable = true)
    private void setSneaking(boolean sneaking, CallbackInfo info) {
        Entity self = (Entity) (Object) this;
        if (!(self.level() instanceof ServerLevel)) {
            return;
        }

        // `isPlayerOnly`: false -> all entities can teleport
        // `isPlayerOnly`: true -> only player entities can teleport
        if (QuartzElevatorConfig.IS_PLAYER_ONLY.get() && !self.getClass().equals(ServerPlayer.class)) {
            return;
        }

        if (sneaking) {
            VerticalTeleporter verticalTeleporter = (Double y) -> {
                self.moveTo(self.getX(), y, self.getZ());
                self.teleportTo(self.getX(), y, self.getZ());
                return (Void) null;
            };
            Teleport.teleportDown(self.level(), self.blockPosition(), self.getBoundingBox(), verticalTeleporter);
        }
    }
}
