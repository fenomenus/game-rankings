package com.walium.ing.gamerank.elo;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public class Match {

    /** Hold the winner id */
    private int winner;

    /** Hold the loser id */
    private int loser;

    /**
     * Default constructor
     *
     * @param winner
     *         winner player id
     * @param loser
     *         loser player id
     */
    public Match(int winner, int loser) {
        this.winner = winner;
        this.loser = loser;
    }

    /**
     * Getter for winner player id
     *
     * @return winner  player id
     */
    public int getWinner() {
        return winner;
    }

    /**
     * Getter for loser player id
     *
     * @return loser player id
     */
    public int getLoser() {
        return loser;
    }
}
