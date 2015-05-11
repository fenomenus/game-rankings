package com.walium.ing.gamerank.handlers;

import java.util.Map;

import com.walium.ing.gamerank.elo.Player;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public class PlayerRankHandler implements IResultHandler {

    /** Hold {@link Player} objects with calculated rank */
    private Map<Integer, Player> players;

    /** Hold the player name */
    private String name;

    /**
     * Default constructor
     *
     * @param players
     *         Hashmap with {@link Player} objects
     * @param name
     *         player name
     */
    public PlayerRankHandler(Map<Integer, Player> players, String name) {
        this.players = players;
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResult() {
        for (Player p : players.values()) {
            if (p.getName().toLowerCase().equals(name.toLowerCase())) {
                return new StringBuilder().append("Name: ").append(p.getName()).
                        append("; rating: ").append(p.getRating()).toString();
            }

        }
        return new StringBuilder().append("User ").append(name).append(" not found!").toString();
    }
}
