package com.walium.ing.gamerank.handlers;

import java.util.Map;

import com.walium.ing.gamerank.elo.Player;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public interface IFactory {

    /**
     * Return {@link IResultHandler} object depending to input data
     *
     * @param args
     *         command line arguments
     * @param players
     *         players Hashmap
     * @return {@link IResultHandler} instance
     */
    IResultHandler getHandler(String[] args, Map<Integer, Player> players);
}
