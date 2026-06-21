public class Logger {
    private static Logger loggerInstance = new Logger();
    static int logLevel = 0 ;
    private Logger() {
        System.out.println(logLevel);
    }

    public static Logger getLogger() {
        return loggerInstance;
    }
}
