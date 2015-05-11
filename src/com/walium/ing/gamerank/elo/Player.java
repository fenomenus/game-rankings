package com.walium.ing.gamerank.elo;

import java.util.HashMap;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public class Player implements Comparable<Player> {

    /** Constant hold starting Elo rating of the player */
    private static final int START_RATING = 1200;

    /** Member for {@link #getId()} */
    private final int id;

    /** Member for {@link #getName()} } */
    private final String name;

    /** Member for {@link #getRating()} */
    private int rating;

    /** Member for {@link #getLosses()} */
    private int losses = 0;

    /** Member for {@link #getWins()} */
    private int wins = 0;

    /** Member for {@link #getDraws()} */
    private int draws = 0;

    /** Member for {@link #getGames()} */
    private int games = 0;

    /** Member for {@link #getOpponents()} */
    private final HashMap<Player, EloScore> gamesList;

    /** Member for {@link #isHasNextGame()} */
    private boolean hasNextGame = false;

    /**
     * Default constructor
     *
     * @param id
     *         player identifier
     * @param name
     *         player name
     */
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.rating = START_RATING;
        this.gamesList = new HashMap<>();
    }

    /**
     * Getter for player identifier
     *
     * @return player id
     */
    public int getId() {
        return id;
    }

    /**
     * Getter for player name
     *
     * @return player name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for player rating
     *
     * @return player rating
     */
    public int getRating() {
        return rating;
    }

    /**
     * Getter for number of player loses
     *
     * @return number of player loses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Getter for number of player wins
     *
     * @return number of player wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Getter for number of player draws
     *
     * @return number of player draws
     */
    public int getDraws() {
        return draws;
    }

    /**
     * Getter for number of player games
     *
     * @return number of player games
     */
    public int getGames() {
        return games;
    }

    /**
     * Getter list of opponents
     *
     * @return list of players with whom played current player
     */
    public HashMap<Player, EloScore> getOpponents() {
        return gamesList;
    }

    /**
     * Changes this player's rating by adding the value given as argument
     *
     * @param change
     *         The rating change
     */
    public void changeRating(int change) {
        rating += change;
    }

    /**
     * Getter for hasNewgame
     *
     * @return true if player already has next game
     */
    public boolean isHasNextGame() {
        return hasNextGame;
    }

    public void setHasNextGame(boolean hasNextGame) {
        this.hasNextGame = hasNextGame;
    }

    /**
     * Increment number of the games and losses
     */
    private void incrementLosses() {
        losses++;
    }

    /**
     * Increment number of the games and wins
     */
    private void incrementWins() {
        wins++;
    }


    public void addGame(Player opponent, EloScore result) {
        switch (result) {
            case WIN:
                wins++;
                break;
            case LOSE:
                losses++;
                break;
            case DRAW:
                draws++;
                break;
        }
        games++;
        gamesList.put(opponent, result);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return new StringBuilder().append(name).append("\t").append(rating).append("\t").append(wins).append("\t")
                .append(losses).toString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Player player) {
        return player.getRating() - this.rating;
    }


}
