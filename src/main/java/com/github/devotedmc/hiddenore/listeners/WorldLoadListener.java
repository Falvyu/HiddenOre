package com.github.devotedmc.hiddenore.listeners;

import com.github.devotedmc.hiddenore.OreStripper;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldInitEvent;
import org.bukkit.generator.BlockPopulator;

import java.util.List;

public class WorldLoadListener implements Listener {

	private ConfigurationSection config;

	public WorldLoadListener(ConfigurationSection config) {
		this.config = config;
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
	public void onWorldLoad(WorldInitEvent event) {
		World world = event.getWorld();

		List<BlockPopulator> populators = world.getPopulators();

		populators.add(new OreStripper(config));
	}
}
