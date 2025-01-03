package net.healer.block;

import net.healer.HealerAPI;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

public final class HealerBlockSettings {















    /* Wood */

    public static Block createLogBlock(MapColor TopMapColor, MapColor sideMapColor, BlockSoundGroup BlockSoundGroup) {
        return new PillarBlock(AbstractBlock.Settings.create().mapColor((state) -> {
            return state.get(PillarBlock.AXIS) == Direction.Axis.Y ? TopMapColor : sideMapColor;
        }).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup).burnable());
    }

    public static Block createWoodBlock(MapColor MapColor, BlockSoundGroup BlockSoundGroup) {
        return new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSoundGroup).burnable());
    }

    public static Block createPlanksBlock(MapColor MapColor, BlockSoundGroup BlockSoundGroup) {
        return new Block(AbstractBlock.Settings.create().burnable().mapColor(MapColor).sounds(BlockSoundGroup).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F));
    }

    public static Block createWoodenStairsBlock(Block Block, MapColor MapColor, BlockSoundGroup BlockSoundGroup) {
        return new StairsBlock(Block.getDefaultState(), AbstractBlock.Settings.create().burnable().mapColor(MapColor).sounds(BlockSoundGroup).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F));
    }

    public static Block createWoodenSlabsBlock(MapColor MapColor, BlockSoundGroup BlockSoundGroup) {
        return new SlabBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor).sounds(BlockSoundGroup).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F));
    }

    public static Block createDoorBlock(BlockSetType BlockSetType, MapColor PlanksBlock) {
        return new DoorBlock(BlockSetType, AbstractBlock.Settings.create().mapColor(PlanksBlock).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY));
    }

    public static Block createTrapDoorBlock(BlockSetType BlockSetType, MapColor MapColor) {
        return new TrapdoorBlock(BlockSetType, AbstractBlock.Settings.create().mapColor(MapColor).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable());
    }

    public static Block createWoodenPressurePlateBlock(BlockSetType BlockSetType, MapColor PlanksBlock) {
        return new PressurePlateBlock(BlockSetType, AbstractBlock.Settings.create().mapColor(PlanksBlock).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY));
    }
    public static Block createWoodenButtonBlock(BlockSetType BlockSetType) {
        return new ButtonBlock(BlockSetType, 30, AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY));
    }

    public static Block createWoodenFenceBlock(MapColor PlanksBlock, BlockSoundGroup BlockSoundGroup) {
        return new FenceBlock(AbstractBlock.Settings.create().mapColor(PlanksBlock).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSoundGroup).burnable());
    }

    public static Block createWoodenFenceGateBlock(WoodType WoodType, MapColor PlanksBlock) {
        return new FenceGateBlock(WoodType, AbstractBlock.Settings.create().mapColor(PlanksBlock).solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).burnable());
    }







    /* Plants */


    public static Block createPileBlock(MapColor MapColor, BlockSoundGroup BlockSoundGroup) {
       return new PileBlock(AbstractBlock.Settings.create().mapColor(MapColor).strength(0.1F).ticksRandomly().sounds(BlockSoundGroup).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));
    }
    public static Block createLeavesBlock(MapColor MapColor, BlockSoundGroup BlockSoundGroup) {
        return new LeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor).sounds(BlockSoundGroup).strength(0.2F).ticksRandomly().nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));
    }
    public static Block createSaplingBlock(SaplingGenerator SaplingGenerator, MapColor MapColor, BlockSoundGroup BlockSoundGroup) {
        return new SaplingBlock(SaplingGenerator, AbstractBlock.Settings.create().mapColor(MapColor).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup).pistonBehavior(PistonBehavior.DESTROY));
    }
    public static Block createFlowerPotBlock(Block flower) {
        return new FlowerPotBlock(flower, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
    }






    /* register */


    public static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(HealerAPI.MOD_ID, name), block);
    }

    public static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(HealerAPI.MOD_ID, name), block);
    }

    public static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(HealerAPI.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void register() {
        HealerAPI.LOGGER.info("register " + HealerAPI.MOD_ID);
    }
}