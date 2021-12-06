package client;

import util.Util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class represents a client that requests a resource of a CheckoutServer.
 */
public class CheckoutClient {
    private String host;
    private int port;
    private Socket socket;
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private int maxConnectionAttempts = 10;


    /**
     * Creates a CheckoutClient that will connect to the specified host
     * on the specified port.
     * @param host Name of the host.
     * @param port Port on which to connect to host.
     */
    public CheckoutClient(String host, int port) {
        this.host = host;
        this.port = port;
    }


    /**
     * Connects to the server specified by the fields. If the server cannot
     * be reached, the client tries again after 3 seconds.
     */
    public void connectToServer() {
        // loop until connected to server
        for (int i = 0; i < maxConnectionAttempts; i++) {
            try {
                socket = new Socket(host, port);
                output = new ObjectOutputStream(socket.getOutputStream());
                input = new ObjectInputStream(socket.getInputStream());
                Util.log(2, "Connected to " + host + " on port " + port);
                break;
            } catch (IOException e) {
                Util.log(2, "Could not connect to server. Trying again...");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e2) {
                    Util.logError(0, e2);
                }
            }
            if (i == maxConnectionAttempts - 1)
                Util.log(0, String.format("Client failed to connect to server after %d attempts." +
                        "\nPlease try again later.", maxConnectionAttempts));
        }
    }


    /**
     * Sends a request in the form of a string to the server. The server expects
     * a request in the for "[SEAT],[PRIORITY]". Any request not matching this form
     * is considered malformed.
     *
     * This method uses the ObjectOutputStream output to send the request to
     * the server and ObjectInputStream input to read a response from the
     * server.
     *
     * @param request A string with a request for the server.
     */
    public void sendRequest(String request) {
        // send request to server
        // TODO: STUDENT INSTRUCTION
        // Write the relevant request information to the output stream instance

        Util.log(2, Thread.currentThread().getName() + " sent request to server: " + request);

        // get confirmation
        Object response = null;
        // TODO: STUDENT INSTRUCTION
        // Read response from the server and log the response

        Util.log(1, "Receipt: " + response);
    }


    /**
     * Closes the client's socket.
     */
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            Util.logError(0, e);
        }
    }
}
