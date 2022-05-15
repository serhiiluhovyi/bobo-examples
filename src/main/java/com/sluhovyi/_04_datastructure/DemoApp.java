package com.sluhovyi._04_datastructure;

import java.util.List;
import java.util.Objects;

public class DemoApp {

  public static void main(String[] args) {
    //1
    var listHead = createLinkedList(7, 1, 5, 9, 4);
    printLinkedList(listHead);

    //2
    List<String> names = List.of("Andriy", "Serhii", "Nazar", "Taras", "Stas", "Yurii", "Tetiana",
        "Valerii");
    var namesTable = new HashTable<String>();
    names.forEach(namesTable::add);
    namesTable.printTable();

    System.out.println("\n RESIZING TABLE...\n");
    namesTable.resize(16);
    namesTable.printTable();
  }

  /**
   * Creates a linked list based on the input array and returns a head
   */
  public static <T> Node<T> createLinkedList(T... elements) {
    Objects.requireNonNull(elements);
    var n = elements.length;
    Objects.checkIndex(0, n);
    var head = new Node<>(elements[0]);
    var current = head;
    for (int i = 1; i < n; i++) {
      current.next = new Node<>(elements[i]);
      current = current.next;
    }
    return head;
  }

  /**
   * Prints a linked list with arrows like this
   * head:5 -> 7 -> 1 -> 4
   *
   * @param head the first element of the list
   */
  public static void printLinkedList(Node<?> head) {
    var current = Objects.requireNonNull(head);
    System.out.print("h:");
    while (current.next != null) {
      System.out.print(current.element + " -> ");
      current = current.next;
    }
    System.out.println(current.element + "\n\n");
  }

  /**
   * Accepts a linked list head, reverses all elements and returns a new head (the last element).
   * PLEASE NOTE that it should not create new nodes, only change the next references of the
   * existing ones. E.g. you have a like "head:5 -> 7 -> 1 -> 4" should this method will return
   * "head:4 -> 1 -> 7 -> 5"
   *
   * @param head the first element of the list
   * @param <T>  element type
   * @return new head
   */
  public static <T> Node<T> reverseLinkedList(Node<T> head) {
    throw new UnsupportedOperationException();
  }

}
