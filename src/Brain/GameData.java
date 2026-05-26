package Brain;

import Properties.Card;

import com.google.gson.Gson;


import javax.swing.*;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is responsible for loading game data, such as cards, from JSON files.
 */
public class GameData {


    public ArrayList<Card> card;
    public ArrayList<Card> getCards() {
        return card;
    }
    public void setPredmety(ArrayList<Card> card) {
        this.card = card;
    }
    public ArrayList<Card> getCard() {
        return card;
    }
    /**
     * Loads game data from a JSON file located in the application's resources.
     *
     * @param resourcePath The path to the JSON resource file (e.g., "/gamedata.json").
     * @return A GameData object populated with data from the JSON.
     * @throws RuntimeException if the resource is not found or an error occurs during JSON parsing.
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
        Gson gson = new Gson();

        InputStream input = GameData.class.getResourceAsStream(resourcePath);
        if (input == null){
            throw new RuntimeException("Resource not found: " + resourcePath);
        }
        try (input) {
            return gson.fromJson(new InputStreamReader(input, StandardCharsets.UTF_8), GameData.class);

        } catch (Exception e) {
            throw new RuntimeException("Error loading JSON: " + e.getMessage());
        }

    }

    /**
     * Loads game data from a specified file path.
     *
     * @param filePath The absolute path to the JSON file.
     * @param fc The JFileChooser instance to display error messages.
     * @return A GameData object populated with data from the JSON, or null if an error occurs.
     */
    public static GameData loadGameDataFromFile(String filePath,JFileChooser fc) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, GameData.class);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(fc,"Error loading file: " + e.getMessage());
        }
        return null;
    }
}