package me.nightcreat.kindomcum.database;

import javax.xml.namespace.QName;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import com.google.gson.Gson;

public class database_faction {
    private final Connection connection;

    public database_faction(String path) throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:" + path);
        try (Statement statement = connection.createStatement()) {
            statement.execute("""
    CREATE TABLE IF NOT EXISTS factions (
    name TEXT PRIMARY KEY,
    players TEXT NOT NULL,
    colour TEXT
    admin TEXT NOT NULL,
    aeltester TEXT NOT NULL 
    )""");
        }
    }
   public void createzeile  (String name , String player , String colour) {
        List <String> players = new ArrayList<>();
        players.add(player);
        String query = "INSERT INTO factions (name, players, colour) VALUES (?, ?, ?)";
        Gson gson = new Gson();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, name);
            statement.setString(2, gson.toJson(players));
            statement.setString(3, colour);
            statement.executeUpdate();
        }catch (SQLException e ) {}

   }
   public void closd_connection() throws SQLException {
        if (!connection.isClosed() && connection != null) {
            connection.close();
        }

   }

   public List<String> getplayers // nimmt den name der fraktion und return alle spieler in dieser
           (String name){
        String query = "SELECT * FROM factions WHERE name = ?";
        List <String> players = new ArrayList<>();
        Gson gson = new Gson();
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, name);
            ResultSet resultSet= statement.executeQuery();
            String gsonplayers = resultSet.getString("players");
            players = Arrays.asList(gson.fromJson(gsonplayers, String[].class));


        }catch (SQLException e ) {System.out.println("kill yoursel please");}

        return players;
   }

   public List <String> getallplayers(){
        String query = "SELECT * FROM factions";
        List<String> players = new ArrayList<>();
        Gson gson = new Gson();
        try (PreparedStatement statement = connection.prepareStatement(query)){
            ResultSet resultSet= statement.executeQuery();
           String gsonplayers = resultSet.getString("players");
           players = Arrays.asList(gson.fromJson(gsonplayers, String[].class));

        }catch (SQLException e ) {System.out.println("kill yoursel please");}

        return players;

   }

   public void addplayer(List<String>players ,String name ){ //addplayyer setzt players in sql auf players
        String query = "UPDATE factions SET players = ? WHERE name = ?";
        Gson gson = new Gson();
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, gson.toJson(players));
            statement.setString(2, name);
            statement.executeUpdate();
        }catch (SQLException e ) {System.out.println("kill yoursel please");}

   }

   public void delete (String name ){
        String query = "DELETE FROM factions WHERE name = ?"; // die faction und alle inhalte mit dem zugehörigen namen werden gelöscht
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, name);
            statement.executeUpdate();
        }catch (SQLException e ) {System.out.println("kill yoursel please");}

   }

   public void setcolour (String name , String colour){
        String query = "UPDATE factions SET colour = ? WHERE name = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, colour);
            statement.setString(2, name);
            statement.executeUpdate();

        }catch (SQLException e ) {System.out.println("kill yoursel please");}
   }

   public String getcolour (String name ){
        String query = "SELECT * FROM factions WHERE name = ?";
        String farbe = "";
        try (PreparedStatement statement = connection.prepareStatement(query)){
            statement.setString(1, name);
            ResultSet resultSet= statement.executeQuery();
            farbe = resultSet.getString("colour");
        }catch (SQLException e ) {System.out.println("kill yoursel please");}
        return farbe   ;
   }

   public String getName (String player){
       List <String> players = new ArrayList<>();
       players.add(player);
       String faction = "";
       Gson gson = new Gson();
       String pl = gson.toJson(players);
       String query = "SELECT * FROM factions WHERE players = ?";
       try(PreparedStatement statement = connection.prepareStatement(query)){
           statement.setString(1, pl);
           ResultSet resultSet= statement.executeQuery();
           faction = resultSet.getString("name");
       }catch (SQLException e ){
           System.out.println("killt it");
       }
       return faction;
   }

}
