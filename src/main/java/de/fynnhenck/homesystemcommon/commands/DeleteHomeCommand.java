package de.fynnhenck.homesystemcommon.commands;

import de.fynnhenck.homesystemapi.api.HomeSystemDatabase;
import de.fynnhenck.homesystemcommon.config.HomeMessages;
import de.fynnhenck.homesystemcommon.config.HomePermissions;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DeleteHomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){
            Player p = ((Player) sender).getPlayer();
            if(p.hasPermission(HomePermissions.DELETE_PERMISSION)){
                if(args.length == 1){
                    HomeSystemDatabase hsdb = new HomeSystemDatabase();
                    if(hsdb.deleteHome(p.getUniqueId(), args[0])){
                        p.sendMessage(ChatColor.GREEN + HomeMessages.DELETE_SINGLE.replace("$home$", args[0]));
                    }else{
                        p.sendMessage(ChatColor.RED + HomeMessages.NO_HOME_FOUND.replace("$hom$", args[0]));
                    }
                    return true;
                }
            }else{//No permission
                p.sendMessage(ChatColor.RED + HomeMessages.NO_PERMISSION);
                return true;
            }

        }else{//sender != Player
            sender.sendMessage("Dieser Befehl muss von einem Spieler ausgeführt werden!");
        }

        return false;
    }
}
