package me.nightcreat.kindomcum.listenerandevent;

import me.nightcreat.kindomcum.Kindomcum;
import me.nightcreat.kindomcum.umwandlerfarbe;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;


public class message_listener_faction implements Listener {

    public message_listener_faction(Kindomcum plugin) {
        Bukkit.getPluginManager().registerEvents(this , plugin);

    }

    @EventHandler
    public void playermessage(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String faction = Kindomcum.getInstance().db.getName(player.getUniqueId().toString());
        String farbe = Kindomcum.getInstance().db.getcolour(faction);
        Bukkit.getLogger().info(farbe);
        String farbeumw = umwandlerfarbe.umwandler(farbe);
        Bukkit.getLogger().info(farbeumw);

        String message = event.getMessage();

        event.setMessage(farbeumw + message);



    }

}
