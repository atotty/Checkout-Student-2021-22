# Project 3: Checkout Application
In this project you will complete an online checkout manager that simulates the purchase of tickets for an event venue. The project consists of a multithreaded server that handles requests for seats at a venue and a multithreaded client that generates a synthetic workload to run against the server. Multiple requests should be processed simultaneously. Requests have non-negative priority numbers, where 0 is the highest priority. This priority should be observed across all requests (i.e. priority number 0 requests should be handled before priority number 1 requests, which should in turn be handled before priority number 2 requests, and so on). For two requests of the same priority, the first request to arrive should be processed first. 

The server follows a multithreaded design known as a boss-worker model with a shared job queue. The primary thread, the boss, receives requests from clients and adds those requests to a job queue. Worker threads pick up jobs from the job queue and handle the corresponding request. 

Much of the synchronization required for multithreading is handled for you. Your primary task is to build the server’s job queue that worker threads will use to pick up jobs. You will provide the queue structure, operations on the queue, and implementations of comparisons for items in the queue. 

## Project Structure
The files included in the project are as follows. Files you need to modify are marked in bold. Your tasks are identified by comments of the form **_TODO: STUDENT INSTRUCTION_**. The program can be run by running ServerMain.java and ClientMain.java independently. 

- **src/server/SynchronizedPriorityQueue.java** - A thread-safe priority queue with basic functionality that will be used by the server to track request jobs. 

- **src/client/CheckoutClient.java** - Represents a client that can make requests of the CheckoutServer. 

- src/client/ClientMain.java - The main class that creates CheckoutClients to run against the server. This class is multithreaded, and you can modify the number of threads if you choose. You may modify workloadFileName to be your own workload files for testing. 

- **src/server/CheckoutServer.java** - Represents a server that can handle resource requests from a CheckoutClient. You will provide a job queue of RequestItems and necessary operations on that queue. The boss thread receives requests from a client and adds them to the queue. Worker threads pull jobs from the queue and handle the request. 

- src/server/ServerMain.java - The main class that starts a server. You can adjust server settings such as number of worker threads and port here, though these changes are not necessary. 

- **src/server/RequestItem.java** - Defines the server’s data structure for a request to be handled by the worker threads. You will implement the compareTo method. You may choose to use this method to determine order for elements in your server’s queue. Additionally, add any variables or methods that help you meet the requirements of this project.  

- **src/server/RequestItemComparator.java** - Defines a comparator for RequestItems. You will implement the compare method in a way you find most relevant to achieving the goals of the project. You may choose to use this comparator to determine order for elements in your server’s queue. 

- **resources/workload.txt** - A simple workload of requests that ClientMain uses to run against the server. You should modify this as you see fit for testing. All entries must have the form [RESOURCE],[PRIORITY], and entries must be separated by a new line. 

- **resources/seats.txt** - A file containing all the available resources of which the server is aware. You should modify this as you see fit for testing. All entries must have the form [RESOURCE] and entries must be separated by a new line. 

- src/util/Util.java - contains utility methods used throughout the program. You may modify this file, but no modifications are required. Assigning a value to LOG_LEVEL yields logs throughout the program with log levels less than or equal to LOG_LEVEL. Pay close attention to the log method, as it is helpful for debugging your program. You can add log messages by following this pattern: 

      Util.log(2, “This is a log of priority level 2”); 

## Evaluation
Your submission will be graded on the following rubric. 
- (10 pts.) Server correctly prioritizes VIP (priority number 0) orders above non-VIP orders. 

- (10 pts.) Server correctly prioritize orders of the same priority to be handled on a first-come-first-served basis. 

_Note: Due to how threads are managed, there is no guarantee that the server, if multithreaded, will actually service requests in a defined order, nor that the client will report the result of their request in a defined order. Nonetheless, your queue should observe the ordering described, as I will directly test this functionality._

- (5 pts.) Server correctly sends an “INVALID” response to malformed requests. 

- (5 pts.) Server reserves a resource and sends a receipt to a client when the resource was available. 

- (5 pts.) Server does not reserve resources that are unavailable and sends a receipt to the client indicating the resource was unavailable. 

- (5 pts.) Server can be multithreaded and handles multiple simultaneous requests without race conditions. 

- (5 pts.) RequestItem is comparable and/or RequestItemComparator has been meaningfully implemented. 

- (5 pts.) You have completed student_readme.md to describe your approach to solving the problems you encountered while creating it. This need not be a diary, but your design choices should be clearly explained here.
    - What design choices did you make? Why? 
    - How did you test your code? 
    - What changes would you make to the application/project? 


## Submission instructions 
Please submit the link to your Github (or similar) repository that contains your project. Make sure your repository is private. 

This project is a solo project and should contain a representation of your understanding of the content. If you use an idea from another source (content or styling from another website, classmate, etc.) you must cite that source. Failure to do so is considered an AI violation. 

Late work will be accepted with a penalty of 5% for each day the submission is late (up to a maximum 30% penalty). 
