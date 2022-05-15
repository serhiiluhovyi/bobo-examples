package com.sluhovyi._04_datastructure;

import java.util.Objects;

public class HashTable<T> {

  @SuppressWarnings({"unchecked", "rewtype"})
  private Node<T>[] table = new Node[4];

  /**
   * Adds an element to the hash table. Does not support duplicate elements.
   *
   * @param element
   * @return true if it was added
   */
  public boolean add(T element) {
    return add(table, element);
  }

  public boolean add(Node<T>[] table, T element) {
    var newNode = new Node<>(Objects.requireNonNull(element));
    var index = calculateIndex(table.length, element);
    if (table[index] == null) {
      table[index] = newNode;
    } else {
      var current = table[index];
      while (current.next != null) {
        if (current.element.equals(element)) {
          return false;
        }
        current = current.next;
      }
      current.next = newNode;
    }
    return true;
  }

  private int calculateIndex(int arrayLength, T element) {
    return Math.abs(element.hashCode() % arrayLength);
  }

  /**
   * Prints a hash table according to the following format 0: Andrii -> Taras 1: Stas 2: Serhii ...
   */
  public void printTable() {
    var n = table.length;
    for (int i = 0; i < n; i++) {
      System.out.print(i + ": ");
      var current = table[i];
      if (current != null) {
        while (current.next != null) {
          System.out.print(current.element + " -> ");
          current = current.next;
        }
        System.out.println(current.element);
      } else {
        System.out.println();
      }
    }
  }

  /**
   * Creates a new underlying table with a given size and add all elements to the new table.
   *
   * @param newSize
   */
  public void resize(int newSize) {
    var n = table.length;
    Node<T>[] newTable = new Node[newSize];
    for (int i = 0; i < n; i++) {
      var current = table[i];
      while (current != null) {
        add(newTable, current.element);
        current = current.next;
      }
    }
    table = newTable;
  }
}
