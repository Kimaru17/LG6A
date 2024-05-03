package domain;

import domain.Message;
import domain.queue.ArrayQueue;
import domain.queue.HeaderLinkedQueue;
import domain.queue.LinkedQueue;
import domain.queue.QueueException;
import org.junit.jupiter.api.Test;
import util.Utility;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {
    @Test
    public void test() throws QueueException {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        HeaderLinkedQueue headQueue = new HeaderLinkedQueue();
        LinkedQueue linkedQueue = new LinkedQueue();

        Message message;

        System.out.println("Adding to the queue");

        // Enqueue messages
        for (int i = 0; i < 5; i++) {
            message = new Message(Utility.getRandom(3), "Message No." + Utility.getRandom(15));
            arrayQueue.enQueue(message, message.getPriority());
        }

        for (int i = 0; i < 5; i++) {
            message = new Message(Utility.getRandom(3), "Message No." + Utility.getRandom(15));
            headQueue.enQueue(message, message.getPriority());
        }

        for (int i = 0; i < 5; i++) {
            message = new Message(Utility.getRandom(3), "Message No." + Utility.getRandom(15));
            linkedQueue.enQueue(message, message.getPriority());
        }

        System.out.println(arrayQueue);
        System.out.println(headQueue);
        System.out.println(linkedQueue);

        // Dequeue based on priority
        String dequeue = "";
        for (int p = 1; p <= 3; p++) {
            // Dequeue from ArrayQueue
            while (!arrayQueue.isEmpty()) {
                message = (Message) arrayQueue.front();
                if (message.getPriority() == p) {
                    dequeue += arrayQueue.deQueue().toString() + "\n";
                } else {
                    arrayQueue.deQueue();
                }
            }

            // Dequeue from HeaderLinkedQueue
            while (!headQueue.isEmpty()) {
                message = (Message) headQueue.front();
                if (message.getPriority() >= p) {
                    dequeue += headQueue.deQueue().toString() + "\n";
                } else {
                    headQueue.deQueue();
                }
            }

            // Dequeue from LinkedQueue
            while (!linkedQueue.isEmpty()) {
                message = (Message) linkedQueue.front();
                if (message.getPriority() >= p) {
                    dequeue += linkedQueue.deQueue().toString() + "\n";
                } else {
                    linkedQueue.deQueue();
                }
            }
        }

        System.out.println("Dequeued Messages:\n" + dequeue);
        System.out.println("Remaining Messages in Queues:");
        System.out.println(arrayQueue);
        System.out.println(headQueue);
        System.out.println(linkedQueue);
    }
}