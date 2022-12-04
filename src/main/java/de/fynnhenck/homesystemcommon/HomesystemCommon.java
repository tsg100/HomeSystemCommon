package de.fynnhenck.homesystemcommon;

import de.fynnhenck.homesystemapi.api.HomeSystemDatabase;
import de.fynnhenck.homesystemcommon.commands.AddHomeCommand;
import de.fynnhenck.homesystemcommon.commands.DeleteHomeCommand;
import de.fynnhenck.homesystemcommon.commands.HomeCommand;
import de.fynnhenck.homesystemcommon.commands.HomesCommand;
import de.fynnhenck.homesystemcommon.config.ConfigFile;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class HomesystemCommon extends JavaPlugin {

    @Override
    public void onEnable() {
        ConfigFile config = new ConfigFile(this); //init config
//        Bukkit.getPluginManager().getPlugin("").isEnabled();
        registerCommands();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands(){

        getCommand("sethome").setExecutor(new AddHomeCommand());
        getCommand("home").setExecutor(new HomeCommand());
        getCommand("delhome").setExecutor(new DeleteHomeCommand());
        getCommand("homes").setExecutor(new HomesCommand());

    }
}
