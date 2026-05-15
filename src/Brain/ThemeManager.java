package Brain;

import javax.swing.*;
import java.awt.*;

public class ThemeManager {
    private static String currentTheme = "light";

    public static String getCurrentTheme() {
        return currentTheme;
    }

    public static void setTheme(String theme) {
        currentTheme = theme;
    }

    public static Color getBackgroundColor() {
        if (currentTheme.equals("dark")) {
            return new Color(30, 35, 34);
        }
        return Color.WHITE;
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
        }
        return Color.BLACK;
    }
}



