package de.fynnhenck.homesystemcommon.commands;

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

        if(sender instanceof Player){
            Player p = ((Player) sender).getPlayer();
            if(p.hasPermission(HomePermissions.ADD_PERMISSION)){

            }else{
                p.sendMessage(ChatColor.RED + HomeMessages.NO_PERMISSION);
                return true;
            }


        }

        return false;
    }
}
