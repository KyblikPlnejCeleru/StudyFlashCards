import Brain.ThemeManager;
import Windows.WelcomeScreen;

/**
 * The main class of the StudyFlashCards application.
 * This class is responsible for initializing the application, loading theme settings,
 * and displaying the welcome screen.
 */
public class Main {
    public static void main(String[] args) {
        ThemeManager.loadSettings();
        WelcomeScreen title = new WelcomeScreen();
        title.showApp();
    }
}