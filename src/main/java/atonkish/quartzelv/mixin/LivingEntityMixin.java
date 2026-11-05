package atonkish.quartzelv.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;

import atonkish.quartzelv.QuartzElevatorConfig;
import atonkish.quartzelv.util.Teleport;
import atonkish.quartzelv.util.VerticalTeleporter;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    public LivingEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "jumpFromGround", cancellable = true)
    private void jump(CallbackInfo info) {
        if (!(this.level() instanceof ServerLevel)) {
            return;
        }

        // `isPlayerOnly`: false -> all entities can teleport
        // `isPlayerOnly`: true -> only player entities can teleport
        if (QuartzElevatorConfig.IS_PLAYER_ONLY.get() && !this.getClass().equals(ServerPlayer.class)) {
            return;
        }

        VerticalTeleporter verticalTeleporter = (Double y) -> {
            this.moveTo(this.getX(), y, this.getZ());
            this.teleportTo(this.getX(), y, this.getZ());
            return (Void) null;
        };
        Teleport.teleportUp(this.level(), this.blockPosition(), this.getBoundingBox(), verticalTeleporter);
    }
}
