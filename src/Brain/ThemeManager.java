package Brain;

import javax.swing.*;
import java.awt.*;
import java.io.*;

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
    //applyTheme is fully AI generated.
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



