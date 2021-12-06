package server;

/**
 * Represents a thread-safe priority queue. While it is good practice
 * to implement the Queue<E> interface, there are a lot of methods from
 * Collections and Queue that are not needed for this application. For
 * simplicity, it is fine to only provide needed methods.
 * @param <E> Type of objects held in the queue.
 */
public class SynchronizedPriorityQueue<E> {
    /*
     * TODO: STUDENT INSTRUCTION
     * Add any instance variables you find necessary.
     */


    /**
     * TODO: STUDENT INSTRUCTION
     * Complete this method to add elements to the job queue in a thread-safe manner.
     * The boss thread adds elements to this queue for the workers to pick up.
     *
     * @param item The RequestItem to be added to the queue.
     * @return Returns true if item was successfully added, false otherwise.
     */
    public synchronized boolean addToQueue(E item) {

        return false;
    }

    /**
     * TODO: STUDENT INSTRUCTION
     * Complete this method to remove elements from the job queue in a thread-safe manner.
     * The boss thread adds elements to this queue for the workers to pick up.
     *
     * @return Returns an E object from the queue or null if the queue is empty.
     */
    public synchronized E pollFromQueue() {

        return null;
    }
}
