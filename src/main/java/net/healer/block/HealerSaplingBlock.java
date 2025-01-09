package net.healer.block;


import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.block.Block;
import net.minecraft.registry.tag.TagKey;

public class HealerSaplingBlock extends SaplingBlock {
    private final TagKey<Block> blocksToPlaceOn;

    public HealerSaplingBlock(SaplingGenerator generator, Settings settings, TagKey<Block> tag) {
        super(generator, settings);
        this.blocksToPlaceOn = tag;
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isIn(this.blocksToPlaceOn);
    }

    /*-------------This Code Makes Sapling Grow On Specific Tagged Blocks-------------*/
}
