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

    public static Color getForegroundColor() {
        if (currentTheme.equals("dark")) {
            return Color.WHITE;
        }
        return Color.BLACK;
    }
}



