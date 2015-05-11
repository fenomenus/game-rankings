# game-rankings
Game Rankings with ELO Ranking algorithm

Usage:
```
java -jar gamerank.jar <matches file> <names file> <output data> [<player name>]
```

Where:
* ```<matches file>``` path to file that contain games information;
* ```<names file>``` path to file that contain information about players;
* ```<output data>``` output data format:
  * ```show_rank <player name>``` - shows infomation about player;
  * ```show_ranking``` - shows information about all player (place, rank, wins, losses);
  * ```show_games <player name>``` - shows information about player games (played vs., win or lose);
  * ```show_next``` - shows next games;
