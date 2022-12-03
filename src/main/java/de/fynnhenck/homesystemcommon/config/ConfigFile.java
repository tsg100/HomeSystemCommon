package de.fynnhenck.homesystemcommon.config;

import de.fynnhenck.homesystemcommon.HomesystemCommon;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFile {

    public ConfigFile(HomesystemCommon main){

        FileConfiguration config = main.getConfig();
        main.saveDefaultConfig();


        String addHomePermission = config.getString("permission.addHome");
        String deleteHomePermission = config.getString("permission.deleteHome");
        String teleportHomePermission = config.getString("permission.teleportHome");
        String listHomePermission = config.getString("permission.listHome");

        HomePermissions hpc = new HomePermissions(addHomePermission, deleteHomePermission, teleportHomePermission, listHomePermission);

        String noPermMessage = config.getString("message.noPermission");
        String guiTeleport = config.getString("message.guiTeleport");
        String guiDelete = config.getString("message.guiDelete");
        String deleteSingle = config.getString("message.deleteSingleConfirmation");
        String deleteAll = config.getString("message.deleteAllConformation");
        String guiTitle = config.getString("message.guiTitle");
        String teleportSuccess = config.getString("message.teleportSuccess");

        HomeMessages msg = new HomeMessages(noPermMessage, guiTeleport, guiDelete, deleteSingle, deleteAll, guiTitle, teleportSuccess);

    }

}
