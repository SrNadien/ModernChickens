package strhercules.modernchickens.registry;

import strhercules.modernchickens.ChickensMod;
import strhercules.modernchickens.menu.AvianChemicalConverterMenu;
import strhercules.modernchickens.menu.AvianDousingMachineMenu;
import strhercules.modernchickens.menu.AvianFluxConverterMenu;
import strhercules.modernchickens.menu.AvianFluidConverterMenu;
import strhercules.modernchickens.menu.BreederMenu;
import strhercules.modernchickens.menu.CollectorMenu;
import strhercules.modernchickens.menu.IncubatorMenu;
import strhercules.modernchickens.menu.HenhouseMenu;
import strhercules.modernchickens.menu.RoostMenu;
import strhercules.modernchickens.menu.NestMenu;
import strhercules.modernchickens.menu.RoosterMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

/**
 * Central point for container menu registrations. Each entry pairs with a
 * client-side screen registered in {@link strhercules.modernchickens.ChickensClient}.
 */
public final class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES =
            DeferredRegister.create(Registries.MENU, ChickensMod.MOD_ID);

    public static final DeferredHolder<MenuType<?>, MenuType<HenhouseMenu>> HENHOUSE = MENU_TYPES.register("henhouse",
            () -> IMenuTypeExtension.create(HenhouseMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<RoostMenu>> ROOST = MENU_TYPES.register("roost",
            () -> IMenuTypeExtension.create(RoostMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<NestMenu>> NEST = MENU_TYPES.register("nest",
            () -> IMenuTypeExtension.create(NestMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<RoosterMenu>> ROOSTER = MENU_TYPES.register("rooster",
            () -> IMenuTypeExtension.create(RoosterMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<BreederMenu>> BREEDER = MENU_TYPES.register("breeder",
            () -> IMenuTypeExtension.create(BreederMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<CollectorMenu>> COLLECTOR = MENU_TYPES.register("collector",
            () -> IMenuTypeExtension.create(CollectorMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<AvianFluxConverterMenu>> AVIAN_FLUX_CONVERTER = MENU_TYPES.register("avian_flux_converter",
            () -> IMenuTypeExtension.create(AvianFluxConverterMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<AvianFluidConverterMenu>> AVIAN_FLUID_CONVERTER = MENU_TYPES.register("avian_fluid_converter",
            () -> IMenuTypeExtension.create(AvianFluidConverterMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<AvianChemicalConverterMenu>> AVIAN_CHEMICAL_CONVERTER = MENU_TYPES.register("avian_chemical_converter",
            () -> IMenuTypeExtension.create(AvianChemicalConverterMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<AvianDousingMachineMenu>> AVIAN_DOUSING_MACHINE = MENU_TYPES.register("avian_dousing_machine",
            () -> IMenuTypeExtension.create(AvianDousingMachineMenu::new));
    public static final DeferredHolder<MenuType<?>, MenuType<IncubatorMenu>> INCUBATOR = MENU_TYPES.register("incubator",
            () -> IMenuTypeExtension.create(IncubatorMenu::new));

    private ModMenuTypes() {
    }

    public static void init(IEventBus modBus) {
        MENU_TYPES.register(modBus);
    }
}
