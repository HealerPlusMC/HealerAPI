package net.healer.block;


import net.healer.block.plant.HealerHangingLeavesBlock;
import net.healer.block.plant.HealerLeavesBlock;
import net.healer.block.plant.HealerPileBlock;
import net.healer.block.plant.HealerSaplingBlock;
import net.healer.block.wood.*;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.jetbrains.annotations.Nullable;


public class HealerBlockHelper {


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




     public static Block createSaplingBlock(TreeGrower TreeGrower, SoundType SoundType, MapColor MapColor) {
         return new SaplingBlock(TreeGrower, BlockBehaviour.Properties.of()
                 .noCollission()
                 .randomTicks()
                 .instabreak()
                 .pushReaction(PushReaction.DESTROY)
                 .mapColor(MapColor)
                 .sound(SoundType)
         );
     }

     public static Block createOtherSaplingBlock(TreeGrower TreeGrower, @Nullable TagKey<Block> FloorBlocks, @Nullable Block FloorBlock, SoundType SoundType, MapColor MapColor) {
         return new HealerSaplingBlock(TreeGrower, BlockBehaviour.Properties.of()
                 .noCollission()
                 .randomTicks()
                 .instabreak()
                 .pushReaction(PushReaction.DESTROY)
                 .mapColor(MapColor)
                 .sound(SoundType), FloorBlocks, FloorBlock
         );
     }

     public static Block createFlowerPotPlantBlock(Block PlantBlock) {
         return new FlowerPotBlock(PlantBlock, BlockBehaviour.Properties.of()
                 .instabreak()
                 .noOcclusion()
                 .pushReaction(PushReaction.DESTROY)
         );
     }

     public static Block createLeavesBlock(SoundType SoundType, MapColor MapColor) {
         return new HealerLeavesBlock(BlockBehaviour.Properties.of()
                 .mapColor(MapColor)
                 .sound(SoundType)
                 .strength(0.2F)
                 .randomTicks()
                 .noOcclusion()
                 .isValidSpawn(HealerBlockHelper::ocelotOrParrot)
                 .isSuffocating(HealerBlockHelper::never)
                 .isViewBlocking(HealerBlockHelper::never)
                 .ignitedByLava()
                 .pushReaction(PushReaction.DESTROY)
                 .isRedstoneConductor(HealerBlockHelper::never)
         );
     }

     public static Block createPileBlock(SoundType SoundType, MapColor MapColor) {
         return new HealerPileBlock(BlockBehaviour.Properties.of()
                 .mapColor(MapColor)
                 .sound(SoundType)
                 .strength(0.1F)
                 .randomTicks()
                 .noOcclusion()
                 .isValidSpawn(HealerBlockHelper::ocelotOrParrot)
                 .isSuffocating(HealerBlockHelper::never)
                 .isViewBlocking(HealerBlockHelper::never)
                 .ignitedByLava()
                 .pushReaction(PushReaction.DESTROY)
                 .isRedstoneConductor(HealerBlockHelper::never)
         );
     }

     public static Block createHangingLeavesBlock(SoundType SoundType, MapColor MapColor) {
         return new HealerHangingLeavesBlock(BlockBehaviour.Properties.of()
                 .mapColor(MapColor)
                 .sound(SoundType)
                 .strength(0.1F)
                 .randomTicks()
                 .noOcclusion()
                 .isSuffocating(HealerBlockHelper::never)
                 .isViewBlocking(HealerBlockHelper::never)
                 .ignitedByLava()
                 .pushReaction(PushReaction.DESTROY)
                 .isRedstoneConductor(HealerBlockHelper::never)
         );
     }

     public static Block createLogBlock(MapColor TopColor, MapColor SideColor, SoundType SoundType) {
         return new HealerLogBlock(BlockBehaviour.Properties.of()
                 .mapColor((Color) -> Color.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? TopColor : SideColor)
                 .sound(SoundType)
                 .ignitedByLava()
                 .strength(2.0F)
         );
     }

     public static Block createWoodBlock(MapColor Color, SoundType SoundType) {
         return new HealerWoodBlock(BlockBehaviour.Properties.of()
                 .mapColor(Color)
                 .sound(SoundType)
                 .ignitedByLava()
                 .strength(2.0F)
         );
     }

     public static Block createPlanksBlock(MapColor Color, SoundType SoundType) {
         return new HealerPlanksBlock(BlockBehaviour.Properties.of()
                 .mapColor(Color)
                 .instrument(NoteBlockInstrument.BASS)
                 .strength(2.0F, 3.0F)
                 .sound(SoundType)
                 .ignitedByLava()
         );
     }

     public static Block createWoodenStairsBlock(Block Block, MapColor MapColor, SoundType SoundType) {
         return new HealerFenceBlock(Block.defaultBlockState(), BlockBehaviour.Properties.of()
                 .mapColor(MapColor)
                 .sound(SoundType)
                 .instrument(NoteBlockInstrument.BASS)
                 .strength(2.0F, 3.0F)
                 .ignitedByLava()
         );
     }

     public static Block createWoodenSlabsBlock(MapColor MapColor, SoundType blockSound) {
         return new HealerSlabBlock(BlockBehaviour.Properties.of()
                 .mapColor(MapColor)
                 .sound(blockSound)
                 .instrument(NoteBlockInstrument.BASS)
                 .strength(2.0F, 3.0F)
                 .ignitedByLava()
         );
     }

     public static Block createWoodenDoorBlock(BlockSetType BlockSetType, MapColor MapColor) {
         return new DoorBlock(BlockSetType, BlockBehaviour.Properties.of()
                 .mapColor(MapColor)
                 .instrument(NoteBlockInstrument.BASS)
                 .strength(3.0F)
                 .noOcclusion()
                 .ignitedByLava()
                 .pushReaction(PushReaction.DESTROY)
         );
     }

     public static Block createWoodenTrapDoorBlock(BlockSetType BlockSetType, MapColor MapColor) {
         return new TrapDoorBlock(BlockSetType, BlockBehaviour.Properties.of()
                 .mapColor(MapColor)
                 .instrument(NoteBlockInstrument.BASS)
                 .strength(3.0F)
                 .noOcclusion()
                 .isValidSpawn(HealerBlockHelper::ocelotOrParrot)
                 .ignitedByLava()
         );
     }

     public static Block createOreWithUniformIntBlock(UniformInt UniformInt, BlockBehaviour.Properties Properties, MapColor MapColor, SoundType SoundType, float Strength, float Resistance) {
         return new DropExperienceBlock(UniformInt, Properties.mapColor(MapColor)
                 .sound(SoundType)
                 .instrument(NoteBlockInstrument.BASEDRUM)
                 .requiresCorrectToolForDrops()
                 .strength(Strength, Resistance)
         );
     }

     public static Block createOreWithConstantIntBlock(ConstantInt ConstantInt, BlockBehaviour.Properties Properties, MapColor MapColor, SoundType SoundType, float Strength, float Resistance) {
         return new DropExperienceBlock(ConstantInt, Properties.mapColor(MapColor)
                 .sound(SoundType)
                 .instrument(NoteBlockInstrument.BASEDRUM)
                 .requiresCorrectToolForDrops()
                 .strength(Strength, Resistance)
         );
     }

     private static Boolean ocelotOrParrot(BlockState BlockState, BlockGetter BlockGetter, BlockPos BlockPos, EntityType<?> eEntityType) {
         return eEntityType == EntityType.OCELOT || eEntityType == EntityType.PARROT;
     }

     private static boolean never(BlockState BlockState, BlockGetter BlockGetter, BlockPos BlockPos) {
         return false;
     }
}