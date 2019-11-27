import java.util.HashSet;

/**
 * Remove duplicates from Linked List
 */

public class LinkedListDuplicateRemove {

    public static void main(String[] args) {
        // Init list
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(new MyLinkedList.Node(1));
        linkedList.add(new MyLinkedList.Node(2));
        linkedList.add(new MyLinkedList.Node(1)); // dupe element
        System.out.println(linkedList); // 1->2->1
        // Hash set to detect dupes
        HashSet<Integer> hashSet = new HashSet<>();
        // Cycle list to find and remove dupes using set
        MyLinkedList.Node<Integer> node = linkedList.head;
        MyLinkedList.Node<Integer> previous = null;
        while(node != null) {
            if (hashSet.contains(node.getData())) {
                previous.setNext(node.next()); // remove dupe relinking previous node
            } else {
                hashSet.add(node.getData()); // remember int
                previous = node; // move previous to current
            }
            node = node.next(); // go next element
        }
        // Show result
        System.out.println(linkedList); // 1->2
    }

}
