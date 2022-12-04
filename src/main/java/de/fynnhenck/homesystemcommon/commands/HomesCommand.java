package de.fynnhenck.homesystemcommon.commands;

import de.fynnhenck.homesystemapi.api.Home;
import de.fynnhenck.homesystemapi.api.HomeSystemDatabase;
import de.fynnhenck.homesystemcommon.config.HomeMessages;
import de.fynnhenck.homesystemcommon.config.HomePermissions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.createInventory;

public class HomesCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player){
            Player p = ((Player) sender).getPlayer();
            if(p.hasPermission(HomePermissions.LIST_PERMISSION)){
                HomeSystemDatabase hsdb = new HomeSystemDatabase();
                Inventory inv = createInventory(null, 54, HomeMessages.GUI_TITLE);
                ArrayList<Home> homes = hsdb.getHomes(p.getUniqueId());
                List<String> lore = new ArrayList<>();
                lore.add(HomeMessages.GUI_TELEPORT);

                for(int i = 0; i < homes.size(); i++){
                    ItemStack item = new ItemStack(Material.PAPER); //Einzelne homes
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName(ChatColor.YELLOW + homes.get(i).getName());
                    meta.setLore(lore);
                    item.setItemMeta(meta);
                    inv.setItem(i, item);
                }

                ItemStack placeholder = new ItemStack(Material.BLACK_STAINED_GLASS_PANE); //Trenner
                for(int i = 45; i < 53; i++){
                    inv.setItem(i, placeholder);
                }

                ItemStack delete = new ItemStack(Material.BARRIER); //all homes bdelete item
                ItemMeta deleteMeta = delete.getItemMeta();
                deleteMeta.setDisplayName(ChatColor.RED + "Alle Homes löschen");
                delete.setItemMeta(deleteMeta);
                inv.setItem(49, delete);

                p.openInventory(inv);

                return true;
            }else{//no Permission
                p.sendMessage(ChatColor.RED + HomeMessages.NO_PERMISSION);
                return true;
            }

        }else{ //Sender != Player
            sender.sendMessage("Dieser Befehl muss von einem Spieler ausgeführt werden!");
            return true;
        }
    }
}
