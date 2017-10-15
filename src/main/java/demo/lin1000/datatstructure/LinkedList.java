package demo.lin1000.datatstructure;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class LinkedList<E> implements List<E>{

    // a static inner class represent linked list node strcuture
    static class LinkedListNode<E>{
        private E data;
        private LinkedListNode<E> next;
        private LinkedListNode<E> prev;

        LinkedListNode(LinkedListNode<E> prev, E data, LinkedListNode<E> next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }


    transient LinkedListNode<E> first;
    transient LinkedListNode<E> last;
   
    private int size;


    public LinkedList(){        
    }

    public LinkedList(Collection<? extends E> c) {
        this();
        addAll(c);
    }    


	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		return null;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return null;
	}

	@Override
	public boolean add(E e) {
        
        final LinkedListNode<E> newNode = new LinkedListNode<>(null, e, null);
        if(first ==null && last == null){
            //linked list initialization
            //add first node            
            first = newNode;
            last = newNode;
            
        }else{

            // add node at last
            final LinkedListNode<E> prevLast = last;
            prevLast.next = newNode;
            newNode.prev = prevLast;
            last = newNode;

        }

        size++;
        return true;
	}

	@Override
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return false;
	}

	@Override
	public void clear() {
		
	}

	@Override
	public E get(int index) {
		return null;
	}

	@Override
	public E set(int index, E element) {
		return null;
	}

	@Override
	public void add(int index, E element) {
		
	}

	@Override
	public E remove(int index) {

        if(index <0 || index >= size) return null;

        LinkedListNode<E> toBeRm = first;
        for(int i=0; i < index;i++){
            toBeRm = toBeRm.next;
        }

        if(toBeRm == last && toBeRm==first) {
            first = null;
            last = null;
        }else if(toBeRm==first){
            first = toBeRm.next;
            toBeRm.next.prev=null;
        }else if(toBeRm==last){
            last = toBeRm.prev;
            toBeRm.prev.next = null;
        }else{
            toBeRm.next.prev = toBeRm.prev;
            toBeRm.prev.next = toBeRm.next;
        }

        size--;
		return toBeRm.data;
	}

	@Override
	public int indexOf(Object o) {
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		return null;
    }
    
    /**
     * Tells if the argument is the index of a valid position for an
     * iterator or an add operation.
     */
    private boolean isPositionIndex(int index) {
        return index >= 0 && index <= size;
    }  
    
    public void print() {
        LinkedListNode<E> curr = first;
        if(curr!=null){
            System.out.println(curr.data);
        }

        while(curr.next != null) {
            curr = curr.next;
            System.out.println(curr.data);
        }
    }    

    public static void main(String[] args){
        
        LinkedList<String> list = new LinkedList<>();
        list.add("Tony");
        list.add("Elisa");
        list.add("Commander");
        list.add("Stormtrooper");
        list.remove(1);
        list.remove(2);
        list.add("Stormtrooper");
        list.add("Stormtrooper");
        list.add("Ray");
        
        System.out.println(list.size());
        list.print();
    }
    
}