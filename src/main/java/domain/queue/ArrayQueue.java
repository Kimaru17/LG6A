/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.queue;
/**
 *
 * @author Profesor Lic. Gilberth Chaves A.
 * Cola con arreglos
 */
public class
ArrayQueue implements Queue{
    //Atributos
    private int n; //el tam max de la cola
    private Object queue[]; //arreglo de objetos
    private Integer priorityQueue[]; //para el manejo de prioridades
    //me permite manejar los extremos de la cola
    private int front, rear; //anterior, posterior
    
    //Constructor
    public ArrayQueue(int n){
        if(n<=0) System.exit(1); //se sale
        this.n = n;
        this.queue = new Object[n];
        this.priorityQueue = new Integer[n];
        this.rear = n-1; //ultimo elemento de la cola
        this.front = rear;
    }
    
    public int getFront(){
        return front;
    }
    
    public int getRear(){
        return rear;
    }
    

    @Override
    public int size() {
        return rear-front; //posterior-anterior
    }

    @Override
    public void clear() {
        this.rear = n-1; //ultimo elemento de la cola
        front = rear;
        this.queue = new Object[n];
        this.priorityQueue = new Integer[n];
    }

    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    @Override
    public int indexOf(Object element) throws QueueException {
        if(isEmpty())
            throw new QueueException("Array Queue is Empty");
        ArrayQueue aux = new ArrayQueue(size());
        int index1=0;
        int index2=-1; //si es -1 no existe
        while(!isEmpty()){
            if(util.Utility.compare(front(), element)==0){
                index2 = index1;
            }
            aux.enQueue(deQueue());
            index1++;
        }//while
        //al final dejamos la cola en su estado original
        while(!aux.isEmpty()){
            enQueue(aux.deQueue());
        }
        return index2;
    }

    @Override
    public void enQueue(Object element) throws QueueException{
        if(size()==queue.length)
            throw new QueueException("Array Queue is Full");
        
        //la primera vez no entra al for
        for (int i = front; i < rear; i++) {
            queue[i] = queue[i+1];
        }
        //siempre encola en el extremo posterior
        //y mueve anterior una posicion a la izq
        queue[rear] = element;
        front--; //la idea es q anterior quede en un campo vacio
    }
    
    @Override
    public void enQueue(Object element, Integer priority) throws QueueException {
        if(size()==queue.length){
            throw new QueueException("Array Queue is full");
        }
        boolean added=false;
        //cuando la cola esta vacia no entra al for
        for (int i = front; i < rear && !added; i++) {
            //verificamos la prioridad
            if(priorityQueue[i+1]!=null&&priority<priorityQueue[i+1]){
                queue[i] = element;
                priorityQueue[i] = priority;
                added = true; //rompe el bucle
            }else{
                queue[i] = queue[i+1];
                priorityQueue[i] = priorityQueue[i+1];
            }
        }
        if(!added){
            queue[rear] = element;
            priorityQueue[rear] = priority;
        }
        front--; //la idea es que front quede en una casilla vacia
    }

    @Override
    public Object deQueue() throws QueueException {
        if(isEmpty())
            throw new QueueException("Array Queue is Empty");
        return queue[++front];
    }

    @Override
    public boolean contains(Object element) throws QueueException {
        if(isEmpty())
            throw new QueueException("Array Queue is Empty");
        ArrayQueue aux = new ArrayQueue(size());
        boolean finded = false; //encontrado
        while(!isEmpty()){
            if(util.Utility.compare(front(), element)==0){
                finded = true;
            }
            aux.enQueue(deQueue());
        }//while
        //al final dejamos la cola en su estado original
        while(!aux.isEmpty()){
            enQueue(aux.deQueue());
        }
        return finded;
    }

    @Override
    public Object peek() throws QueueException{
        if(isEmpty())
            throw new QueueException("Array Queue is Empty");
        return queue[front+1];
    }
    
    @Override
    public Object front() throws QueueException{
        if(isEmpty())
            throw new QueueException("Array Queue is Empty");
        return queue[front+1];
    }
    
    @Override
    public String toString(){
        if(isEmpty()) return "Array Queue is Empty";
        String result = "\nArray Queue Content\n";
        try {
            ArrayQueue aux = new ArrayQueue(size());
            while(!isEmpty()){
                result+=front()+"\n";
                aux.enQueue(deQueue());
            }
            //al final dejamos la cola en su estado original
            while(!aux.isEmpty()){
                enQueue(aux.deQueue());
            }
        }catch(QueueException ex){
            System.out.println(ex.getMessage());
        }
        return result;
    }
}
