package com.walium.ing.gamerank.handlers;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public enum Handler {

    SHOW_RANK("show_rank"),
    SHOW_RANKING("show_ranking"),
    SHOW_GAMES("show_games"),
    SHOW_NEXT("show_next");

    /** Hold name of Enum with command line argument */
    private final String name;

    /**
     * Constructor
     *
     * @param name
     *         command line value
     */
    private Handler(final String name) {
        this.name = name;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return name;
    }
}
