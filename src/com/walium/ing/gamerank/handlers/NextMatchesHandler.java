package com.walium.ing.gamerank.handlers;

import java.util.Map;

import com.walium.ing.gamerank.elo.Player;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public class NextMatchesHandler implements IResultHandler {

    /** Hold {@link Player} objects with calculated rank */
    private Map<Integer, Player> players;

    /**
     * Default constructor
     *
     * @param players
     *         HashMap with {@link Player} objects
     */
    public NextMatchesHandler(Map<Integer, Player> players) {
        this.players = players;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getResult() {
        StringBuilder result = new StringBuilder();

        for (Player p1 : players.values()) {
            for (Player p2 : players.values()) {
                if (!p1.equals(p2) && !p1.getOpponents().containsKey(p2)
                        && !p1.isHasNextGame() && !p2.isHasNextGame()) {
                    result.append(p1.getName()).append(" vs. ").append(p2.getName()).append("\n");
                    p1.setHasNextGame(true);
                    p2.setHasNextGame(true);
                    break;
                }
            }
        }

        return result.toString();
    }
}
