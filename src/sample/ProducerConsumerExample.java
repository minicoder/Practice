package sample;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerExample {
	public static void main(String[] args) {
		 MessageQueue queue = new MessageQueue(5);
		 new Producer(queue).start();
		 new Producer(queue).start();
		 new Producer(queue).start();
		 new Consumer(queue).start();
		 new Consumer(queue).start();
		 new Consumer(queue).start();
		 }
}

class Producer extends Thread{
	private static int count = 0;
	private MessageQueue queue = null;

	public Producer(MessageQueue queue){
		this.queue = queue;
	}

	public void run(){
		for(int i=0;i<10;i++) {
			queue.put(generateMessage());
		}
	}

	private String generateMessage() {
		String msg = "MSG#"+count;
		count++;
		return msg;
	}
}

class Consumer extends Thread {
	private MessageQueue queue = null;
	public Consumer(MessageQueue queue){
		this.queue = queue;
	}

	public void run(){
		for(int i=0;i<10;i++){
			System.out.println("Consumer downloads "
					+queue.get()+ " from the queue.");
		}
	}
}

class MessageQueue {
	//the size of the buffer 
	private int bufferSize;

	//the buffer list of the message, assuming the string message format
	private List<String> buffer = new ArrayList<String>();

	//construct the message queue with given buffer size 
	public MessageQueue(int bufferSize){
		if(bufferSize <= 0)
			throw new IllegalArgumentException("Size is illegal.");
		this.bufferSize = bufferSize;
	}
	//check whether the buffer is full
	public synchronized boolean isFull() {
		return buffer.size() == bufferSize;
	}
	//check whether the buffer is empty
	public synchronized boolean isEmpty() {
		return buffer.isEmpty();
	}

	public synchronized void put(String message){
		while(isFull()) {
			System.out.println("Buffer is full");
			try{
				wait();
			}catch(InterruptedException ie) {
				ie.printStackTrace();
			}
		}
		buffer.add(message);
		System.out.println("Queue receives message '"+message+"'");
		//wakeup all the waiting threads to proceed
		notifyAll();

	}

	public synchronized String get(){
		String message = null;
		while(isEmpty()) {
			System.out.println("No msg in buffer");
			try{
				wait();	 
			}catch(InterruptedException ie){
				ie.printStackTrace();
			}
		}
		message = buffer.remove(0);
		notifyAll();
		return message;

	}

}
