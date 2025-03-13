package me.nightcreat.kindomcum.Befehle;

import me.nightcreat.kindomcum.Kindomcum;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class deletefaction implements CommandExecutor{
   @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length < 2){
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Usage: what are sigam ,mach das /deletefaction <factionname> <yes>");
                return true;
            }
            else if (args.length == 2 && args[1].equalsIgnoreCase("yes")){
            Kindomcum.getInstance().db.delete(args[0]);
            player.sendMessage(ChatColor.RED + "deine fraktion worde gelöscht.");
            }
        }
        return false;
    }
}
