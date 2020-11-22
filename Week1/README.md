学习笔记



##  PriorityQueue源码分析

1、 元素不能为null，在源码中add方法有体现

```java
public boolean add(E e) {
    return offer(e);
}

public boolean offer(E e) {
    if (e == null)
        throw new NullPointerException();
    modCount++;
    int i = size;
    if (i >= queue.length)
        grow(i + 1);
    size = i + 1;
    if (i == 0)
        queue[0] = e;
    else
        siftUp(i, e);
    return true;
}
```

add方法里直接调用offer方法，里面第一句就告知，如果元素为null会抛出 NPE；



2、PriorityQueue是非线程安全的类，里面的方法没有涉及到锁相关的东西

3、保存元素的载体其实是一个Object的数组，也就是queue属性，它的默认初始值是11

```java
    /**
     * Priority queue represented as a balanced binary heap: the two
     * children of queue[n] are queue[2*n+1] and queue[2*(n+1)].  The
     * priority queue is ordered by comparator, or by the elements'
     * natural ordering, if comparator is null: For each node n in the
     * heap and each descendant d of n, n <= d.  The element with the
     * lowest value is in queue[0], assuming the queue is nonempty.
     */
    transient Object[] queue; // non-private to simplify nested class access
```

当元素的大小超过queue的length的时候会发生扩容，也就是触发grow方法，里面的实现和ArrayList差不多，就是申请一个更大的数组，然后把元素copy到新的数组里面

```java
    /**
     * Increases the capacity of the array.
     *
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        int oldCapacity = queue.length;
        // Double size if small; else grow by 50%
        int newCapacity = oldCapacity + ((oldCapacity < 64) ?
                                         (oldCapacity + 2) :
                                         (oldCapacity >> 1));
        // overflow-conscious code
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        queue = Arrays.copyOf(queue, newCapacity);
    }
```

4、回过头在看offer方法，当数组也就是queue里面没有元素的时候，会把第一个元素直接插入到queue[0]这个位置，否则会调用siftUp方法

```java
    public boolean offer(E e) {
        if (e == null)
            throw new NullPointerException();
        modCount++;
        int i = size;
        if (i >= queue.length)
            grow(i + 1);
        size = i + 1;
        if (i == 0)
            queue[0] = e;
        else
            siftUp(i, e);
        return true;
    }
```

```java
    /**
     * Inserts item x at position k, maintaining heap invariant by
     * promoting x up the tree until it is greater than or equal to
     * its parent, or is the root.
     *
     * To simplify and speed up coercions and comparisons. the
     * Comparable and Comparator versions are separated into different
     * methods that are otherwise identical. (Similarly for siftDown.)
     *
     * @param k the position to fill
     * @param x the item to insert
     */
    private void siftUp(int k, E x) {
        if (comparator != null)
            siftUpUsingComparator(k, x);
        else
            siftUpComparable(k, x);
    }
```

由上图可知，siftUp方法会根据队列里的泛型来判断是否实现了comparator方法来比较有限级，如果实现了，执行siftUpUsingComparator方法，反之执行siftUpComparable方法。两个方法基本一致，这里拿siftUpUsingComparator方法说明

```java
    private void siftUpUsingComparator(int k, E x) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Object e = queue[parent];
            if (comparator.compare(x, (E) e) >= 0)
                break;
            queue[k] = e;
            k = parent;
        }
        queue[k] = x;
    }
```

这里有个巧妙的地方，里用了位运算直接找到了父节点，如果子节点比父节点大就直接跳出循环，如果子节点比父节点小就就交换位置



