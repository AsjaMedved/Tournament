package ru.netology.servise;

import java.util.ArrayList;

public class Game {
    ArrayList <Player> registeredPlayers = new ArrayList<>();

    public void register(Player player) {
        registeredPlayers.add(player);
    }

    public Player findByName (String name){
        for (Player player : registeredPlayers){
            if (player.getName().equals(name)){
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player p1 = findByName(playerName1);
        Player p2 = findByName(playerName2);

        if (p1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не зарегистрирован");
        }
        if (p2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не зарегистрирован");
        }

        if (p1.getStrength() > p2.getStrength()) {
            return 1;
        } else if (p1.getStrength() < p2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }

}
