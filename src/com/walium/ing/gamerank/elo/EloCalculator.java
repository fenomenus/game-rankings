package com.walium.ing.gamerank.elo;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public class EloCalculator {

    /**
     * Resolve K-Factor by player experience
     *
     * @param player
     *         the {@link Player} object
     * @return K-Factor
     */
    private static int resolveKFactor(Player player) {
        if (player.getGames() > 30) {
            if (player.getRating() < 2400) {
                return 20;
            } else {
                return 10;
            }
        } else {
            return 40;
        }
    }

    /**
     * Calculate a player's expected score - probability of winning plus half his probability of drawing.
     *
     * @param winnerRating
     *         current rating of the winner
     * @param loserRating
     *         current rating of the loser
     * @return expected score
     */
    private static double calculateExpectedScore(int winnerRating, int loserRating) {
        return 1 / (1.0 + Math.pow(10.0, (loserRating - winnerRating) / 400.0));
    }

    /**
     * Calculate the rating change for winner when facing with loser
     *
     * @param winnerRating
     *         current rating of the winner
     * @param loserRating
     *         current rating of the loser
     * @param kfactor
     *         K-Factor of the winner
     * @return value of the rating change
     */
    private static int calculateRatingChange(int winnerRating, int loserRating, double kfactor, double eloScore) {
        return (int) Math.round(kfactor * (eloScore - calculateExpectedScore(winnerRating, loserRating)));
    }

    /**
     * Calculate the rating change for winner when facing with loser
     *
     * @param winner
     *         {@link Player} object of winner
     * @param loser
     *         {@link Player} of the loser
     * @return value of the rating change
     */
    public static int calculateRatingChange(Player winner, Player loser, EloScore score) {
        winner.addGame(loser, EloScore.WIN);
        loser.addGame(winner, EloScore.LOSE);
        final int kfactor = resolveKFactor(winner);
        return calculateRatingChange(winner.getRating(), loser.getRating(), kfactor, score.getValue());
    }

}
