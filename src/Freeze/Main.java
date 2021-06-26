package Freeze;

import Freeze.commands.Freeze;
import Freeze.commands.UnFreeze;
import Freeze.listeners.FreezeListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin{
    @Override
    public void onEnable() {
        getLogger().info("Freeze has been enabled.");

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new FreezeListener(), this);
        Objects.requireNonNull(this.getCommand("freeze")).setExecutor(new Freeze());
        Objects.requireNonNull(this.getCommand("unfreeze")).setExecutor(new UnFreeze());
    }

    @Override
    public void onDisable() {
        getLogger().info("Freeze has been disabled.");
    }
}