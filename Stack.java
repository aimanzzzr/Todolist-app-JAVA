public class Stack <E> extends LinkedList <E>
{
    public Stack() {}
    
    public void push(E element) {
        addLast(element);
    }
    
    public E pop() {
        return removeLast();
    }
    
    public E peek() {
        return getLast();       
        
    }

}
