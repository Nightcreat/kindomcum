package me.nightcreat.kindomcum.Befehle;

import me.nightcreat.kindomcum.Kindomcum;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class createfaction implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            List<String> glplayers = new ArrayList<String>();
            try {
                glplayers = Kindomcum.getInstance().db.getallplayers();
            }catch (Exception e){
                player.sendMessage(ChatColor.RED + "schade schokolade" + e.getMessage());
            }
            String name = "nutte";
            String colour = "";

            if (glplayers.contains(player.getUniqueId().toString())){
                player.sendMessage(ChatColor.RED + "Du bist schon in einer faction kollege");
                }
            else
                if (args.length <= 1){
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Usage: what are sigam ,mach das /createfaction <name> <farbe>");
                return true;
                }
                else if (args.length == 2){
                 name = args[0];
                 colour = args[1];
                 Kindomcum.getInstance().db.createzeile(name, player.getUniqueId().toString() , colour);
                 player.sendMessage(ChatColor.LIGHT_PURPLE + "A faction succesfully created ");
                }
                else if (args.length > 2){
                player.sendMessage(ChatColor.RED + "dummer autist");
                }






        }
    return true;
    }


}
