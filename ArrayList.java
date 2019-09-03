public class ArrayList<E> extends AbstractList<E> {
    
    public static int INITIAL_CAPACITY = 1;
    private E[] data = (E[]) (new Object[INITIAL_CAPACITY]);

    public ArrayList(){}
    
    public ArrayList(int newCapacity) {
        INITIAL_CAPACITY = newCapacity;
    }

    public ArrayList(E[] element)
    {
        for(int i=0; i<element.length; i++)
            add(element[i]);        
    }
    
    private void ensureCapacity()
    {
        if(size >= data.length)
        {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data=newData;
        }
    }
        
    public void add(E element) {
        ensureCapacity();        
        data[size++] = element ;        
    }   
    
    public void add(int index, E element) {
        ensureCapacity();
        
        for (int i=size-1; i>=index; i--)        
            data[i+1] = data[i];   
           
        data[index] = element;  
        size++;
        
    }
    
    public E get(int index) {
        return data[index];
    }

    public void clear() {
        data = (E[]) (new Object[INITIAL_CAPACITY]);
        size=0;     
    }

    public boolean contains(E element) {
        for (int i=0; i<size; i++)
            if(element.equals(data[i])) 
                return true;
        return false;
    }

    public int indexOf(E element) {
        for(int i=0; i<size; i++)
            if(element.equals(data[i]))
                    return i;
        return -1;
    }
    
    public int lastIndexOf(E element) {
        for(int i=size-1; i>= 0; i++)
            if(element.equals(data[i]))
                return i;
        return -1;      
    }   

    public E remove(int index) {
        E element = data[index];
        
        for(int j=index; j<size-1; j++)
            data[j]=data[j+1];
        
        data[size-1] = null;
        size--;     
        return element;
    }

    public E set(int index, E element) {
        E old = data[index];
        data[index] = element;        
        return old;
    }
    
    public String toString()
    {
        StringBuilder result = new StringBuilder("[");
        
        for(int i =0; i<size(); i++)
        {
            result.append(data[i]);
            if(i<size-1)
                result.append(", ");
        }
        return result.toString() + "]";
    }

    public void trimToSize() {
        if(size != data.length) {
            E[] newData = (E[]) (new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;     
        }
    }


}
