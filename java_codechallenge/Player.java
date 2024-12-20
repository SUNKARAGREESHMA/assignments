package Codechallenge;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
 
public class Player extends AbstractPlayer implements PlayerOperations{
	
	String url="jdbc:mysql://localhost:3306/playerdatabase";
	String username="root";
	
	String password="Gree@123";
 
	    // Constructor
	    public Player(int id, String name, String skill, int exp, String country, double overallScore) {
	        super(id, name, skill, exp, country, overallScore);
	    }
 
	    // JDBC connection
	    private Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, username, password);
	    }
 
	    // CRUD Operations Implementation
	    @Override
	    public void createPlayer(Player player) {
	        String query = "INSERT INTO players (name, skill, exp, country, overall_score) VALUES (?, ?, ?, ?, ?)";
	        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setString(1, player.getName());
	            ps.setString(2, player.getSkill());
	            ps.setInt(3, player.getExp());
	            ps.setString(4, player.getCountry());
	            ps.setDouble(5, player.getOverallScore());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
 
	    @Override
	    public Player getPlayerById(int id) {
	        String query = "SELECT * FROM players WHERE id = ?";
	        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                return new Player(rs.getInt("id"), rs.getString("name"), rs.getString("skill"), rs.getInt("exp"),
	                        rs.getString("country"), rs.getDouble("overall_score"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
 
	    @Override
	    public List<Player> getAllPlayers() {
	        String query = "SELECT * FROM players";
	        List<Player> players = new ArrayList<>();
	        try (Connection connection = getConnection(); Statement stmt = connection.createStatement()) {
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                players.add(new Player(rs.getInt("id"), rs.getString("name"), rs.getString("skill"), rs.getInt("exp"),
	                        rs.getString("country"), rs.getDouble("overall_score")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return players;
	    }
 
	    @Override
	    public List<Player> getPlayersByCountry(String country) {
	        String query = "SELECT * FROM players WHERE country = ?";
	        List<Player> players = new ArrayList<>();
	        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setString(1, country);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                players.add(new Player(rs.getInt("id"), rs.getString("name"), rs.getString("skill"), rs.getInt("exp"),
	                        rs.getString("country"), rs.getDouble("overall_score")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return players;
	    }
 
	    @Override
	    public List<Player> getPlayersByExperience() {
	        String query = "SELECT * FROM players ORDER BY exp DESC";
	        List<Player> players = new ArrayList<>();
	        try (Connection connection = getConnection(); Statement stmt = connection.createStatement()) {
	            ResultSet rs = stmt.executeQuery(query);
	            while (rs.next()) {
	                players.add(new Player(rs.getInt("id"), rs.getString("name"), rs.getString("skill"), rs.getInt("exp"),
	                        rs.getString("country"), rs.getDouble("overall_score")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return players;
	    }
 
	    @Override
	    public void updatePlayer(Player player) {
	        String query = "UPDATE players SET name = ?, skill = ?, exp = ?, country = ?, overall_score = ? WHERE id = ?";
	        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setString(1, player.getName());
	            ps.setString(2, player.getSkill());
	            ps.setInt(3, player.getExp());
	            ps.setString(4, player.getCountry());
	            ps.setDouble(5, player.getOverallScore());
	            ps.setInt(6, player.getId());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
 
	    @Override
	    public void deletePlayer(int id) {
	        String query = "DELETE FROM players WHERE id = ?";
	        try (Connection connection = getConnection(); PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
 
 