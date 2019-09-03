public class Queue <E> extends LinkedList <E>
{
    public Queue() {}
    
    public void enqueue(E element) {
        addLast(element);
    }
    
    public E dequeue() {
        return removeFirst();
    }
    
    public E getFront() {
        return getFirst();
    }
}
