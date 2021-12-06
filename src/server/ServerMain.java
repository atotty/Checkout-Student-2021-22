package server;

/**
 * Entry point for the server. This program starts a CheckoutServer.
 */
public class ServerMain {

    /**
     * Starts a CheckoutServer on the provided port with the provided number
     * of threads. Modify these values to test your program under different
     * configurations.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        // set port, numThreads, etc.
        int port = 5000;
        int numThreads = 3;

        // create the server (which runs forever)
        CheckoutServer server = new CheckoutServer(port, numThreads, "seats.txt");
        server.start();
    }
}
