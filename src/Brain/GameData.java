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
    /**
     * nacita herni data z jsonu
     *
     * @param resourcePath cesta k jsonu
     * @return herni data z jsonu
     */
    public static GameData loadGameDataFromResources(String resourcePath) {
        //Vytvoření objektu pro práci s JSON souborem
        Gson gson = new Gson();

        //Načtení souboru gamedata.json, musí být ve složce res/resources, ta musí být označena jako resource složka projektu

        InputStream input = GameData.class.getResourceAsStream(resourcePath);
        if (input == null){
            throw new RuntimeException();
        }
        try (input) {
            //Přečte celý JSON a vytvoří instanci GameData, naplní vlastnosti podle názvů klíčů v JSONU, vrátí se hotová třída GameData
            return gson.fromJson(new InputStreamReader(input, StandardCharsets.UTF_8), GameData.class);

        } catch (Exception e) {
           throw new RuntimeException("Chyba při načítání JSON: " + e.getMessage());
        }

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