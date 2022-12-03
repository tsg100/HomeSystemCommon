package de.fynnhenck.homesystemcommon;

import de.fynnhenck.homesystemapi.api.HomeSystemDatabase;
import de.fynnhenck.homesystemcommon.commands.AddHomeCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HomesystemCommon extends JavaPlugin {

    @Override
    public void onEnable() {
//        Bukkit.getPluginManager().getPlugin("").isEnabled();
        registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands(){

        getCommand("sethome").setExecutor(new AddHomeCommand());

    }
}
