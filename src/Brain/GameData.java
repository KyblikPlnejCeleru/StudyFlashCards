package Brain;

import Properties.Card;

import com.google.gson.Gson;


import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 *
 * Thahle trida slouzi pro nacitani hernich dat z jsonu, napriklad postavy,predmety a celkova mapa.
 * @author romek studios + meitnerova + chaloupka + kolinek + pospisil
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


    public static GameData loadGameDataFromFile(String filePath) {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader(filePath)) {
            return gson.fromJson(reader, GameData.class);
        } catch (Exception e) {
            throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }
    }

}