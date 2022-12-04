package de.fynnhenck.homesystemcommon.events;

import de.fynnhenck.homesystemapi.api.Home;
import de.fynnhenck.homesystemapi.api.HomeSystemDatabase;
import de.fynnhenck.homesystemcommon.config.HomeMessages;
import de.fynnhenck.homesystemcommon.config.HomePermissions;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if(e.getView().getTitle().equals(HomeMessages.GUI_TITLE)){ //check if its the homes inventory
            e.setCancelled(true);
            if(e.getCurrentItem() != null){ //only check item type if item is clicked; else: NullPointers
                HomeSystemDatabase hsdb = new HomeSystemDatabase();
                if(e.getCurrentItem().getType() == Material.BARRIER){ //delete all homes
                    Player p = (Player) e.getWhoClicked();
                    if (p.hasPermission(HomePermissions.DELETE_PERMISSION)) {
                        hsdb.deleteAllHomes(p.getUniqueId());
                        p.sendMessage(ChatColor.GREEN + HomeMessages.DELETE_ALL);
                    }else{//no Permissions
                        p.sendMessage(ChatColor.RED + HomeMessages.NO_PERMISSION);
                    }
                    p.closeInventory();

                }else if(e.getCurrentItem().getType() == Material.PAPER){
                    ItemStack item = e.getCurrentItem();
                    Player p = (Player) e.getWhoClicked();
                    if(Objects.requireNonNull(item.getLore()).get(0).equals(HomeMessages.GUI_TELEPORT)){
                        if(p.hasPermission(HomePermissions.TELEPORT_PERMISSION)){
                            String homeName = ChatColor.stripColor(item.getItemMeta().getDisplayName());
                            Home home = hsdb.getHome(p.getUniqueId(), homeName);
                            p.teleport(new Location(home.getWorld(), home.getX(), home.getY(), home.getZ(), home.getYaw(), home.getPitch()));
                            p.sendMessage(ChatColor.GREEN + HomeMessages.TELEPORT.replace("$home$", home.getName()));
                        }else{//no Permissions
                        p.sendMessage(ChatColor.RED + HomeMessages.NO_PERMISSION);
                      }
                        p.closeInventory();
                    }
                }
            }
        }
    }

}
