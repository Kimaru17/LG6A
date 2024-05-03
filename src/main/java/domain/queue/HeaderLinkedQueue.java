/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain.queue;

/**
 *
 * @author Profesor Lic. Gilberth Chaves A.
 * Cola enlazada con nodo cabecera (nodo vacio)
 */
public class HeaderLinkedQueue implements Queue {
    private Node front; //anterior
    private Node rear; //posterior
    private int count; //control de elementos encolados
    
    //Constructor
    public HeaderLinkedQueue(){
        //inicializo ant y post en un nodo cabecera
        front=rear=new Node();
        count=0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        front=rear=new Node();
        count=0;
    }

    @Override
    public boolean isEmpty() {
        return front==rear;
    }

    @Override
    public int indexOf(Object element) throws QueueException {
        if(isEmpty())
            throw new QueueException("Header Linked Queue is Empty");
        HeaderLinkedQueue aux = new HeaderLinkedQueue();
        int pos1=1;
        int pos2=-1; //si es -1 no existe
        while(!isEmpty()){
            if(util.Utility.compare(front(), element)==0){
                pos2 = pos1;
            }
            aux.enQueue(deQueue());
            pos1++;
        }//while
        //al final dejamos la cola en su estado original
        while(!aux.isEmpty()){
            enQueue(aux.deQueue());
        }
        return pos2;
    }

    @Override
    public void enQueue(Object element) throws QueueException {
        Node newNode = new Node(element);
        rear.next = newNode; //posterior.sgte=nuevoNodo
        rear = newNode; //posterior=nuevoNodo
        //al final actualizo el contador
        count++;
    }
    
    @Override
    public void enQueue(Object element, Integer priority) throws QueueException {
        Node newNode = new Node(element, priority);
        if(isEmpty()){ //la cola no existe
            rear.next = newNode;
            //garantizo que anterior quede apuntando al primer nodo
            rear = newNode;
        }else{ //que pasa si ya hay elementos encolados
            Node aux = front.next;
            Node prev = front.next;
            while(aux!=null&&aux.priority<=priority){
                prev = aux; //dejo un rastro
                aux = aux.next;
            }
            //se sale cuando alcanza nulo o la prioridad del nuevo elemento
            //es mayor
            if(aux==front.next){
                newNode.next = front.next;
                front.next = newNode;
            }else
                if(aux==null){
                    prev.next = newNode;
                    rear = newNode;
                }else{ //en cualquier otro caso
                    prev.next = newNode;
                    newNode.next = aux;
                }
        }    
    }

    @Override
    public Object deQueue() throws QueueException {
        if(isEmpty())
            throw new QueueException("Header Linked Queue is Empty");
        Object element = front.next.data;
        //caso 1. cuando solo hay un elemento
        if(front.next==rear){
            clear(); //elimino la cola
        }else{ //caso 2. caso contrario
            front.next = front.next.next;
        }
        //actualizo el contador de elementos encolados
        count--;
        return element;
    }

    @Override
    public boolean contains(Object element) throws QueueException {
        if(isEmpty())
            throw new QueueException("Header Linked Queue is Empty");
        HeaderLinkedQueue aux = new HeaderLinkedQueue();
        boolean finded = false;
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
    public Object peek() throws QueueException {
        if(isEmpty())
            throw new QueueException("Header Linked Queue is Empty");
        return front.next.data;
    }

    @Override
    public Object front() throws QueueException {
        if(isEmpty())
            throw new QueueException("Header Linked Queue is Empty");
        return front.next.data;
    }
    
    @Override
    public String toString(){
        if(isEmpty()) return "Header Linked Queue is Empty";
        String result = "\nHeader Linked Queue Content:\n";
        try {
            HeaderLinkedQueue aux = new HeaderLinkedQueue();
            while(!isEmpty()){
                result+=front()+"\n";
                aux.enQueue(deQueue());
            }
            //al final dejamos la cola en su estado original
            while(!aux.isEmpty()){
                enQueue(aux.deQueue());
            }
        }catch (QueueException ex) {
                System.out.println(ex.getMessage());
        }
        return result;
    }
}
