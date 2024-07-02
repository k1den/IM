import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dota {
    public static void main(String[] args) {
        if (args.length != 2) {
            return;
        }

        String filePath = args[0].replace("\\", "\\\\");
        int n = Integer.parseInt(args[1]);

        try {
            Map<Integer, Integer> heroGames = new HashMap<>();
            Map<Integer, Integer> heroTopPlayer = new HashMap<>();

            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            boolean first = true;
            while ((line = reader.readLine()) != null) {
                if (first) {
                    first = false;
                    continue;
                }
                String[] parts = line.split(",");
                int heroId = Integer.parseInt(parts[1]);
                int numGames = Integer.parseInt(parts[2]);

                heroGames.put(heroId, heroGames.getOrDefault(heroId, 0) + numGames);

                if (!heroTopPlayer.containsKey(heroId) || numGames > heroGames.get(heroId)) {
                    heroTopPlayer.put(heroId, Integer.parseInt(parts[0]));
                }
            }
            reader.close();

            List<Map.Entry<Integer, Integer>> sortedHeroes = new ArrayList<>(heroGames.entrySet());
            sortedHeroes.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            System.out.println("| hero_id | num_all_games | user_id |");
            System.out.println("|---------|---------------|---------|");
            for (int i = 0; i < Math.min(n, sortedHeroes.size()); i++) {
                int heroId = sortedHeroes.get(i).getKey();
                int numAllGames = sortedHeroes.get(i).getValue();
                int topPlayerId = heroTopPlayer.get(heroId);
                System.out.printf("| %-7d | %-13d | %-7d |\n", heroId, numAllGames, topPlayerId);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
