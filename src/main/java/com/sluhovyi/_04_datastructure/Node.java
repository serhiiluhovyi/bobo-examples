package com.sluhovyi._04_datastructure;

public class Node<T> {
  T element;
  Node<T> next;

  public Node(T element) {
    this.element = element;
  }
}
