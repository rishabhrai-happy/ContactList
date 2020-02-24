package defination;

import Cadt.ContactAdt;

public class ContactList1 <E> implements ContactAdt<E> {
    int size = 0;
    private Node<E> head = null;
    private Node<E> tail = null;

    /**

     *
     * @param item the data that is to be stored in the node.
     * @return true when the node adds in the linked list.
     */
    private boolean addFirst(E item) {
        // create a node that will store the data 'item'
        Node<E> node;
        // check if the linked list is empty
        if (head == null) {

            node = new Node<>(item, null, null);
            head = node;
            tail = node;
        } else {

            node = new Node<>(item, null, head);
            head.previous = node;
            head = node;
        }
        size++;
        return true;
    }

    /**
     *
     * @param node the after which a new node is to be added.
     * @param item the data which is to be stored in the node.
     * @return true when the node adds to the linked list.
     */
    private boolean addAfter(Node<E> node, E item) {

        Node<E> nextNode = node.getNext();


        if (nextNode == null) {

            Node<E> newNode = new Node<>(item, node, null);
            node.next = newNode;
            tail = newNode;
        } else {

            Node<E> newNode = new Node<>(item, node, nextNode);
            node.next = newNode;
            nextNode.previous = newNode;
        }

        size++;
        return true;
    }

    /**

     *
     * @param index index of the node starting from 0
     * @return the node at the given index
     */
    public Node<E> getNode(int index) {
        Node<E> response = head;
        for (int i = 0; i < index && response != null; i++) {
            response = response.getNext();
        }
        return response;
    }

    /**
     * @param index the index at which the new node is to be added.
     * @param item  the data of the node to be added.
     * @return true when the node adds to the linked list.
     * @throws IndexOutOfBoundsException when the index is out of range (index < 0 || index > size).
     */
    public boolean add(int index, E item) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        } else if (index == 0) {
            return addFirst(item);
        } else {
            return addAfter(getNode(index - 1), item);
        }
    }

    @Override
    public boolean add(E item) {
        return add(size, item);
    }

    @Override
    public E remove(int data) {
        return null;
    }


    @Override
    public int search(E item) {
        return 0;
    }

    @Override
    public void sort() {

    }

    /*
     * This toString() method will allow us to print the whole linked list with just
     * sending an object of this list as a parameter to the System.out.print() method.
     * */
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("[");


        Node<E> currentNode = head;
        for (int i = 0; i < size && currentNode != null; i++) {
            // fetch the data from the current node.
            E data = currentNode.getData();

            // append the data to the string builder object
            sb.append(data);

            // append the commas after the data
            sb.append(i < size - 1 ? ", " : "");

            // change the reference of the temp variable to the next node.
            currentNode = currentNode.getNext();
        }
        sb.append("]");
        return sb.toString();
    }

    public static class Node<E> {
        private E data;
        private Node<E> previous;
        private Node<E> next;

        private Node(E data, Node<E> previous, Node<E> next) {
            this.data = data;
            this.previous = previous;
            this.next = next;
        }

       public E getData() {
            return data;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public Node<E> getNext() {
            return next;
        }



    }
}

