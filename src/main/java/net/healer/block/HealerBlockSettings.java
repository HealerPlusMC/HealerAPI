package net.healer.block;

import net.healer.HealerAPI;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;

public class HealerBlockSettings {




    /*
     * To use any of the block settings, you will need to create an EXAMPLE BLOCK:
     *
     * Example:
     * public static final Block EXAMPLE_LOG = createLogBlock( // Here Choose any Option You Want
     *     MapColor.BLACK,  // Top color
     *     MapColor.WHITE,  // Side color
     *     BlockSoundGroup.WOOD // Block Sounds
     * );
     *
     */




    /* Wood */


    public static Block createLogBlock(MapColor TopMapColor, MapColor sideMapColor, BlockSoundGroup BlockSound) {
        return new PillarBlock(AbstractBlock.Settings.create().mapColor((state) -> {
            return state.get(PillarBlock.AXIS) == Direction.Axis.Y ? TopMapColor : sideMapColor;
        }).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSound).burnable());
    }
    public static Block createWoodBlock(MapColor MapColor, BlockSoundGroup BlockSound) {
        return new PillarBlock(AbstractBlock.Settings.create().mapColor(MapColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sounds(BlockSound).burnable());
    }
    public static Block createPlanksBlock(MapColor MapColor, BlockSoundGroup BlockSound) {
        return new Block(AbstractBlock.Settings.create().burnable().mapColor(MapColor).sounds(BlockSound).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F));
    }
    public static Block createWoodenStairsBlock(Block Block, MapColor MapColor, BlockSoundGroup BlockSound) {
        return new StairsBlock(Block.getDefaultState(), AbstractBlock.Settings.create().burnable().mapColor(MapColor).sounds(BlockSound).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F));
    }
    public static Block createWoodenSlabsBlock(MapColor MapColor, BlockSoundGroup BlockSound) {
        return new SlabBlock(AbstractBlock.Settings.create().burnable().mapColor(MapColor).sounds(BlockSound).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F));
    }
    public static Block createWoodenDoorBlock(BlockSetType BlockSetType, MapColor PlanksBlock) {
        return new DoorBlock(BlockSetType, AbstractBlock.Settings.create().mapColor(PlanksBlock).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().burnable().pistonBehavior(PistonBehavior.DESTROY));
    }
    public static Block createWoodenTrapDoorBlock(BlockSetType BlockSetType, MapColor MapColor) {
        return new TrapdoorBlock(BlockSetType, AbstractBlock.Settings.create().mapColor(MapColor).instrument(NoteBlockInstrument.BASS).strength(3.0F).nonOpaque().allowsSpawning(Blocks::never).burnable());
    }
    public static Block createWoodenPressurePlateBlock(BlockSetType BlockSetType, MapColor PlanksBlock) {
        return new PressurePlateBlock(BlockSetType, AbstractBlock.Settings.create().mapColor(PlanksBlock).solid().instrument(NoteBlockInstrument.BASS).noCollision().strength(0.5F).burnable().pistonBehavior(PistonBehavior.DESTROY));
    }
    public static Block createWoodenButtonBlock(BlockSetType BlockSetType) {
        return new ButtonBlock(BlockSetType, 30, AbstractBlock.Settings.create().noCollision().strength(0.5F).pistonBehavior(PistonBehavior.DESTROY));
    }
    public static Block createWoodenFenceBlock(MapColor PlanksBlock, BlockSoundGroup BlockSound) {
        return new FenceBlock(AbstractBlock.Settings.create().mapColor(PlanksBlock).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sounds(BlockSound).burnable());
    }
    public static Block createWoodenFenceGateBlock(WoodType WoodType, MapColor PlanksBlock) {
        return new FenceGateBlock(WoodType, AbstractBlock.Settings.create().mapColor(PlanksBlock).solid().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).burnable());
}





    /* Plants */


    public static Block createPileBlock(MapColor MapColor, BlockSoundGroup BlockSound) {
       return new PileBlock(AbstractBlock.Settings.create().mapColor(MapColor).strength(0.1F).ticksRandomly().sounds(BlockSound).nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));
    }
    public static Block createLeavesBlock(MapColor MapColor, BlockSoundGroup BlockSound) {
        return new LeavesBlock(AbstractBlock.Settings.create().mapColor(MapColor).sounds(BlockSound).strength(0.2F).ticksRandomly().nonOpaque().allowsSpawning(Blocks::canSpawnOnLeaves).suffocates(Blocks::never).blockVision(Blocks::never).burnable().pistonBehavior(PistonBehavior.DESTROY).solidBlock(Blocks::never));
    }
    public static Block createSaplingBlock(SaplingGenerator SaplingGenerator, MapColor MapColor, BlockSoundGroup BlockSound) {
        return new SaplingBlock(SaplingGenerator, AbstractBlock.Settings.create().mapColor(MapColor).noCollision().ticksRandomly().breakInstantly().sounds(BlockSound).pistonBehavior(PistonBehavior.DESTROY));
    }
    public static Block createOtherSaplingBlock(SaplingGenerator SaplingGenerator, MapColor MapColor, BlockSoundGroup BlockSound, TagKey<Block> FloorBlock) {
        return new HealerSaplingBlock(SaplingGenerator, AbstractBlock.Settings.create().mapColor(MapColor).noCollision().ticksRandomly().breakInstantly().sounds(BlockSound).pistonBehavior(PistonBehavior.DESTROY), FloorBlock);
    }
    public static Block createFlowerPotPlantBlock(Block PlantBlock) {
        return new FlowerPotBlock(PlantBlock, AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY));
    }





















    /*-----------Do Not Use It-----------*/
    /*-----------register----------------*/
    public static void register() {
        HealerAPI.LOGGER.info("register " + HealerAPI.MOD_ID);
    }
}