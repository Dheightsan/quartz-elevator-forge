# Quartz Elevator for Forge 1.20.1 (unofficial port)

A port of [Quartz Elevator](https://modrinth.com/mod/quartz-elevator) by Aton-Kish from Fabric to Forge 1.20.1.

Put a quartz elevator on the ground and another one above it. Jump on the lower one to go up to the next, sneak to go down. There are two blocks, the quartz elevator (up to 16 blocks apart) and the smooth quartz elevator (up to 64).

All the design is Aton-Kish's work. This repository only moves it to Forge. See [NOTICE.md](NOTICE.md) for the credits and the list of changes.

## Recipes

- Quartz elevator: 4 quartz around an ender pearl (cross shape), or a quartz block and an ender pearl.
- Smooth quartz elevator: smelt a quartz elevator, or combine smooth quartz and an ender pearl.

## Requirements

- Minecraft 1.20.1
- Forge 47 or newer
- Install it on the server and on the clients. No other mods needed.

## Config

`config/quartzelv-common.toml`, created on first launch. Restart the game after editing it.

| Option | Default | |
|---|---|---|
| `quartzElevatorDistance` | 16 | Max distance for the quartz elevator |
| `smoothQuartzElevatorDistance` | 64 | Max distance for the smooth one |
| `mixTypes` | false | Let both types connect to each other |
| `isPlayerOnly` | false | Only players can use elevators |
| `displayParticles` | true | Particles around the elevators |

## Tested

- Dedicated server on a flat world: up, distance limits, blocked destination, slime and magma cube.
- Client: jump up, sneak down, both types, `mixTypes` on and off, `isPlayerOnly` on and off with a slime, particles, creative tab, the four recipes crafted in game, saving and reopening the world.
- Not tested: sound, `displayParticles=false`, other mobs, several players at once.

If something breaks, open an issue here with your `latest.log` and your mod list.

## Building

```
./gradlew build
```

The jar ends up in `build/libs`. You need JDK 17.

## License

MIT, same as the original. Copyright (c) 2021 Aton-Kish. See [LICENSE](LICENSE).
