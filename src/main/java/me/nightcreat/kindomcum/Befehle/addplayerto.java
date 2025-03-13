package me.nightcreat.kindomcum.Befehle;

import me.nightcreat.kindomcum.Kindomcum;
import net.md_5.bungee.chat.SelectorComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;



public class addplayerto implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if(args.length > 1){
                try {
                    Player target = Bukkit.getPlayer(args[1]); // liste mit anderen spieler wird erstellt
                    List <String> otherplayer = new ArrayList<>();
                    otherplayer.add(target.getUniqueId().toString()) ;
                    Kindomcum.getInstance().db.addplayer(otherplayer,args[0]);

                }catch (Exception e){
                    player.sendMessage(ChatColor.DARK_RED + "Bitte einens exitierenden   spieler du dummer knecht ruprecht");
                }


            }
            else{
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Usage: what are sigam ,mach das /addplayerto <Faction> <name>");
                    return true;
                }





                /*
                List<String> glplayers = Kindomcum.getInstance().db.getallplayers();
                if (glplayers.contains(pl_L.getFirst())){
                player.sendMessage(ChatColor.RED + "der spieler ist schon in einer faction");
                }else
                    if(args.length == 0){
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Usage: what are sigam ,mach das /addplayerto <Faction> <name>");
                    return true;
                    }
                    if(args.length == 1){
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "Usage: what are sigam ,mach das /addplayerto <Faction> <name>");
                    return true;
                    }
                    if(args.length == 2){
                    String faction = args[0];
                    pl_L.add(args[1]);
                    Kindomcum.getInstance().db.addplayer(pl_L , faction);
                            }

            */

        }
        return true;

    }
}
