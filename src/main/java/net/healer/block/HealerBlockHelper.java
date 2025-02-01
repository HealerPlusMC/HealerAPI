package net.healer.block;

import net.healer.block.plant.HealerHangingLeavesBlock;
import net.healer.block.plant.HealerOtherSaplingBlock;
import net.healer.block.plant.HealerPileBlock;
import net.healer.block.plant.HealerSaplingBlock;
import net.healer.block.wood.*;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.BlockView;

public final class HealerBlockHelper {

    /**
     * These Are Helper Methods To Create Different Types Of Blocks, Such As Logs, Saplings, Leaves, And Ores.
     * <p>
     * All Blocks Are Customized With Settings Like Colors, Sounds, Interactions With Entities, And Resistance To Certain Effects.
     * Each Method Uses Specific Parameters For Customization Such As MapColor, BlockSoundGroup, And BlockSetType.
     * <p>
     * The Following Methods Allow Easy Creation Of Blocks With Various Behaviors And Attributes:
     * <p>
     * <p>
     * <b>Plant Blocks:<b/> <b>Saplings, Leaves, Piles<b/>
     * </p>
     * <p>
     * <b>Wood Blocks:<b/> <b>Logs, Planks, Stairs, Doors<b/>
     * </p>
     * <p>
     * <b>Ore Blocks:<b/> <b>With Custom Drop Rates For Experience<b/>
     * </p>
     * <p>
     * The Goal Is To Simplify Block Creation For Mod Developers By Using These Helper Methods For Registration.
     */




