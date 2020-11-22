package demo.base;

/**
 * @Author zhouchao
 * @Date 2020/11/20 11:18
 * @Description 重写Deque的addFirst和addLast方法
 **/

public class OverrideDeque<T> {
    private Node<T> head;
    private Node<T> tail;

    private class Node<T> {
        T element;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }
    }

    public void addFirst(T t) {
        Node<T> next = head;
        Node<T> node = new Node<>(null, t, head);
        head = node;
        if (next == null) {
            tail = node;
        } else {
            next.prev = node;
        }
    }

    public void addLast(T t) {
        Node<T> prev = tail;
        Node<T> node = new Node<>(prev, t, null);
        tail = node;
        if (prev ==null){
            head = node;
        }else{
            prev.next = node;
        }
    }


}
