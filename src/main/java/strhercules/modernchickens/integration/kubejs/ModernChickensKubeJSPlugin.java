package strhercules.modernchickens.integration.kubejs;

import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.plugin.ClassFilter;
import dev.latvian.mods.kubejs.script.BindingRegistry;

public class ModernChickensKubeJSPlugin implements KubeJSPlugin {
    
    @Override
    public void registerClasses(ClassFilter filter) {
        filter.allow("strhercules.modernchickens.integration.kubejs");
        // Allow access to the machine recipe registry helpers exposed to KubeJS scripts.
        filter.allow("strhercules.modernchickens.integration.kubejs.MachineRecipeRegistry");
        filter.allow("strhercules.modernchickens.integration.kubejs.MachineRecipeRegistryType");
        filter.allow("strhercules.modernchickens.ChickensRegistry");
        filter.allow("strhercules.modernchickens.ChickensRegistryItem");
        filter.allow("strhercules.modernchickens.SpawnType");
    }
    
    @Override
    public void registerBindings(BindingRegistry bindings) {
        bindings.add("ChickensEvents", ChickenRegistryType.ChickensEventsWrapper.class);
        // Bind a dedicated machine-recipe event for KubeJS scripts.
        bindings.add("ChickensMachineRecipes", MachineRecipeRegistryType.MachineRecipesWrapper.class);
    }
}
