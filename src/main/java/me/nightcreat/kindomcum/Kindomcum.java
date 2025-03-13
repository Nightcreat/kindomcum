package me.nightcreat.kindomcum;

import me.nightcreat.kindomcum.Befehle.*;
import me.nightcreat.kindomcum.database.database_faction;
import me.nightcreat.kindomcum.listenerandevent.message_listener_faction;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.SQLException;

public final class Kindomcum extends JavaPlugin {

    public static Kindomcum getInstance(){ return getPlugin(Kindomcum.class); }

    public database_faction db;
    public database_faction getDb() { return this.db; }


    @Override
    public void onEnable() {

        this.getCommand("giveS").setExecutor(new giveS()); // registriert denn command
        this.getCommand("createfaction").setExecutor(new createfaction());
        this.getCommand("factionpalyers").setExecutor(new factionpalyers());
        this.getCommand("addplayerto").setExecutor(new addplayerto());
        this.getCommand("leavefaction").setExecutor(new leavefaction());
        this.getCommand("deletefaction").setExecutor(new deletefaction());
        this.getCommand("factioncolour").setExecutor(new factioncolour());

        new message_listener_faction(this);

        try {
            if(!getDataFolder().exists()){
                getDataFolder().mkdir();
            }
            db = new database_faction(getDataFolder().getAbsolutePath() + "/datenbankfaction.db");// sigmas darenbank folder erstellt
        }catch (SQLException e){
            e.printStackTrace();
            Bukkit.getPluginManager().disablePlugin(this);
        }
        // Plugin startup logic
    }


    @Override
    public void onDisable() {
        try {
            db.closd_connection();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Plugin shutdown logic
    }
}
