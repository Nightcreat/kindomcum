package me.nightcreat.kindomcum.Befehle;

import me.nightcreat.kindomcum.Kindomcum;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;


public class leavefaction implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;

            if (args.length == 0) {
                player.sendMessage(ChatColor.LIGHT_PURPLE + "Usage: what are sigam ,mach das /leavefaction <factionname> ");
                return true;
            }
            else if (args.length == 1) {
                try {
                    List<String> players;
                    players = Kindomcum.getInstance().db.getplayers(args[0]);
                    if (players.size() > 1) {
                    //players.forEach(playesss -> {Bukkit.getLogger().info(playesss);});
                    players.remove(player.getUniqueId().toString());
                    Kindomcum.getInstance().db.addplayer(players, args[0]);}
                    else {
                        player.sendMessage(ChatColor.RED + "Du kannst di fraktion nicht auflösen da du nur ein spieler bsit");
                    }

                }catch (Exception e){
                    player.sendMessage(ChatColor.RED + "deine Fraktion muss existieren !!!! ");
                }
            }
            else
                player.sendMessage(ChatColor.RED +"das ist zu lang kollege ");


        }
        return false;
    }
}
