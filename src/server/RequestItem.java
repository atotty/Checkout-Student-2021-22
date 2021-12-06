package server;

/**
 * This class represents requests that the server receives.
 * Each RequestItem maintains data on the request and the context of the communication
 * with the client.
 */
public class RequestItem implements Comparable<RequestItem>, java.io.Serializable {
    private Context ctx;
    private Object request;
    private int priority; // priority is a non-negative integer where lower values have higher priority
                          // (e.g. priority 0 is a higher priority than priority 1)

    /*
     * TODO: STUDENT INSTRUCTION
     * Add any fields, methods, etc. you find relevant and necessary.
     */



    public RequestItem(Context ctx, Object request, int priority) {
        this.ctx = ctx;
        this.request = request;
        this.priority = priority;
    }

    public Object getRequest() {
        return request;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public int getPriority() {
        return priority;
    }

    /**
     * TODO: STUDENT INSTRUCTION
     * Implement the this method to make RequestItems Comparable. You may
     * choose to use this method as a means to order elements in your server
     * job queue.
     *
     * @param o The object to compare to this.
     * @return An int representing this-o.
     */
    @Override
    public int compareTo(RequestItem o) {

        return 0;
    }

    @Override
    public String toString() {
        return "QueueItem{" +
                "request=" + request +
                ", priority=" + priority +
                '}';
    }
}
