
// @author fsaiete

import java.util.*;
public interface Pilha<E>{
//Returns true if the stack contains no elements.
    public boolean isEmpty( );
// Returns the number of elements in the stack.
    public int size( );
// Returns the element at the top of the stack.
    public E top( ) throws EmptyStackException;
// Inserts the specified element onto the top of the stack.
    public void push(E element);
// Removes and returns the element at the top of the stack.
    public E pop( ) throws EmptyStackException;
} 
