package my.edu.utem.faheemezani.ecommerce;

public class AppConfig {

    // Enum for theme mode
    public enum ThemeMode {
        LIGHT,
        DARK,
        SYSTEM_DEFAULT
    }

    // Singleton instance
    private static AppConfig instance;

    // Configuration values
    private ThemeMode themeMode = ThemeMode.DARK;

    // Private constructor
    private AppConfig() {
        // Default settings can go here
    }

    // Thread-safe lazy initialization
    public static synchronized AppConfig getInstance() {
        if (instance == null) {
            instance = new AppConfig();
        }
        return instance;
    }

    // Getter and setter for theme mode
    public ThemeMode getThemeMode() {
        return themeMode;
    }

    public void setThemeMode(ThemeMode mode) {
        this.themeMode = mode;
    }

    // You can add more config values as needed
}