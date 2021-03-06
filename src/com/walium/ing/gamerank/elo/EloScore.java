package com.walium.ing.gamerank.elo;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public enum EloScore {

    /** Enum for the win */
    WIN("win", 1.0),

    /** Enum or the draw */
    DRAW("draw", 0.5),

    /** Enum for the lose */
    LOSE("lose", 0);

    /** Hold score description */
    private final String name;

    /** Hold score value */
    private final double value;

    /**
     * Constructor
     *
     * @param name
     *         score description
     * @param value
     *         score value
     */
    private EloScore(final String name, final double value) {
        this.name = name;
        this.value = value;
    }

    /**
     * Getter for description
     *
     * @return description
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for score value
     *
     * @return score value
     */
    public double getValue() {
        return value;
    }
}
