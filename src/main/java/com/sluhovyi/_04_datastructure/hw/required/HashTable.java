package com.sluhovyi._04_datastructure.hw.required;

import java.util.Objects;

/**
 * A simple implementation of the Hash Table that allows storing a generic key-value pair. The table
 * itself is based on the array of {@link Node} objects.
 * <p>
 * An initial array capacity is 16.
 * <p>
 * Every time a number of elements is equal to the array size that tables gets resized (it gets
 * replaced with a new array that it twice bigger than before). E.g. resize operation will replace
 * array of size 16 with a new array of size 32. PLEASE NOTE that all elements should be reinserted
 * to the new table to make sure that they are still accessible  from the outside by the same key.
 *
 * @param <K> key type parameter
 * @param <V> value type parameter
 */
public class HashTable<K, V> {

  private int initialCapacity = 16;
  private int capacity;
  private int size = 0;
  private Node<K, V>[] table;

  @SuppressWarnings({"unchecked", "rawtype"})
  public HashTable() {
    this.table = new Node[initialCapacity];
    this.capacity = initialCapacity;
  }

  /**
   * Puts a new element to the table by its key. If there is an existing element by such key then it
   * gets replaced with a new one, and the old value is returned from the method. If there is no
   * such key then it gets added and null value is returned.
   *
   * @param key   element key
   * @param value element value
   * @return old value or null
   */
  public V put(K key, V value) {
    Objects.requireNonNull(key);
    if (size == table.length) {
      return putWithResizingAndReorganizing(key, value);
    }
    V v = putVal(key, value);
    if (v == null) {
      size++;
    }
    return v;
  }

  /**
   * Prints a content of the underlying table (array) according to the following format:
   * 0:key1:value1 -> key2:value2
   * 1:
   * 2: key3:value3 ...
   */
  public void printTable() {
    var n = table.length;
    for (int i = 0; i < n; i++) {
      System.out.print(i + ": ");
      var current = table[i];
      if (current != null) {
        while (current.next != null) {
          System.out.print(current.key + ":" + current.value + " -> ");
          current = current.next;
        }
        System.out.println(current.key + ":" + current.value);
      } else {
        System.out.println();
      }
    }
  }

  private V putVal(K key, V value) {
    var newNode = new Node<>(key, value);
    var index = calculateIndex(capacity, key);
    if (table[index] == null) {
      table[index] = newNode;
    } else {
      var current = table[index];
      while (current != null) {
        if (Objects.equals(current.key, key)) {
          V oldValue = current.value;
          current.value = value;
          return oldValue;
        }
        if (current.next != null) {
          current = current.next;
        } else {
          current.next = newNode;
          return null;
        }
      }
    }
    return null;
  }

  public int getSize() {
    return this.size;
  }

  private V putWithResizingAndReorganizing(K key, V value) {
    this.capacity *= 2;
    Node<K, V>[] oldTable = table;
    this.table = new Node[capacity];
    this.size = 0;
    for (Node<K, V> node : oldTable) {
      while (node != null) {
        put(node.key, node.value);
        node = node.next;
      }
    }
    return put(key, value);
  }

  private int calculateIndex(int arrayLength, K key) {
    return Math.abs(key.hashCode() % arrayLength);
  }

}
