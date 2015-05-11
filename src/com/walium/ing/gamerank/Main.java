package com.walium.ing.gamerank;

import java.util.List;
import java.util.Map;

import com.walium.ing.gamerank.elo.EloCalculator;
import com.walium.ing.gamerank.elo.EloScore;
import com.walium.ing.gamerank.elo.Match;
import com.walium.ing.gamerank.elo.Player;
import com.walium.ing.gamerank.handlers.HandlersFactory;
import com.walium.ing.gamerank.handlers.IFactory;
import com.walium.ing.gamerank.handlers.IResultHandler;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public class Main {

    public static void main(String[] args) {
        if (args.length < 3) {
            System.err.println("Not enough command line arguments!");
            System.exit(1);
        }
        List<Match> matches = FileUtils.getMatches(args[0]);
        Map<Integer, Player> players = FileUtils.getPlayers(args[1]);
        calculateElo(players, matches);
        IFactory factory = new HandlersFactory();
        IResultHandler handler = factory.getHandler(args, players);
        System.out.println(handler.getResult());
    }

    /**
     * Main method to calculate ELO rating for each player
     *
     * @param players
     *         HashMap with {@link Player} objects
     * @param matches
     *         List of matches
     */
    private static void calculateElo(Map<Integer, Player> players, List<Match> matches) {
        for (Match m : matches) {
            Player winner = players.get(m.getWinner());
            Player loser = players.get(m.getLoser());
            winner.changeRating(EloCalculator.calculateRatingChange(winner, loser, EloScore.WIN));
        }
    }
}
