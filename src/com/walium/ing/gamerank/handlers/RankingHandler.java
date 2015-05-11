package com.walium.ing.gamerank.handlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.walium.ing.gamerank.elo.Player;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public class RankingHandler implements IResultHandler {

    /** Hold {@link Player} objects with calculated rank */
    private Map<Integer, Player> players;

    /**
     * Default constructor
     *
     * @param players
     *         Hashmap with {@link Player} objects
     */
    public RankingHandler(Map<Integer, Player> players) {
        this.players = players;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResult() {
        StringBuilder result = new StringBuilder();
        result.append("Place").append("\t").append("Name").append("\t").append("Rating").append("\t");
        result.append("Wins").append("\t").append("Losses").append("\n");

        List<Player> playerList = new ArrayList<>(players.values());
        Collections.sort(playerList);
        for (int i = 0; i < playerList.size(); i++) {
             result.append(i + 1).append("\t").append(playerList.get(i)).append("\n");
        }
        return result.toString();
    }
}
