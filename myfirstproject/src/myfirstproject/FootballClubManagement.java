package myfirstproject;
import java.util.*;

public class FootballClubManagement 
    {
    public static void main(String[] args) 
     {
        Scanner scanner = new Scanner(System.in);

      HashMap<String, String> players = new HashMap<>();
      HashMap<String, Integer> goalsMap = new HashMap<>();

       while (true)
       {
            System.out.println("1. Add Player");
            System.out.println("2. Search Players by Position");
            System.out.println("3. Update Player Goals");
            System.out.println("4. Display All Players");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) 
            {
                System.out.print("Enter Player ID: ");
                String id = scanner.nextLine();

                if (players.containsKey(id))
                {
                    System.out.println("Player ID already exists!");
                    continue;
                }
                else {
                System.out.print("Enter Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter Position: ");
                String position = scanner.nextLine();
                System.out.print("Enter Goals Scored: ");
                int goals = scanner.nextInt();
                scanner.nextLine();

                String details = "Player ID: " + id + ", Name: " + name + ", Position: " + position + ", Goals Scored: " + goals;
                players.put(id, details);
                goalsMap.put(id, goals);
                System.out.println("Player added successfully.");
                }

            } 
            else if (choice == 2) 
              {
                System.out.print("Enter Position to Search: ");
                String searchPosition = scanner.nextLine();
                boolean found = false;

                System.out.println("Players in position " + searchPosition + ":");
                for (String id : players.keySet())
                {
                    String playerInfo = players.get(id);
                    if (playerInfo.toLowerCase().contains(searchPosition.toLowerCase())) 
                    {
                        System.out.println("[" + playerInfo + "]");
                        found = true;
                    }
                }

                if (!found) 
               {
                    System.out.println("No players found in this position.");
                }

            } 
             else if (choice == 3)
             {
                System.out.print("Enter Player ID to Update Goals: ");
                String id = scanner.nextLine();

                if (players.containsKey(id)) 
                {
                    System.out.print("Enter New Goals Scored: ");
                    int newGoals = scanner.nextInt();
                    scanner.nextLine();

                    String oldDetails = players.get(id);
                    String[] parts = oldDetails.split(", ");
                    String updatedDetails = parts[0] + ", " + parts[1] + ", " + parts[2] + ", Goals Scored: " + newGoals;

                    players.put(id, updatedDetails);
                    goalsMap.put(id, newGoals);
                    System.out.println("Goals updated successfully.");
                }
               else
                {
                    System.out.println("Player ID not found.");
                }

            } 
             else if (choice == 4)
            {
                System.out.println("All Players (Sorted by Goals Scored):");
                List<Map.Entry<String, Integer>> sortedList = new ArrayList<>(goalsMap.entrySet());
                sortedList.sort((a, b) -> b.getValue() - a.getValue());

                int rank = 1;
                for (Map.Entry<String, Integer> entry : sortedList) {
                    String playerId = entry.getKey();
                    System.out.println(rank + ". [" + players.get(playerId) + "]");
                    rank++;
                }

                if (players.isEmpty())
                 {
                    System.out.println("No players to display.");
                }

            }
            else if (choice == 5) 
            {
                System.out.println("Exiting program.");
                break;

            } 
            else
            {
                System.out.println("Invalid choice. Try again.");
            }
          }

         }
     }