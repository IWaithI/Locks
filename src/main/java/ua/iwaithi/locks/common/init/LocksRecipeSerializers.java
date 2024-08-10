package ua.iwaithi.locks.common.init;

import melonslise.locks.common.recipe.KeyRecipe;
import net.minecraft.data.recipes.SpecialRecipeBuilder;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ua.iwaithi.locks.Locks;

public final class LocksRecipeSerializers
{
	public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, Locks.ID);

	public static final RegistryObject<RecipeSerializer<KeyRecipe>> KEY = add("crafting_key", new SpecialRecipeBuilder(KeyRecipe::new));

	private LocksRecipeSerializers() {}

	public static void register()
	{
		RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static <T extends Recipe<?>> RegistryObject<RecipeSerializer<T>> add(String name, RecipeSerializer<T> serializer)
	{
		return RECIPE_SERIALIZERS.register(name, () -> serializer);
	}
}