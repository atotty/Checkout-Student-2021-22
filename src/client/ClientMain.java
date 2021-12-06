package client;

import util.Util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Entry point for the client program. This program creates multiple
 * CheckoutClients, each of which sends requests to the server.
 */
public class ClientMain {
    private static String host = "127.0.0.1";
    private static int port = 5000;
    private static String workloadFileName = "workload.txt";
    private static int numThreads = 4;

    private static List<String> workload = null;
    private static Thread[] threads;
    private static boolean allRequestsSent = false;

    /**
     * Gets a request string from the workload list.
     * @return A string representing a request to send to the server.
     */
    private static synchronized String getPathFromWorkload() {
        if (workload.size() == 0) {
            Util.log(2, "No requests found in workload.");
            return null;
        }
        return workload.remove(0);
    }

    /**
     * Initialized the threads for this client work generator. Each thread
     * creates its own CheckoutClient, gets a request from the workload,
     * sends that request to the server, and handles the response.
     *
     * @param numThreads The number of client threads.
     */
    private static void initThreads(int numThreads) {
        threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            Runnable task = () -> {
                Util.log(3, Thread.currentThread().getName() + " created.");

                while (!allRequestsSent) {
                    CheckoutClient client = new CheckoutClient(host, port);
                    client.connectToServer();

                    // get request from workload
                    String message = null;
                    synchronized (workload) {
                        if (workload.size() == 0) {
                            Util.log(4, "No requests found in workload.");
                            allRequestsSent = true;
                            client.close();
                            return;
                        }
                        message = workload.remove(0);
                        Util.log(3, Thread.currentThread().getName() + " got request from workload: " + message.split(",")[0]);
                    }

                    // send message to server
                    if (message != null) {
                        client.sendRequest(message);
                        Util.log(2, Thread.currentThread().getName() + " finished a job: " + message);
                    }

                    client.close();
                }

                Util.log(2, Thread.currentThread().getName() + " is exiting.");
            }; // end task defn

            // create thread from task and start it
            Thread thread = new Thread(task);
            thread.start();
            threads[i] = thread;
        }
    }

    public static void main(String[] args) {
        // generate workload
        try {
            workload = Collections.synchronizedList(Files.readAllLines(Paths.get("resources", workloadFileName)));
        } catch (IOException e) {
            Util.logError(0, e);
        }

        // start threads
        if (numThreads > workload.size())
            numThreads = workload.size();

        initThreads(numThreads);

        // wait for threads to finish before exiting
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
                Util.log(3, "Thread " + i + " finished.");
            } catch (InterruptedException e) {
                Util.logError(0, e);
            }
        }

        Util.log(1, "ClientMain finished.");
    }
}
