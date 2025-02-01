package net.healer.block.plant;

import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.block.Block;
import net.minecraft.registry.tag.TagKey;

public class HealerOtherSaplingBlock extends SaplingBlock {
    private final TagKey<Block> BlockTag;
    private final Block SpecificBlock;

    public HealerOtherSaplingBlock(SaplingGenerator SaplingGenerator, Settings Settings, TagKey<Block> FloorBlocks, Block FloorBlock) {
        super(SaplingGenerator, Settings);
        if (FloorBlocks == null && FloorBlock == null) {
            throw new IllegalArgumentException("You must specify at least one of TagKey<Block> or Block.");
        }
        this.BlockTag = FloorBlocks;
        this.SpecificBlock = FloorBlock;
    }

    @Override
    protected boolean canPlantOnTop(BlockState Floor, BlockView World, BlockPos pos) {
        if (BlockTag != null && Floor.isIn(this.BlockTag)) {
            return true;
        }
        return SpecificBlock != null && Floor.isOf(this.SpecificBlock);
    }

    /*-------------This Code Makes Sapling Grow On Specific Tagged Blocks or Specific Block-------------*/
}
