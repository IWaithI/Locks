package ua.iwaithi.locks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import melonslise.locks.common.config.LocksClientConfig;
import melonslise.locks.common.config.LocksConfig;
import melonslise.locks.common.config.LocksServerConfig;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;
import ua.iwaithi.locks.common.init.*;

@Mod(Locks.ID)
public final class Locks
{
	public static final String ID = "locks";

	public static final Logger LOGGER = LogManager.getLogger();

	public Locks()
	{
		ModLoadingContext.get().registerConfig(Type.SERVER, LocksServerConfig.SPEC);
		ModLoadingContext.get().registerConfig(Type.COMMON, LocksConfig.SPEC);
		ModLoadingContext.get().registerConfig(Type.CLIENT, LocksClientConfig.SPEC);

		LocksItems.register();
		LocksEnchantments.register();
		LocksSoundEvents.register();
		LocksContainerTypes.register();
		LocksRecipeSerializers.register();
	}
}