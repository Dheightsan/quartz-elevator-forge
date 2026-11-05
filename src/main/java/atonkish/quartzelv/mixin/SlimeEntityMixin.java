package atonkish.quartzelv.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.level.Level;

import atonkish.quartzelv.QuartzElevatorConfig;
import atonkish.quartzelv.util.Teleport;
import atonkish.quartzelv.util.VerticalTeleporter;

@Mixin(Slime.class)
public abstract class SlimeEntityMixin extends Entity {
    public SlimeEntityMixin(EntityType<?> type, Level world) {
        super(type, world);
    }

    @Inject(at = @At("HEAD"), method = "jumpFromGround", cancellable = true)
    private void jump(CallbackInfo info) {
        if (!(this.level() instanceof ServerLevel)) {
            return;
        }

        // `isPlayerOnly`: false -> Slime entities can also teleport
        if (QuartzElevatorConfig.IS_PLAYER_ONLY.get()) {
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
