package me.nightcreat.kindomcum;

import java.util.Arrays;
import java.util.List;

public class umwandlerfarbe {
    private static final List<String> Farben = Arrays.asList("Schwarz" ,"Grün","dunkelGrün", "Rot","dunkelRot","Dunkelgrau","Gelb","Dunkelblau","Blau","Grau","slay","lila");
    private static final List<String> farbcode = Arrays.asList("§0","§a","§2","§c","§4","§8","§e","§1","§9","§7","§d","§5");

    public static String umwandler (String s){
        for (int i = 0; i < 11; i++ )
            if (s.equals(Farben.get(i))){
            return farbcode.get(i);
            }
        return s;
    }
}
