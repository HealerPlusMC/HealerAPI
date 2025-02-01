package net.healer.block.plant;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HealerSaplingBlock extends SaplingBlock {
    private final @Nullable TagKey<Block> BlockTag;
    private final @Nullable Block SpecificBlock;

    public HealerSaplingBlock(TreeGrower TreeGrower, Properties Properties, @Nullable TagKey<Block> FloorBlocks, @Nullable Block FloorBlock) {
        super(TreeGrower, Properties);

        if (FloorBlocks == null && FloorBlock == null) {
            throw new IllegalArgumentException("You must specify at least one of TagKey<Block> or Block.");
        }

        this.BlockTag = FloorBlocks;
        this.SpecificBlock = FloorBlock;
    }

    @Override
    protected boolean mayPlaceOn(@NotNull BlockState state, @Nullable BlockGetter level, @Nullable BlockPos pos) {
        if (BlockTag != null && state.is(BlockTag)) {
            return true;
        }
        if (SpecificBlock != null && state.is(SpecificBlock)) {
            return true;
        }
        return false;
    }

    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return PlantType.get("custom");
    }
    /*-------------This Code Makes Sapling Grow On Either a Specific Tagged Block or a Specific Block-------------*/
}