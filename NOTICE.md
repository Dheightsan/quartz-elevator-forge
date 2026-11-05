# Notice

## Original work

Quartz Elevator is made by Aton-Kish.

- Original mod (Fabric): https://modrinth.com/mod/quartz-elevator
- Original source: https://github.com/Aton-Kish/quartz-elevator, branch `1.20.4`, commit `099ca17` (2024-05-03), version 2.2.7.
- The original is licensed under the MIT License, copyright (c) 2021 Aton-Kish. The license text is in `LICENSE` and ships inside the jar as `LICENSE_quartz-elevator`.

This port is unofficial. Aton-Kish did not make it and does not support it. Please report bugs of the port here, not to them.

## What changed

The port is the 1.20.4 code of Quartz Elevator moved from Fabric to Forge 1.20.1. Blocks, recipes, models, textures, translations and behavior are the original ones.

- Mappings: the Java sources (12 classes, without the Mod Menu one) were translated by hand from Yarn to Mojang names.
- Registration: blocks, items and the creative tab use Forge `DeferredRegister`.
- Config: Auto Config is replaced by a Forge config file, `config/quartzelv-common.toml`, with the same five options and defaults.
- Mod Menu support is removed, since it is a Fabric mod. The language files still carry the old `text.autoconfig.*` keys, which nothing uses (the original has the same).
- The four mixins (entity jump, slime, magma cube and sneak) are kept. Slimes do not fire Forge's jump event, so an event handler would not have covered them.
- The icon is new.
- Data (recipes, advancements, loot tables, tags) and assets are the original ones, same content with the formatting changed.
