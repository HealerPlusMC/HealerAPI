package net.healer;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(HealerAPI.MOD_ID)
public class HealerAPI {
    public static final String MOD_ID = "healer";
    private static final Logger LOGGER = LogUtils.getLogger();


    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    private static final ForgeConfigSpec SPEC = BUILDER.build();

    public HealerAPI() {
        IEventBus EventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }
}