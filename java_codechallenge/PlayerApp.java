package Codechallenge;



import java.util.List;
import java.util.Scanner;
 
public class PlayerApp {
 
    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);
 
        // Create a new player object to perform operations
        Player playerOperations = new Player(0, "", "", 0, "", 0.0);
 
        // Main menu loop
        boolean exit = false;
        while (!exit) {
            // Display menu options
            System.out.println("\nChoose an option:");
            System.out.println("1. Create a new player");
            System.out.println("2. List all players");
            System.out.println("3. List players by country");
            System.out.println("4. Update player details");
            System.out.println("5. Delete a player");
            System.out.println("6. Exit");
 
            // Get user input
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
 
            switch (choice) {
                case 1: // Create a new player
                    System.out.print("Enter player name: ");
                    String name = scanner.nextLine();
 
                    System.out.print("Enter player skill (e.g., Bowler, Batsman): ");
                    String skill = scanner.nextLine();
 
                    System.out.print("Enter player experience in years: ");
                    int experience = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline left by nextInt()
 
                    System.out.print("Enter player country: ");
                    String country = scanner.nextLine();
 
                    System.out.print("Enter player overall score: ");
                    double overallScore = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
 
                    // Create and add the new player
                    Player newPlayer = new Player(0, name, skill, experience, country, overallScore);
                    playerOperations.createPlayer(newPlayer);
                    System.out.println("Player created successfully.");
                    break;
 
                case 2: // List all players
                    List<Player> players = playerOperations.getAllPlayers();
                    System.out.println("\nList of players:");
                    players.forEach(p -> System.out.println(p.getId() + " - " + p.getName())); // Display ID with name
                    break;
 
                case 3: // List players by country
                    System.out.print("\nEnter country to filter players by: ");
                    String countryFilter = scanner.nextLine();
                    List<Player> filteredPlayers = playerOperations.getPlayersByCountry(countryFilter);
                    System.out.println("\nPlayers from " + countryFilter + ":");
                    filteredPlayers.forEach(p -> System.out.println(p.getName()));
                    break;
 
                case 4: // Update player details
                    System.out.print("\nEnter the ID of the player to update: ");
                    int playerIdToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
 
                    // Find the player by ID
                    Player playerToUpdate = null;
                    List<Player> allPlayers = playerOperations.getAllPlayers(); // Fetch all players to search by ID
                    for (Player player : allPlayers) {
                        if (player.getId() == playerIdToUpdate) {
                            playerToUpdate = player;
                            break;
                        }
                    }
 
                    if (playerToUpdate != null) {
                        // Prompt the user for updated details
                        System.out.println("Enter updated player skill: ");
                        String updatedSkill = scanner.nextLine();
 
                        System.out.println("Enter updated player experience: ");
                        int updatedExperience = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
 
                        System.out.println("Enter updated player overall score: ");
                        double updatedScore = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
 
                        // Create an updated player object
                        Player updatedPlayer = new Player(playerToUpdate.getId(), playerToUpdate.getName(), updatedSkill, updatedExperience, playerToUpdate.getCountry(), updatedScore);
                        playerOperations.updatePlayer(updatedPlayer);
                        System.out.println("Player updated successfully.");
                    } else {
                        System.out.println("Player not found with the given ID.");
                    }
                    break;
 
                case 5: // Delete a player
                    System.out.print("\nEnter player ID to delete: ");
                    int playerIdToDelete = scanner.nextInt();
                    playerOperations.deletePlayer(playerIdToDelete);
                    System.out.println("Player deleted successfully.");
                    break;
 
                case 6: // Exit
                    exit = true;
                    System.out.println("Exiting the application.");
                    break;
 
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }
        }
 
        // Close the scanner
        scanner.close();
    }
}
 
 