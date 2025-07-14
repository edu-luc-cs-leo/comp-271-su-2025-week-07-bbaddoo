/**
 * A simple hasht table is an array of linked lists. In its simplest form, a
 * linked list is represented by its first node. Typically we label this node as
 * "head". Here, however, we'll know it's the first node of the list because it
 * will be placed in an array element. For example, if we have 4 linked lists,
 * we know that the "head" of the third one can be found in position [2] of the
 * underlying array.
 */
public class HashTable<E extends Comparable<E>> {

    /**
     * Underlying array of nodes. Each non empty element of this array is the first
     * node of a linked list.
     */
    private Node[] underlying;

    /**
     * Default size for the underlying array. Users may specify any size, but the
     * default constructor will use this size.
     */
    private static final int DEFAULT_SIZE = 4;

    /** Basic constructor with user-specified size */
    public HashTable(int size) {
        this.underlying = new Node[size];
    }

    /** Default constructor, passes defauilt size to basic constructor */
    public HashTable() {
        this(DEFAULT_SIZE);
    }

    /**
     * Adds a node, with the specified content, to a linked list in the underlying
     * array.
     * 
     * @param content E The content of a new node, to be placed in the array.
     */
    public void add(E content) {
        int hashCode = content.hashCode(); //retrive the hashcode
          //make sure its not negative and within the array
        int index = Math.abs(hashCode) % this.underlying.length;

        //create a new node with what is given previously
        Node<E> newNode = new Node <E>(content);
        //if the node is empty then put it here 
        if (underlying[index] == null) {
            underlying[index] = newNode;
        } else {
            // Make the new node point to the existing one
            newNode.setNext(underlying[index]);

            // put the new node at the front of the list
            underlying[index] = newNode;
        }
        
    } // method add
/**
     * returns a string representing the hash table 
     * showing all the lists and whats in each one
     * 
     * @param Show full list.
     */

    public String toString() {
        //start with an empty string 
    String result = "";
     //loop through each index of the array 
    for (int i = 0; i < underlying.length; i++) {
        //add the current one to the output
        result += "Index " + i + ": ";
         //get the first node at this index
        Node<E> current = underlying[i];
        //if there is no node then show that it is empty 
        if (current == null) {
            result += "empty";
        } else { //if it is not empty then continue to add the other node to the output
            while (current != null) {
                result += current;
                if (current.hasNext()) {
                    result += " -> ";  //if theres another node add an arrow for simplicity
                }
                current = current.getNext();  //move to the next node 
            }
        }

        result += "\n";  //move to a new line after each one to be cleaner 
    }

    return result;  //return the completed list in terms of the hash table.

}
}




