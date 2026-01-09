package strhercules.modernchickens.item;

import strhercules.modernchickens.ChemicalEggRegistry;
import strhercules.modernchickens.ChemicalEggRegistryItem;
import strhercules.modernchickens.registry.ModRegistry;
import strhercules.modernchickens.item.ChickenItemHelper;
import net.minecraft.world.item.ItemStack;

public class ChemicalEggItem extends AbstractChemicalEggItem {
    public ChemicalEggItem(Properties properties) {
        super(properties, "item.chickens.chemical_egg.named", "item.chickens.chemical_egg.tooltip");
    }

    public static ItemStack createFor(ChemicalEggRegistryItem entry) {
        ItemStack stack = new ItemStack(ModRegistry.CHEMICAL_EGG.get());
        ChickenItemHelper.setChickenType(stack, entry.getId());
        return stack;
    }

    @Override
    protected ChemicalEggRegistryItem resolve(ItemStack stack) {
        return ChemicalEggRegistry.findById(ChickenItemHelper.getChickenType(stack));
    }
}
