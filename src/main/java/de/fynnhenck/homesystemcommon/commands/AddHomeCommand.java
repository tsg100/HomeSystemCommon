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


public class AddHomeCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player){ //Check if sender is Player
            Player p = ((Player) sender).getPlayer(); //Cast Player to a local variable
            if(p.hasPermission(HomePermissions.ADD_PERMISSION)){ //Permission check
                //Check if args have right length
                if(args.length == 1){
                    //TODO: Regex home name
                    HomeSystemDatabase hsdb = new HomeSystemDatabase();
                    if(hsdb.setHome(p, args[0])){
                        p.sendMessage(ChatColor.GREEN + HomeMessages.SET_HOME.replace("$home$", args[0])); //Display message to youser; Replace variable with set home name
                    }else{//Name duplicate
                        p.sendMessage(ChatColor.RED + HomeMessages.HOME_DUPLICATE.replace("$home$", args[0]));
                    }
                    return true;

                }
            }else{
                p.sendMessage(ChatColor.RED + HomeMessages.NO_PERMISSION);
                return true;
            }

        }else{
            sender.sendMessage("Dieser Befehl muss von einem Spieler ausgeführt werden!");
        }

        return false;
    }
}
