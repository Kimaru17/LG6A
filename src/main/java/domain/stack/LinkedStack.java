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
public class LinkedStack implements Stack {
    private Node top;// es un apuntador
    private int counter; //cont elementos apilados

    public LinkedStack(){
        this.top = null;
        this.counter = 0;
    }
    
    @Override
    public int size() {
        return counter;
    }
    
    @Override
    public void clear() {
        top = null;
        this.counter = 0;
    }

    @Override
    public boolean isEmpty() {
        return top==null;
        //return counter==0;
    }

    @Override
    public Object peek() throws StackException {
        if(isEmpty())
            throw new StackException("Linked Stack is empty");
        return top.data;
    }
    
    @Override
    public Object top() throws StackException {
        if(isEmpty())
            throw new StackException("Linked Stack is empty");
        return top.data;
    }

    @Override
    public void push(Object element) throws StackException {
        Node newNode = new Node(element);
        if(isEmpty()){
            //creamos un nuevo nodo
            top = newNode;
        }
        else{
            newNode.next = top; //hacemos el enlace entre nodos
            top = newNode; //la decimos a tope q apunte a newNode
        }
        this.counter++; //incremento el contador
    }

    @Override
    public Object pop() throws StackException {
        if(isEmpty())
            throw new StackException("Linked Stack is empty");
        Object topElement = top.data;
        top = top.next; //movemos tope al sgte nodo
        counter--;
        return topElement;
    }
    
    @Override
    public String toString() {
        if(isEmpty()) return "Linked Stack is Empty";
        String result = "\nLinked Stack Content";
        try {
            LinkedStack aux = new LinkedStack();
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
    
    /*********************************
     * IF-3001. EXAMEN PARCIAL 1 (20%)
     * I-2020
     *********************************/
    
    /**
     * PREGUNTA - METODO replace
     * Suponga un nuevo método para la implementación en java de la 
     * pila enlazada (LinkedStack) llamado replace.Este método 
     * reemplaza (si existe) un objeto de la pila por uno nuevo 
     * indicado.Por ejemplo, si stack1 tiene apilados los elementos 
     * 10, 20, 30, 40, 50; entonces el llamado de stack1.replace(30, 100); 
     * debería dejar stack1 con los elementos: 10, 20, 100, 40, 50.
     * Escriba el código de implementación en java para el método 
     * replace.
     * @param a
     * @param b
     * @throws StackException
     */
    public void replace(Object a, Object b) throws StackException {
        if(this.isEmpty())
            throw new StackException("Linked Stack is empty");
        LinkedStack aux = new LinkedStack();
        while(!isEmpty()){
            if(util.Utility.compare(top(), a)==0){
                pop(); //desapilo el objeto
                aux.push(b); //apilo el nuevo objeto en aux
            }
            aux.push(pop());
        }//while
        //al final dejamos la pila en su estado original
        while(!aux.isEmpty()){
            push(aux.pop());
        }
    }
}
