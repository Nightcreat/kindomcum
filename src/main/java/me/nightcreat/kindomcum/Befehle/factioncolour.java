package me.nightcreat.kindomcum.Befehle;

import me.nightcreat.kindomcum.Kindomcum;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class factioncolour implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0){
                player.sendMessage("du musst schon ne farbe schreiben kollege ");
            }
            if (args.length == 1){
                List<String> Farben = Arrays.asList("Schwarz" ,"Grün","dunkelGrün", "Rot","dunkelRot","Dunkelgrau","Gelb","Dunkelblau","Blau","Grau","slay","lila");
                if(Farben.contains(args[0])){
                    String faction = Kindomcum.getInstance().db.getName(player.getUniqueId().toString());
                    Kindomcum.getInstance().db.setcolour(faction,args[0]);
                }
                else
                    player.sendMessage("ganz schöner langer hase oder du kannst keien Farben schreiebn");
            }
        }
        return true;
    }
}
