package atonkish.quartzelv;

import net.minecraftforge.common.ForgeConfigSpec;

public class QuartzElevatorConfig {
    public static final ForgeConfigSpec SPEC;
    public static final ForgeConfigSpec.IntValue QUARTZ_ELEVATOR_DISTANCE;
    public static final ForgeConfigSpec.IntValue SMOOTH_QUARTZ_ELEVATOR_DISTANCE;
    public static final ForgeConfigSpec.BooleanValue MIX_TYPES;
    public static final ForgeConfigSpec.BooleanValue IS_PLAYER_ONLY;
    public static final ForgeConfigSpec.BooleanValue DISPLAY_PARTICLES;

    static {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();
        QUARTZ_ELEVATOR_DISTANCE = builder
                .comment("Max Distance of Quartz Elevator")
                .defineInRange("quartzElevatorDistance", 16, 1, 4064);
        SMOOTH_QUARTZ_ELEVATOR_DISTANCE = builder
                .comment("Max Distance of Smooth Quartz Elevator")
                .defineInRange("smoothQuartzElevatorDistance", 64, 1, 4064);
        MIX_TYPES = builder
                .comment("Moving between Different Elevator Types")
                .define("mixTypes", false);
        IS_PLAYER_ONLY = builder
                .comment("Player Only")
                .define("isPlayerOnly", false);
        DISPLAY_PARTICLES = builder
                .comment("Display particles")
                .define("displayParticles", true);
        SPEC = builder.build();
    }
}