    public static Block createPileBlock(MapColor MapColor, BlockSoundGroup BlockSound) {
        return new HealerPileBlock(AbstractBlock.Settings.create()
                .mapColor(MapColor)
                .strength(0.1F)
                .ticksRandomly()
                .sounds(BlockSound)
                .nonOpaque()
                .allowsSpawning(HealerBlockHelper::canSpawnOnLeaves)
                .suffocates(HealerBlockHelper::never)
                .blockVision(HealerBlockHelper::never)
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY)
                .solidBlock(HealerBlockHelper::never));
    }

    public static Block createHangingLeavesBlock(MapColor MapColor, BlockSoundGroup BlockSound) {
        return new HealerHangingLeavesBlock(AbstractBlock.Settings.create()
                .mapColor(MapColor)
                .strength(0.1F)
                .ticksRandomly()
                .sounds(BlockSound)
                .nonOpaque()
                .suffocates(HealerBlockHelper::never)
                .blockVision(HealerBlockHelper::never)
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY)
                .solidBlock(HealerBlockHelper::never));
    }

    public static Block createLeavesBlock(MapColor MapColor, BlockSoundGroup BlockSound) {
        return new LeavesBlock(AbstractBlock.Settings.create()
                .mapColor(MapColor)
                .sounds(BlockSound)
                .strength(0.2F)
                .ticksRandomly()
                .nonOpaque()
                .allowsSpawning(HealerBlockHelper::canSpawnOnLeaves)
                .suffocates(HealerBlockHelper::never)
                .blockVision(HealerBlockHelper::never)
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY)
                .solidBlock(HealerBlockHelper::never));
    }

    public static Block createSaplingBlock(SaplingGenerator SaplingGenerator, MapColor MapColor, BlockSoundGroup BlockSound) {
        return new HealerSaplingBlock(SaplingGenerator, AbstractBlock.Settings.create()
                .mapColor(MapColor)
                .noCollision()
                .ticksRandomly()
                .breakInstantly()
                .sounds(BlockSound)
                .pistonBehavior(PistonBehavior.DESTROY));
    }

    public static Block createOtherSaplingBlock(SaplingGenerator SaplingGenerator, MapColor MapColor, BlockSoundGroup BlockSound, TagKey<Block> FloorBlocks, Block FloorBlock) {
        return new HealerOtherSaplingBlock(SaplingGenerator, AbstractBlock.Settings.create()
                .mapColor(MapColor)
                .noCollision()
                .ticksRandomly()
                .breakInstantly()
                .sounds(BlockSound)
                .pistonBehavior(PistonBehavior.DESTROY), FloorBlocks, FloorBlock);
    }

    public static Block createFlowerPotPlantBlock(Block PlantBlock) {
        return new FlowerPotBlock(PlantBlock, AbstractBlock.Settings.create()
                .breakInstantly()
                .nonOpaque()
                .pistonBehavior(PistonBehavior.DESTROY));
    }

    public static Block createLogBlock(MapColor TopMapColor, MapColor SideMapColor, BlockSoundGroup BlockSound) {
        return new PillarBlock(AbstractBlock.Settings.create()
                .mapColor((state) -> {
                    return state.get(PillarBlock.AXIS) == Direction.Axis.Y ? TopMapColor : SideMapColor;
                })
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sounds(BlockSound)
                .burnable());
    }

    public static Block createWoodBlock(MapColor MapColor, BlockSoundGroup BlockSound) {
        return new PillarBlock(AbstractBlock.Settings.create()
                .mapColor(MapColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F)
                .sounds(BlockSound)
                .burnable());
    }

    public static Block createPlanksBlock(MapColor MapColor, BlockSoundGroup BlockSound) {
        return new Block(AbstractBlock.Settings.create()
                .burnable()
                .mapColor(MapColor)
                .sounds(BlockSound)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F, 3.0F));
    }

    public static Block createWoodenStairsBlock(Block Block, MapColor MapColor, BlockSoundGroup BlockSound) {
        return new HealerStairsBlock(Block.getDefaultState(), AbstractBlock.Settings.create()
                .burnable()
                .mapColor(MapColor)
                .sounds(BlockSound)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F, 3.0F));
    }

    public static Block createWoodenSlabsBlock(MapColor MapColor, BlockSoundGroup BlockSound) {
        return new SlabBlock(AbstractBlock.Settings.create()
                .burnable()
                .mapColor(MapColor)
                .sounds(BlockSound)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F, 3.0F));
    }

    public static Block createWoodenDoorBlock(BlockSetType BlockSetType, MapColor PlanksBlock) {
        return new HealerDoorBlock(BlockSetType, AbstractBlock.Settings.create()
                .mapColor(PlanksBlock)
                .instrument(NoteBlockInstrument.BASS)
                .strength(3.0F)
                .nonOpaque()
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY));
    }

    public static Block createWoodenTrapDoorBlock(BlockSetType BlockSetType, MapColor MapColor) {
        return new HealerTrapdoorBlock(BlockSetType, AbstractBlock.Settings.create()
                .mapColor(MapColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(3.0F)
                .nonOpaque()
                .allowsSpawning(HealerBlockHelper::never)
                .burnable());
    }

    public static Block createWoodenPressurePlateBlock(BlockSetType BlockSetType, MapColor PlanksBlock) {
        return new HealerPressurePlateBlock(BlockSetType, AbstractBlock.Settings.create()
                .mapColor(PlanksBlock)
                .solid()
                .instrument(NoteBlockInstrument.BASS)
                .noCollision()
                .strength(0.5F)
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY));
    }

    public static Block createWoodenButtonBlock(BlockSetType BlockSetType) {
        return new HealerButtonBlock(BlockSetType, 30, AbstractBlock.Settings.create()
                .noCollision()
                .strength(0.5F)
                .pistonBehavior(PistonBehavior.DESTROY));
    }

    public static Block createWoodenFenceBlock(MapColor PlanksBlock, BlockSoundGroup BlockSound) {
        return new FenceBlock(AbstractBlock.Settings.create()
                .mapColor(PlanksBlock)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F, 3.0F)
                .sounds(BlockSound)
                .burnable());
    }

    public static Block createWoodenFenceGateBlock(WoodType WoodType, MapColor PlanksBlock) {
        return new FenceGateBlock(WoodType, AbstractBlock.Settings.create()
                .mapColor(PlanksBlock)
                .solid()
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F, 3.0F)
                .burnable());
    }

    public static Block createOreWithUniformIntBlock(UniformIntProvider UniformInt, AbstractBlock.Settings Settings, MapColor MapColor, BlockSoundGroup SoundType, float Strength, float Resistance) {
        return new ExperienceDroppingBlock(UniformInt, Settings.mapColor(MapColor).sounds(SoundType).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(Strength, Resistance));
    }

    public static Block createOreWithConstantIntBlock(ConstantIntProvider ConstantInt, AbstractBlock.Settings Settings, MapColor MapColor, BlockSoundGroup SoundType, float Strength, float Resistance) {
        return new ExperienceDroppingBlock(ConstantInt, Settings.mapColor(MapColor).sounds(SoundType).instrument(NoteBlockInstrument.BASEDRUM).requiresTool().strength(Strength, Resistance));
    }

    public static boolean never(BlockState State, BlockView World, BlockPos BlockPos, EntityType<?> Type) {
        return false;
    }

    public static boolean never(BlockState State, BlockView World, BlockPos BlockPos) {
        return false;
    }

    public static Boolean canSpawnOnLeaves(BlockState state, BlockView world, BlockPos BlockPos, EntityType<?> Type) {
        return Type == EntityType.OCELOT || Type == EntityType.PARROT;
    }
}