package me.nightcreat.kindomcum.Befehle;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class giveS implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player ){
            Player player = (Player) sender; // erstel player objekt

            ItemStack iron = new ItemStack(Material.IRON_SWORD); // erstellt ein eisenschwert

            ItemStack diamond = new ItemStack(Material.DIAMOND, 1); // erstell ein diamand objekt



            player.getInventory().addItem(iron, diamond); // gibt den spielern die items

        }

        return true;
    }
}
