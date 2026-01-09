package strhercules.modernchickens.integration.jade;

import strhercules.modernchickens.ChickensMod;
import strhercules.modernchickens.block.AvianDousingMachineBlock;
import strhercules.modernchickens.block.AvianFluidConverterBlock;
import strhercules.modernchickens.block.AvianFluxConverterBlock;
import strhercules.modernchickens.block.BreederBlock;
import strhercules.modernchickens.block.CollectorBlock;
import strhercules.modernchickens.block.HenhouseBlock;
import strhercules.modernchickens.block.IncubatorBlock;
import strhercules.modernchickens.block.RoostBlock;
import strhercules.modernchickens.blockentity.AvianDousingMachineBlockEntity;
import strhercules.modernchickens.blockentity.AvianFluidConverterBlockEntity;
import strhercules.modernchickens.blockentity.AvianFluxConverterBlockEntity;
import strhercules.modernchickens.blockentity.BreederBlockEntity;
import strhercules.modernchickens.blockentity.CollectorBlockEntity;
import strhercules.modernchickens.blockentity.HenhouseBlockEntity;
import strhercules.modernchickens.blockentity.IncubatorBlockEntity;
import strhercules.modernchickens.blockentity.RoostBlockEntity;
import strhercules.modernchickens.entity.ChickensChicken;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

/**
 * Native Jade plugin that mirrors the WTHIT HUD so players get identical overlay
 * information regardless of which tooltip mod they prefer.
 */
@WailaPlugin(ChickensMod.MOD_ID)
public final class JadeIntegration implements IWailaPlugin {

    /**
     * Legacy hook retained for compatibility. The native Jade plugin is
     * discovered via {@link WailaPlugin} and no longer needs explicit IMC.
     */
    public static void init() {
        // no-op
    }

    @Override
    public void register(IWailaCommonRegistration registration) {
        registration.registerBlockDataProvider(AvianFluxConverterDataProvider.INSTANCE, AvianFluxConverterBlockEntity.class);
        registration.registerBlockDataProvider(AvianFluidConverterDataProvider.INSTANCE, AvianFluidConverterBlockEntity.class);
        registration.registerBlockDataProvider(AvianDousingMachineDataProvider.INSTANCE, AvianDousingMachineBlockEntity.class);
        registration.registerBlockDataProvider(ChickenContainerDataProvider.INSTANCE, RoostBlockEntity.class);
        registration.registerBlockDataProvider(ChickenContainerDataProvider.INSTANCE, BreederBlockEntity.class);
        registration.registerBlockDataProvider(ChickenContainerDataProvider.INSTANCE, CollectorBlockEntity.class);
        registration.registerBlockDataProvider(HenhouseDataProvider.INSTANCE, HenhouseBlockEntity.class);
        registration.registerBlockDataProvider(IncubatorDataProvider.INSTANCE, IncubatorBlockEntity.class);
    }

    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(ChickensHudComponentProvider.INSTANCE, AvianFluxConverterBlock.class);
        registration.registerBlockComponent(ChickensHudComponentProvider.INSTANCE, AvianFluidConverterBlock.class);
        registration.registerBlockComponent(ChickensHudComponentProvider.INSTANCE, AvianDousingMachineBlock.class);
        registration.registerBlockComponent(ChickensHudComponentProvider.INSTANCE, RoostBlock.class);
        registration.registerBlockComponent(ChickensHudComponentProvider.INSTANCE, BreederBlock.class);
        registration.registerBlockComponent(ChickensHudComponentProvider.INSTANCE, CollectorBlock.class);
        registration.registerBlockComponent(ChickensHudComponentProvider.INSTANCE, HenhouseBlock.class);
        registration.registerBlockComponent(ChickensHudComponentProvider.INSTANCE, IncubatorBlock.class);

        registration.registerEntityComponent(ChickensChickenProvider.INSTANCE, ChickensChicken.class);
        registration.addTooltipCollectedCallback(9999, JadeOverlaySanitiser.INSTANCE);
    }
}
