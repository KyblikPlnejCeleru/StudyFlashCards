package Brain;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * The ThemeManager class handles the application's theming, including light, dark, and custom themes.
 * It provides methods to set, apply, save, and load theme settings.
 */
public class ThemeManager {

    private static String currentTheme = "light";
    private static Color customBackground;
    public static void setCustomBackground(Color customBackground) {
        ThemeManager.customBackground = customBackground;
    }


    public static String getCurrentTheme() {
        return currentTheme;
    }
    public static void setTheme(String theme) {
        currentTheme = theme;
    }

    public static Color getBackgroundColor() {
        if (currentTheme.equals("dark")) {
            return new Color(30, 35, 34);
        } else if (currentTheme.equals("light")) {
            return Color.WHITE;
        }
        return customBackground;
    }
    /**
     * Applies the currently selected theme to various Swing UI components.
     * This method iterates through common Swing component keys and sets their background and foreground colors
     * based on the current theme settings.
     * @Author claude.ai
     */
    public static void applyTheme() {
        String[] keys = {"Panel", "OptionPane", "FileChooser", "TextField",
                "List", "ComboBox", "ScrollPane", "Viewport",
                "ToolBar", "Tree", "Table", "Button", "Label",
                "RadioButton", "CheckBox", "TabbedPane", "SplitPane"};
        for (String key : keys) {
            UIManager.put(key + ".background", getBackgroundColor());
            UIManager.put(key + ".foreground", getForegroundColor());
        }
        UIManager.put("TextField.caretForeground", getForegroundColor());
        UIManager.put("TextArea.background", getBackgroundColor());
        UIManager.put("TextArea.foreground", getForegroundColor());
        UIManager.put("OptionPane.messageForeground", getForegroundColor());
    }

    /**
     * Returns the foreground color for the current theme.
     * For custom themes, it determines a suitable foreground color (black or white) based on the custom background's brightness.
     * @return The Color object representing the foreground color.
     */
    public static Color getForegroundColor() {
        if (currentTheme.equals("dark")) {
            return Color.WHITE;
        } else if (currentTheme.equals("light")) {
            return new Color(30, 35, 34);
        }
            int b = (customBackground.getRed() + customBackground.getGreen() + customBackground.getBlue()) / 3;
        if (b > 128) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }

    /**
     * Saves the current theme settings (current theme name and custom background RGB if applicable)
     * to a file named "settings.romek".
     */
    public static void saveSettings() {
        try {
            File file = new File("settings.romek");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(currentTheme);
            bufferedWriter.newLine();
            if (customBackground != null) {
                bufferedWriter.write(String.valueOf(customBackground.getRGB()));
            }
            bufferedWriter.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null,"settings save issue","error",JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Loads the theme settings from the "settings.romek" file.
     * If the file exists, it reads the current theme and custom background RGB (if present).
     */
    public static void loadSettings() {
        try {
            File file = new File("settings.romek");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            currentTheme = bufferedReader.readLine();
            String rgb = bufferedReader.readLine();
            if (rgb != null){
                customBackground = new Color(Integer.parseInt(rgb));
            }
            bufferedReader.close();
        } catch (Exception exception) {
            JOptionPane.showMessageDialog(null,"settings loading issue","error",JOptionPane.WARNING_MESSAGE);
        }
    }
}