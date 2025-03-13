package me.nightcreat.kindomcum.Befehle;

import me.nightcreat.kindomcum.Kindomcum;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;

public class factionpalyers implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            String name ;
            if (args.length == 0){ // auf länge über prüft
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Usage: what are sigam ,mach das /factionpalyers <factionname> ");
                return true;
            }
            else if (args.length == 1){
                try {


                    name = args[0];
                    List<String> spieler_von_faction = Kindomcum.getInstance().db.getplayers(name);
                    for (int i = 0; spieler_von_faction.toArray().length > i; i++) {
                        player.sendMessage(ChatColor.LIGHT_PURPLE + Bukkit.getPlayer(UUID.fromString(spieler_von_faction.get(i))).getName());

                    }
                    return true;
                }catch (Exception e){
                    player.sendMessage(ChatColor.RED + "die fraktion existiert nicht");
                }
            }
            else if (args.length > 1){
                player.sendMessage(ChatColor.LIGHT_PURPLE + "fragwürdigertipper");
            }
        }



        return false;



    }
}
