package com.walium.ing.gamerank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.walium.ing.gamerank.elo.Match;
import com.walium.ing.gamerank.elo.Player;

/**
 * @author <a href="mailto:edganiukov@gmail.com">Ed Ganiukov</a>
 * @since 2015.05.09
 */
public class FileUtils {

    /**
     * Read file and return list of lines in file
     *
     * @param path
     *         path to the file
     * @return List of lines that contain file
     */
    private static List<String> readFile(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            for (String line; (line = br.readLine()) != null; ) {
                lines.add(line);
            }
        } catch (IOException ex) {
            System.err.println(new StringBuilder().append("Exception with file ").append(path).append(": ").append(
                    ex.getMessage()));
        }
        return lines;
    }

    /**
     * Method that parse matches file
     *
     * @param path
     *         path to the file
     * @return List of {@link Match} objects
     */
    public static List<Match> getMatches(String path) {
        List<Match> matchList = new ArrayList<>();
        List<String> lines = readFile(path);

        try {
            for (String line : lines) {
                String[] splitLines = line.split("\\s");
                matchList.add(new Match(Integer.valueOf(splitLines[0]), Integer.valueOf(splitLines[1])));
            }
        } catch (RuntimeException ex) {
            System.err.println(new StringBuilder().append("Some problem with parsing file ").append(path).append(": ")
                    .append(ex.getMessage()));
        }
        return matchList;
    }

    /**
     * Method that parse players file
     *
     * @param path
     *         path to the file
     * @return List of {@link Player} objects
     */
    public static Map<Integer, Player> getPlayers(String path) {
        Map<Integer, Player> playerMap = new HashMap<>();
        List<String> lines = readFile(path);
        try {
            for (String line : lines) {
                String[] splitLines = line.split("\\s");
                playerMap.put(Integer.valueOf(splitLines[0]), new Player(Integer.valueOf(splitLines[0]),
                        splitLines[1]));
            }
        } catch (RuntimeException ex) {
            System.err.println(new StringBuilder().append("Some problem with parsing file ").append(path).append(": ")
                    .append(ex.getMessage()));
        }
        return playerMap;
    }
}
