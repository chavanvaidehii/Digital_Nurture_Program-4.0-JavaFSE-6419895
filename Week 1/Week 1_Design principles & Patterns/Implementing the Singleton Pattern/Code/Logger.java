public class Logger {
    // Step 2: Private static instance of the class
    private static Logger instance;

    // Step 3: Private constructor to prevent external instantiation
    private Logger() {
        System.out.println("Logger Initialized.");
    }

    // Step 4: Public static method to provide access to the instance
    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Sample logging method
    public void log(String message) {
        System.out.println("Log: " + message);
    }
}
