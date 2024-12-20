package Codechallenge;

import java.util.List;

public interface PlayerOperations {
	 void createPlayer(Player player);
	    Player getPlayerById(int id);
	    List<Player> getAllPlayers();
	    List<Player> getPlayersByCountry(String country);
	    List<Player> getPlayersByExperience();
	    void updatePlayer(Player player);
	    void deletePlayer(int id);
}