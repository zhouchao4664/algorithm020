学习笔记

## 排序

我自己做了些改进，利用java的泛型，不止支持int类型的排序，实现了Comparable接口的类都可以排序，sort是自己写的排序接口，利用多态可以自行实现设计模式，比如策略模式，代码如下

~~~java
public interface Sort<T extends Comparable<T>> {

    void sort(T[] values);

}
~~~



### 冒泡排序

~~~ java
public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {

        // Conparable.compareTo
        // <    return -1
        // =    return 0
        // >    return 1

        int size = values.length - 1;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size-i; j++) {
                // 第i号元素与i+1对比
                if (values[j+1].compareTo(values[j]) < 1) {
                    // 交换元素[i+1] = [i]
                    T t = values[j+1];
                    values[j+1] = values[j];
                    values[j] = t;
                    // 如果只是数字，不需要临时变量
                    // [0] = 3 , [1] = 2
                    // [1] = [1](2) + [0](3) = 5
                    // [0] = [1](5) - [0](3) = 2
                    // [1] = [1](5) - [0](2) = 3
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] values = of(3, 2, 1, 5, 4);
        Sort<Integer> sort = new BubbleSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }

    public static <T> T[] of(T... values) {
        return values;
    }
}
~~~



### 快速排序

~~~java
public class FastSort {
    @Override
    public void sort(T[] values) {
        int high = values.length - 1;
        int low = 0;
        quickSort(values, low, high);
    }

    private void quickSort(T[] values, int low, int high) {

        // 自己写的，太啰嗦了
        /*int start = low;
        int end = high;
        int key = a[low];


        while (end > start) {
            //从后往前比较
            while (end > start && a[end] >= key)  //如果没有比关键值小的，比较下一个，直到有比关键值小的交换位置，然后又从前往后比较
                end--;
            if (a[end] <= key) {
                int temp = a[end];
                a[end] = a[start];
                a[start] = temp;
            }
            //从前往后比较
            while (end > start && a[start] <= key)//如果没有比关键值大的，比较下一个，直到有比关键值大的交换位置
                start++;
            if (a[start] >= key) {
                int temp = a[start];
                a[start] = a[end];
                a[end] = temp;
            }
            //此时第一次循环比较结束，关键值的位置已经确定了。左边的值都比关键值小，右边的值都比关键值大，但是两边的顺序还有可能是不一样的，进行下面的递归调用
        }
        //递归
        if (start > low) sort(a, low, start - 1);//左边序列。第一个索引位置到关键值索引-1
        if (end < high) sort(a, end + 1, high);//右边序列。从关键值索引+1到最后一个*/

        if (high <= low) return;
        int pivot = high;
        int counter = low;
        for (int i = low; i < high; i++) {
            if (values[i].compareTo(values[pivot]) < 0) {
                T temp = values[counter];
                values[counter] = values[i];
                values[i] = temp;
                counter++;
            }
        }
        T temp = values[pivot];
        values[pivot] = values[counter];
        values[counter] = temp;

        quickSort(values, low, counter - 1);
        quickSort(values, counter + 1, high);
    }
}
~~~



### 插入排序

~~~java
public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    @Override
    public void sort(T[] values) {
        // Conparable.compareTo
        // <    return -1
        // =    return 0
        // >    return 1

        int size = values.length;
        for (int i = 1; i < size; i++) {
            //高位数 t
            // 不该在这里声明临时变量T t = values[i];
            for (int j = i - 1; j >= 0; j--) {
                if (values[j+1].compareTo(values[j]) < 1) {
                    T t = values[j+1];
                    values[j+1] = values[j]; //高位获取低位的值
                    values[j] = t; //低位获取高位的值
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] values = of(3, 2, 1, 5, 4);
        //Integer[] values = of(3, 1, 2, 5, 4);
        Sort<Integer> sort = new InsertionSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }

    public static <T> T[] of(T... values) {
        return values;
    }
}
~~~

