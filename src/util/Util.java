package util;

/*
 * This class contains utility methods for the application.
 *
 * Note: You do not need to modify anything in this file, but you may
 * find it useful to read this source code to better understand how the
 * program works. Additionally, you may add your own utility methods
 * here for use elsewhere in the program.
 */
public class Util {
    private static final int LOG_LEVEL = 1;
    private static final int ERR_LOG_LEVEL = 1;

    /**
     * Prints log message to console if the message level is at least
     * the provided log level.
     *
     * You may modify this method if you choose, but it is not necessary.
     * The program expects this method to exist with its current header.
     * @param messageLevel
     * @param message
     */
    public static void log(int messageLevel, String message) {
        if (messageLevel <= LOG_LEVEL)
            System.out.println(message);
    }


    /**
     * Prints error trace to console if the message level is at least
     * the provided log level.
     *
     * You may modify this method if you choose, but it is not necessary.
     * The program expects this method to exist with its current header.
     * @param errorLevel
     * @param e
     */
    public static void logError(int errorLevel, Exception e) {
        if (errorLevel<= ERR_LOG_LEVEL)
            e.printStackTrace();
    }
}
