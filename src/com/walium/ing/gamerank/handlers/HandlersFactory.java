package com.walium.ing.gamerank.handlers;

import java.util.Map;

import com.walium.ing.gamerank.elo.Player;

import static com.walium.ing.gamerank.handlers.Handler.*;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public class HandlersFactory implements IFactory {

    /**
     * {@inheritDoc}
     */
    @Override
    public IResultHandler getHandler(String[] args, Map<Integer, Player> players) {
        IResultHandler handler = null;
        if (args[2].equals(SHOW_RANK.toString())) {
            if (args[3] != null && !args[3].equals("")) {
                handler = new PlayerRankHandler(players, args[3]);
            } else {
                System.err.println("Username not valid: " + args[2]);
                System.exit(1);
            }
        } else if (args[2].equals(SHOW_RANKING.toString())) {
            handler = new RankingHandler(players);
        } else if (args[2].equals(SHOW_GAMES.toString())) {
            if (args[3] != null && !args[3].equals("")) {
                handler = new GamesHandler(players, args[3]);
            } else {
                System.err.println("Username not valid: " + args[2]);
                System.exit(1);
            }
        } else if (args[2].equals(SHOW_NEXT.toString())) {
            handler = new NextMatchesHandler(players);
        } else {
            System.err.println("Operation not allowed: " + args[2]);
            System.exit(1);
        }

        return handler;
    }
}
