/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.stack;

/**
 *
 * @author Profesor Lic. Gilberth Chaves A.
 */
public class ArrayStack implements Stack {
    private int n; //el tam max de la pila
    private int top; //para llevar el control del tope de la pila
    private Object dataStack[];
    
    //Constructor
    public ArrayStack(int n){
        if(n<=0) System.exit(1); //se sale
        this.n = n;
        this.top = -1; //indica q la pila esta vacia
        this.dataStack = new Object[n];
    }
    
    public int getTop(){
        return top;
    }

    @Override
    public int size() {
        return top+1;
    }

    @Override
    public void clear() {
        //dataStack = null;
        this.top = -1; //indica q la pila esta vacia
        this.dataStack = new Object[n];
    }

    @Override
    public boolean isEmpty() {
        return top==-1;
    }

    @Override
    public Object peek() throws StackException {
        if(isEmpty())
            throw new StackException("Array Stack is empty");
        return this.dataStack[top];
    }
    
    @Override
    public Object top() throws StackException {
        if(isEmpty())
            throw new StackException("Array Stack is empty");
        return this.dataStack[top];
    }

    @Override
    public void push(Object element) throws StackException {
        if(top==dataStack.length-1)
            throw new StackException("Array Stack is full");
        dataStack[++top] = element;
    }

    @Override
    public Object pop() throws StackException {
        if(isEmpty())
            throw new StackException("Array Stack is empty");
        return dataStack[top--];
    }

    public int getIndex(){
        return this.top; //si es -1 es xq la pila esta vacía
    }
    
    @Override
    public String toString() {
        if(isEmpty()) return "Array Stack is Empty";
        String result = "\nArray Stack Content";
        try {
            ArrayStack aux = new ArrayStack(size());
            while(!isEmpty()){           
                    result+="\n"+peek();
                    aux.push(pop());
            }
            
            //dejamos la pila como al inicio
            while(!aux.isEmpty()){           
                push(aux.pop());
            }
        } catch (StackException ex) {
                System.out.println(ex.getMessage());
        }
        
        return result;
    }

}
