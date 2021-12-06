package server;

import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * This class represents a communications context for the server.
 * Objects of this class store information relevant to a communication
 * channel shared with a client.
 */
public class Context {
    private Socket socket;
    private ObjectOutputStream objectOutputStream;

    public Context(Socket socket, ObjectOutputStream objectOutputStream) {
        this.socket = socket;
        this.objectOutputStream = objectOutputStream;
    }

    public Socket getSocket() {
        return socket;
    }

    public ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
    }
}
